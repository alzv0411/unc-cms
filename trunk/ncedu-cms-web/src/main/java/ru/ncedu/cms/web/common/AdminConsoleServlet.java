package ru.ncedu.cms.web.common;

import com.google.gson.Gson;
import ru.ncedu.core.data.accessobjects.UserDAO;
import ru.ncedu.core.data.entities.User;
import ru.ncedu.core.data.factories.DAOFactory;
import ru.ncedu.core.jstree.JSTreeBean;
import ru.ncedu.core.security.AuthentificationBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import ru.ncedu.core.jstree.JSTreeCache;

@WebServlet(name = "AdminConsoleServlet", urlPatterns = {"/adminConsole"})
public class AdminConsoleServlet extends HttpServlet {

    @EJB
    private AuthentificationBean security;

    @EJB
    JSTreeBean jsTreeBean;
    
    @EJB
    JSTreeCache jsTreeCache;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (security.authorization().getUserId() != 1L) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            UserDAO userDAO = DAOFactory.getDAOFactory(DAOFactory.DAOType.LOCAL).getUserDAO();
            List<User> users = userDAO.findAll();
            request.setAttribute("users", users);

            
            Gson gson = new Gson();
            String jsTreeData = gson.toJson(jsTreeCache.getGroupTree());
            request.setAttribute("jsTreeData", jsTreeData);
            //request.setAttribute("jsTreeData", jsTreeBean.getGroupsTreeData("1"));

            request.getRequestDispatcher("/views/admin/main.jsp").forward(request, response);
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
