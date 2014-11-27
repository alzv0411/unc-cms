/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.data.accessobjects.impl;

import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.ncedu.core.data.accessobjects.CommentDAO;
import ru.ncedu.core.data.entities.Comment;

/**
 *
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
public class LocalCommentDAOTest {
    
    public LocalCommentDAOTest() {
    }
    
    /**
     * Test of insert method, of class LocalCommentDAO.
     */
    @Test
    public void testInsert() {
        CommentDAO instance = new LocalCommentDAO();
        
        Comment entity = null;
        int expResult = 0;
        int result = instance.insert(entity);
        assertEquals(expResult, result);
        
        entity = new Comment(1L, 1L, null, 1L, null, 1L, null);
        expResult = -1;
        result = instance.insert(entity);
        assertEquals(expResult, result);
        
        entity.setCommentId(101L);
        expResult = 1;
        result = instance.insert(entity);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class LocalCommentDAO.
     */
    @Test
    public void testUpdate() {
        CommentDAO instance = new LocalCommentDAO();
        
        Comment entity = null;
        assertFalse(instance.update(entity));
        
        entity = new Comment(-1L, 1L, null, 1L, null, 1L, null);
        assertFalse(instance.update(entity));
        
        entity = new Comment(1L, 1L, null, 1L, null, 1L, null);
        assertTrue(instance.update(entity));
    }

    /**
     * Test of delete method, of class LocalCommentDAO.
     */
    @Test
    public void testDelete() {
        CommentDAO instance = new LocalCommentDAO();
        
        Comment entity = null;
        assertFalse(instance.delete(entity));
        
        entity = new Comment(-1L, 1L, null, 1L, null, 1L, null);
        assertFalse(instance.delete(entity));
        
        entity = new Comment(2L, 1L, null, 1L, null, 1L, null);
        assertTrue(instance.delete(entity));
    }

    /**
     * Test of findById method, of class LocalCommentDAO.
     */
    @Test
    public void testFindById() {
        CommentDAO instance = new LocalCommentDAO();
        
        long id = 0L;
        Comment result = instance.findById(id);
        assertNull(result);
        
        id = 3L;
        result = instance.findById(id);
        assertNotNull(result);
    }

    /**
     * Test of findAll method, of class LocalCommentDAO.
     */
    @Test
    public void testFindAll() {
        LocalCommentDAO instance = new LocalCommentDAO();
        Collection<Comment> result = instance.findAll();
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
    
}
