/*
 * Copyright 2014 ncedu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.ncedu.cms.web.mockup;

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
 * @author daemon
 */
@WebServlet(name = "SettingServlet", urlPatterns = {"/mockup/setting"})
public class SettingServlet extends HttpServlet {

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

        String settingName = request.getParameter("name");
        if (StringUtils.isNotEmpty(settingName)) {
            Setting setting = settingDAO.findByName(settingName);
            if (setting == null) {
                request.setAttribute("message", "Setting " + settingName + " doesn't exist");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            
            request.setAttribute("setting", setting);
            request.getRequestDispatcher("/views/mockup/setting.jsp").forward(request, response);
        }

        List<Setting> settings = settingDAO.findAll();
        request.setAttribute("settings", settings);
        request.getRequestDispatcher("/views/mockup/settings.jsp").forward(request, response);
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
