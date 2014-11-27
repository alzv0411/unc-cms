/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.data.accessobjects.impl;

import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.ncedu.core.data.accessobjects.GroupDAO;
import ru.ncedu.core.data.entities.Group;
/**
 *
 * @author Sacred
 */
public class LocalGroupDAOTest {
    
 public LocalGroupDAOTest() {
    }

    /**
     * Test of insertUser method, of class LocalGroupDAO.
     */
    @Test
    public void testInsert() {
        GroupDAO instance = new LocalGroupDAO();
        
        Group entity = null;
        int expResult = 0;
        int result = instance.insert(entity);
        assertEquals(expResult, result);
        
        entity = new Group(1L,1L,null);
        expResult = -1;
        result = instance.insert(entity);
        assertEquals(expResult, result);
        
        entity.setGroupId(101L);
        expResult = 1;
        result = instance.insert(entity);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateUser method, of class LocalUserDAO.
     */
    @Test
    public void testUpdate() {
        GroupDAO instance = new LocalGroupDAO();
        
        Group entity = null;
        assertFalse(instance.update(entity));
        
        entity = new Group(-1L,1L,null);
        assertFalse(instance.update(entity));
        
        entity = new Group(1L,1L, null);
        assertTrue(instance.update(entity));
    }

    /**
     * Test of deleteUser method, of class LocalUserDAO.
     */
    @Test
    public void testDelete() {
        GroupDAO instance = new LocalGroupDAO();
        
        Group entity = null;
        assertFalse(instance.delete(entity));
        
        entity = new Group(-1L, 1L, null);
        assertFalse(instance.delete(entity));
        
        entity = new Group(2L, 1L, null);
        assertTrue(instance.delete(entity));
    }

    /**
     * Test of findById method, of class LocalUserDAO.
     */
    @Test
    public void testFindById() {
        GroupDAO instance = new LocalGroupDAO();
        
        long id = -1L;
        Group result = instance.findById(id);
        assertNull(result);
        
        id = 1L;
        result = instance.findById(id);
        assertNotNull(result);
    }

    /**
     * Test of findAll method, of class LocalUserDAO.
     */
    @Test
    public void testFindAll() {
        LocalGroupDAO instance = new LocalGroupDAO();
        Collection<Group> result = instance.findAll();
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}


