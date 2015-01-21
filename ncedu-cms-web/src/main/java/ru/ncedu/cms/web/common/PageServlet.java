package ru.ncedu.cms.web.common;

import ru.ncedu.core.data.accessobjects.PageDAO;
import ru.ncedu.core.data.accessobjects.SettingDAO;
import ru.ncedu.core.data.entities.Page;
import ru.ncedu.core.data.entities.Setting;
import ru.ncedu.core.data.factories.DAOFactory;
import ru.ncedu.core.jstree.JSTreeBean;
import ru.ncedu.core.security.RightBean;
import ru.ncedu.core.utils.StringUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.google.gson.Gson;
import ru.ncedu.core.jstree.JSTreeCache;

@WebServlet(name = "PageServlet", urlPatterns = {"/page"})
public class PageServlet extends HttpServlet {

    @EJB
    JSTreeBean jsTreeBean;

    @EJB
    RightBean rightBean;
    
    @EJB
    JSTreeCache jsTreeCache;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pageId = request.getParameter("id");
        if (StringUtils.isEmpty(pageId)) {
            SettingDAO settingDAO = DAOFactory.getDAOFactory(DAOFactory.DAOType.LOCAL).getSettingDAO();
            Setting defaultPageSetting = settingDAO.findByName("default_page");
            pageId = defaultPageSetting.getValue();
        }

        if (rightBean.canRead(Long.valueOf(pageId)) > 0L) {
            PageDAO pageDAO = DAOFactory.getDAOFactory(DAOFactory.DAOType.LOCAL).getPageDAO();
            Page page = pageDAO.findById(Long.valueOf(pageId));
            if (page == null) {
                request.setAttribute("message", "Page with id=" + pageId + " doesn't exist");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

            request.setAttribute("page", page);
            request.setAttribute("right", rightBean.getRight(Long.valueOf(pageId)));
            
            Gson gson = new Gson();
            String jsTreeData = gson.toJson(jsTreeCache.getPageTree());
            request.setAttribute("jsTreeData", jsTreeData);
            //request.setAttribute("jsTreeData", jsTreeBean.getPagesTreeData("1"));

            request.getRequestDispatcher("/views/page/main.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
