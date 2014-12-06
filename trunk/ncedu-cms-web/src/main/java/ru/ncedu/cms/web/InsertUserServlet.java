/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.cms.web;

import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "InsertUserServlet", urlPatterns = {"/InsertUserServlet"})
public class InsertUserServlet extends HttpServlet {
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

          String userId = request.getParameter("userId");       
          String firstname = request.getParameter("firstname");
          String lastname = request.getParameter("lastname");   
          String email  = request.getParameter("email");
          String password  = request.getParameter("password");
          String groupId  = request.getParameter("groupId");
          String registerWhen  = request.getParameter("registerWhen");
          String lastLogin  = request.getParameter("lastLogin");

          if (StringUtils.isNotEmpty(userId)) {
            User user = userDAO.findById(Long.valueOf(userId));
                
                if (user == null) {
                User newUser = new User();
                newUser.setUserId(Long.valueOf(userId));
                newUser.setFirstName(firstname);
                newUser.setLastName(lastname);
                newUser.setEmail(email);
                newUser.setPassword(password);
                newUser.setGroupId(Long.valueOf(groupId));
                newUser.setRegisterWhen(new Date(System.currentTimeMillis()));
                newUser.setLastLogin(new Date(System.currentTimeMillis()));
                userDAO.insert(newUser);
                
                List<User> users = userDAO.findAll();
                request.setAttribute("users", users);
                request.getRequestDispatcher("users.jsp").forward(request, response);
            }
            else {
            request.setAttribute("message", "user with id=" + userId + " exist");
            request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
        else
        {
          List<User> users = userDAO.findAll();
          request.setAttribute("users", users);
          request.getRequestDispatcher("addUser.jsp").forward(request, response);   
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
