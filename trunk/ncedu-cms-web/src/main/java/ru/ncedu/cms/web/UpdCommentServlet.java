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
package ru.ncedu.cms.web;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.ncedu.HelloBean;
import ru.ncedu.core.data.accessobjects.CommentDAO;
import ru.ncedu.core.data.entities.Comment;
import ru.ncedu.core.data.factories.DAOFactory;
import ru.ncedu.core.utils.StringUtils;

/**
 * 
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
@WebServlet(name = "UpdCommentServlet", urlPatterns = {"/updcomment"})
public class UpdCommentServlet extends HttpServlet {

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
     * private long commentId;
      private long pageId;
      private String comment;    
    private long createdBy;
    private Date createdWhen;    
    private long modifiedBy;
    private Date modifiedWhen;
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CommentDAO commentDAO = DAOFactory.getDAOFactory(DAOFactory.DAOType.LOCAL).getCommentDAO();
       
        String id = request.getParameter("id");
        String commentId = request.getParameter("commentId");
        String pageId = request.getParameter("pageId");
        String commentTxt = request.getParameter("comment");
        String createdBy = request.getParameter("createdBy");
       // String createdWhen = request.getParameter("createdWhen");
        String modifiedBy = request.getParameter("modifiedBy");
       // String modifiedWhen = request.getParameter("modifiedWhen");
        
        if (commentId == null ) {

            Comment comment = commentDAO.findById(Long.valueOf(id));
            request.setAttribute("commentId", comment.getCommentId());           
            request.setAttribute("pageId", comment.getPageId());
            request.setAttribute("comment", comment.getComment());
            request.setAttribute("createdBy", comment.getCreatedBy());
            request.setAttribute("modifiedBy", comment.getModifiedBy());
            
            
            request.getRequestDispatcher("updComment.jsp").forward(request, response);
            
            }
            else {
            Comment newComment = commentDAO.findById(Long.valueOf(commentId));
           
             newComment.setCommentId(Long.valueOf(commentId));
             newComment.setPageId(Long.valueOf(pageId));
             newComment.setComment(commentTxt);
             newComment.setCreatedBy(Long.valueOf(createdBy));                          
             newComment.setModifiedBy(Long.valueOf(modifiedBy));  
             newComment.setModifiedWhen(new Date(System.currentTimeMillis())); 
             commentDAO.update(newComment); 
           
            List<Comment> comments = commentDAO.findAll();
            request.setAttribute("comments", comments);
            request.getRequestDispatcher("comments.jsp").forward(request, response);
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
