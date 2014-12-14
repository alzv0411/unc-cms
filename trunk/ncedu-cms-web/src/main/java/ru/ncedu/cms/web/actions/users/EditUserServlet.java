/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.cms.web.actions.users;

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


/**
 *
 * @author Viktor <rembercert@gmail.com>
 */
@WebServlet(name = "EditUserServlet", urlPatterns = {"/EditUserServlet"})
public class EditUserServlet extends HttpServlet {
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
        
        String id = request.getParameter("id");
        String userId = request.getParameter("userId");              
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String groupId = request.getParameter("groupId");    
        
            if (userId == null ) {
            List<User> users = userDAO.findAll();    
            User user = userDAO.findById(Long.valueOf(id));
            
           
            request.setAttribute("users", users);
          
            request.setAttribute("userId", user.getUserId());           
            request.setAttribute("firstname", user.getFirstName());
            request.setAttribute("lastname", user.getLastName());
            request.setAttribute("email", user.getEmail());
            request.setAttribute("password", user.getPassword());
            request.setAttribute("groupId", user.getGroupId());

            
            request.getRequestDispatcher("editUser.jsp").forward(request, response);
            
            }
            else {
            User user = userDAO.findById(Long.valueOf(userId));
           
             user.setFirstName(firstname);
             user.setLastName(lastname);
             user.setEmail(email);
             user.setPassword(password);
             user.setGroupId(Long.valueOf(groupId));
             
             userDAO.update(user); 
           
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
