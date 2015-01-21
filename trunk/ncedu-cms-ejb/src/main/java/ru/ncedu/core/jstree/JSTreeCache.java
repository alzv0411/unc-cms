/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.jstree;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.ConcurrencyManagement;
import static javax.ejb.ConcurrencyManagementType.CONTAINER;
import javax.ejb.Lock;
import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import ru.ncedu.core.data.accessobjects.GroupDAO;
import ru.ncedu.core.data.accessobjects.PageDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalGroupDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalPageDAO;
import ru.ncedu.core.data.entities.Group;
import ru.ncedu.core.data.entities.Page;

/**
 * The class <code>JSTreeCache</code> represents jsTree cache
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
@Startup
@Singleton
@ConcurrencyManagement(CONTAINER)
public class JSTreeCache {
    /**
     * Pages tree
     */
    private ConcurrentHashMap<Long, JSTreeRecord> pageTree = new ConcurrentHashMap<>();    
    /**
     * Page data source
     */
    private PageDAO pageDAO = new LocalPageDAO();
    
    /**
     * Grpups tree
     */
    private ConcurrentHashMap<Long, JSTreeRecord> groupTree = new ConcurrentHashMap<>();
    /**
     * Group data source
     */
    private GroupDAO groupDAO = new LocalGroupDAO();
    
    {
        List<Page> pagesList = pageDAO.findAll();
        for(Page page : pagesList)
        {
            pageTree.put(page.getPageId(),
                         new JSTreeRecord(page.getPageId(),
                                          page.getParentId(),
                                          page.getTitle()));
        }
        
        List<Group> groupList = groupDAO.findAll();
        for(Group group : groupList)
        {
            groupTree.put(group.getGroupId(),
                          new JSTreeRecord(group.getGroupId(),
                                           group.getParentId(),
                                           group.getName()));
        }
    }
    
    /**
     * Gets page jsTree records
     * @return page jsTree records
     */
    @Lock(READ)
    public Collection<JSTreeRecord> getPageTree()
    {
        return pageTree.values();
    }
    
    /**
     * Updates page record
     * @param page - page data
     */
    @Lock(WRITE)
    public void updatePageRecord(Page page)
    {
        if(pageTree.containsKey(page.getPageId()))
        {
            pageTree.get(page.getPageId()).update(page.getParentId(), page.getTitle());
        }
    }
    
    /**
     * Adds page record
     * @param page - page data 
     */
    @Lock(WRITE)
    public void addPageRecord(Page page)
    {
        if(!(pageTree.containsKey(page.getPageId())))
        {
            pageTree.put(page.getPageId(),
                         new JSTreeRecord(page.getPageId(),
                                          page.getParentId(),
                                          page.getTitle()));
        }
    }
    
    /**
     * Deletes page record
     * @param pageId - page ID number
     */
    @Lock(WRITE)
    public void deletePageRecord(long pageId)
    {
        if(pageTree.containsKey(pageId))
        {
            pageTree.remove(pageId);
        }
    }
    
    /**
     * Gets group jsTree records
     * @return group jsTree records
     */
    @Lock(READ)
    public Collection<JSTreeRecord> getGroupTree()
    {
        return groupTree.values();
    }
    
    /**
     * Updates group record
     * @param group - group data
     */
    @Lock(WRITE)
    public void updateGroupRecord(Group group)
    {
        if(groupTree.containsKey(group.getGroupId()))
        {
            groupTree.get(group.getGroupId()).update(group.getParentId(), group.getName());
        }
    }
    
    /**
     * Adds group record
     * @param group - group data 
     */
    @Lock(WRITE)
    public void addGroupRecord(Group group)
    {
        if(!(groupTree.containsKey(group.getGroupId())))
        {
            groupTree.put(group.getGroupId(),
                          new JSTreeRecord(group.getGroupId(),
                                           group.getParentId(),
                                           group.getName()));
        }
    }
    
    /**
     * Deletes group record
     * @param groupId - group ID number
     */
    @Lock(WRITE)
    public void deleteGroupRecord(long groupId)
    {
        if(groupTree.containsKey(groupId))
        {
            groupTree.remove(groupId);
        }
    }
}
