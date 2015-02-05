/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.cms.web.actions.groups;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ru.ncedu.HelloBean;
import ru.ncedu.core.data.accessobjects.GroupDAO;
import ru.ncedu.core.data.entities.Group;
import ru.ncedu.core.data.factories.DAOFactory;
import ru.ncedu.core.jstree.JSTreeCache;

/**
 *
 * @author Sacred
 */
@WebServlet(name = "UpdGroupServlet", urlPatterns = {"/updgroup"})
public class UpdGroupServlet extends HttpServlet {
    
    @EJB
    HelloBean helloBean;
    
    @EJB
    JSTreeCache jsTreeCache;

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
        GroupDAO groupDAO = DAOFactory.getDAOFactory(DAOFactory.DAOType.LOCAL).getGroupDAO();
       
        String id = request.getParameter("id");
        String groupId = request.getParameter("groupId");
        String parentId = request.getParameter("parentId");
        String name = request.getParameter("name");
        
        
        if (groupId == null ) {
            List<Group> groups = groupDAO.findAll();    
            Group group = groupDAO.findById(Long.valueOf(id));            
           
            request.setAttribute("groups", groups);            
           
            request.setAttribute("groupId", group.getGroupId());           
            request.setAttribute("parentNum", group.getParentId());
            request.setAttribute("name", group.getName());
            
            request.getRequestDispatcher("/views/mockup/updGroup.jsp").forward(request, response);            
        }
        else {
            Group group = groupDAO.findById(Long.valueOf(groupId));

            group.setParentId(Long.valueOf(parentId));
            group.setName(name);
            groupDAO.update(group);
            jsTreeCache.updateGroupRecord(group);

            List<Group> groups = groupDAO.findAll();
            request.setAttribute("groups", groups);
            request.getRequestDispatcher("/views/mockup/groups.jsp").forward(request, response);
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
