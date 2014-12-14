/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.cms.web.actions.settings;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.ncedu.HelloBean;
import ru.ncedu.core.data.accessobjects.SettingDAO;
import ru.ncedu.core.data.entities.Setting;
import ru.ncedu.core.data.factories.DAOFactory;
//import ru.ncedu.core.utils.StringUtils;

/**
 *
 * @author dmitry
 */
@WebServlet(name = "UpdSettingServlet", urlPatterns = {"/updsetting"})
public class UpdSettingServlet extends HttpServlet {    
    @EJB
    HelloBean helloBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            SettingDAO settingDAO = DAOFactory.getDAOFactory(DAOFactory.DAOType.LOCAL).getSettingDAO();
            String named = request.getParameter("named");
            String name = request.getParameter("name");
            String value = request.getParameter("value");
            
            if (name == null) {
                List<Setting> settings = settingDAO.findAll();    
                Setting setting = settingDAO.findByName(named);
                
                request.setAttribute("settings", settings);
                request.setAttribute("name", setting.getName());
                request.setAttribute("value", setting.getValue());
                request.getRequestDispatcher("updSetting.jsp").forward(request, response);               
            }
            
            else {
                Setting setting = settingDAO.findByName(name);
                setting.setValue(value);
                List<Setting> settings = settingDAO.findAll();
                request.setAttribute("settings", settings);
                request.getRequestDispatcher("settings.jsp").forward(request, response);
            }                                
        }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
