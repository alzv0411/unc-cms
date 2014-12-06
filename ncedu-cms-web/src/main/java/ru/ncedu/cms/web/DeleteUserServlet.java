/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.cms.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.ncedu.core.data.accessobjects.UserDAO;
import ru.ncedu.core.data.entities.User;
import ru.ncedu.core.data.factories.DAOFactory;
import ru.ncedu.core.utils.StringUtils;

/**
 *
 * @author Viktor <rembercert@gmail.com>
 */
@WebServlet(name = "DeleteUserServlet", urlPatterns = {"/DeleteUserServlet"})
public class DeleteUserServlet extends HttpServlet {
UserDAO userDAO = DAOFactory.getDAOFactory(DAOFactory.DAOType.LOCAL).getUserDAO();
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
        
        String userId = request.getParameter("id");
        if (StringUtils.isNotEmpty(userId)) {
            User user = userDAO.findById(Long.valueOf(userId));
            if (user == null) {
                request.setAttribute("message", "User with id=" + userId + " doesn't exist");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
           
             
            userDAO.delete(user);
            
          List<User> users = userDAO.findAll();
          request.setAttribute("users", users);
          request.getRequestDispatcher("users.jsp").forward(request, response);
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
            throws ServletException, IOException 
    {
        
      
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
