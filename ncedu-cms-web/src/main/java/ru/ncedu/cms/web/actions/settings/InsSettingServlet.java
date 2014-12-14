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
import ru.ncedu.core.utils.StringUtils;

/**
 *
 * @author dmitry
 */
@WebServlet(name = "InsSettingServlet", urlPatterns = {"/inssetting"})
public class InsSettingServlet extends HttpServlet {
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
            String name = request.getParameter("name");
            String value = request.getParameter("value");

            if (StringUtils.isNotEmpty(name)) {
                Setting setting = settingDAO.findByName(name);
                if (setting == null) {
                    Setting newSetting = new Setting();
                    newSetting.setName(name);
                    newSetting.setValue(value);
                    settingDAO.insert(newSetting);

                    List<Setting> settings = settingDAO.findAll();
                    request.setAttribute("settings", settings);
                    request.getRequestDispatcher("settings.jsp").forward(request, response);
                }
                
                else {
                    request.setAttribute("message", "setting = " + name + " exist");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            }
            
            else {
                List<Setting> settings = settingDAO.findAll();
                request.setAttribute("settings", settings);
                request.getRequestDispatcher("insSetting.jsp").forward(request, response);   
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
