/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.cms.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ru.ncedu.core.data.accessobjects.UserDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalUserDAO;
import ru.ncedu.core.data.entities.User;
import ru.ncedu.core.utils.Encrypt;
import ru.ncedu.core.utils.StringUtils;

/**
 * 
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * User login processing
     * @param request - request data
     * @param response - response data
     * @param userDAO - user data source
     * @retruns message for user
     */
    private String login(HttpServletRequest request, UserDAO userDAO)
    {
        Map<String, String[]> parameters = request.getParameterMap();
        if(parameters.containsKey("login"))
        {
            String login = parameters.get("login")[0];
            login = login.trim();
            if(StringUtils.isEmpty(login))
            {
                return "<span style=\"color:#ff0000\">Enter email</span>";
            }
            
            if(parameters.containsKey("password"))
            {
                String password = parameters.get("password")[0];
                if(StringUtils.isEmpty(password))
                {
                    return "<span style=\"color:#ff0000\">Enter password</span>";
                }                
                password = Encrypt.getHash(password);
                
                User user = userDAO.findByEmail(login);                
                if(user != null)
                {
                    if(user.getPassword().equals(password))
                    {
                        HttpSession session = ((HttpServletRequest)request).getSession();
                        session.setAttribute("user", user);
                        
                        return "<span style=\"color:#009900\">Success</span>";
                    }
                    else
                    {
                        return "<span style=\"color:#ff0000\">Invalid login or password</span>";
                    }
                }
                else
                {
                    return "<span style=\"color:#ff0000\">Invalid login or password</span>";
                }
            }         
        }
        
        return "";
    }
    
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
        
        HttpSession session = ((HttpServletRequest)request).getSession();
        String loginStatusText = "";
        String action = request.getParameter("action");
  
        if(StringUtils.isNotEmpty(action))
        {        
            switch(action)
            {
                case "logout":
                    session.setAttribute("user", LocalUserDAO.GUEST); break;
                case "login":
                    loginStatusText = login(request, new LocalUserDAO());
            }    
        }
        else
        {
            loginStatusText = login(request, new LocalUserDAO());
        }
        
        request.setAttribute("loginStatusText", loginStatusText);
        request.setAttribute("currentGroup", ((User)session.getAttribute("user")).getGroupId());
        
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
