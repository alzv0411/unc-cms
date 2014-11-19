/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.data.accessobjects.impl;

import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.ncedu.core.data.accessobjects.SettingDAO;
import ru.ncedu.core.data.entities.Setting;

/**
 *
 * @author daemon
 */
public class LocalSettingDAOTest {
    
    public LocalSettingDAOTest() {
    }

    /**
     * Test of insert method, of class LocalSettingDAO.
     */
    @Test
    public void testInsert() {
        SettingDAO instance = new LocalSettingDAO();
        
        Setting entity = null;
        int expResult = 0;
        int result = instance.insert(entity);
        assertEquals(expResult, result);
        
        entity = new Setting("language", "en");
        expResult = -1;
        result = instance.insert(entity);
        assertEquals(expResult, result);
        
        entity.setName("Kappa");
        expResult = 1;
        result = instance.insert(entity);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class LocalSettingDAO.
     */
    @Test
    public void testUpdate() {
        SettingDAO instance = new LocalSettingDAO();
        
        Setting entity = null;
        assertFalse(instance.update(entity));
        
        entity = new Setting("memes", "genes");
        assertFalse(instance.update(entity));
        
        entity = new Setting("language", "ru");
        assertTrue(instance.update(entity));
    }

    /**
     * Test of delete method, of class LocalSettingDAO.
     */
    @Test
    public void testDelete() {
        SettingDAO instance = new LocalSettingDAO();
        
        Setting entity = null;
        assertFalse(instance.delete(entity));
        
        entity = new Setting("memes","genes");
        assertFalse(instance.delete(entity));
        
        entity = new Setting("foo", "bar");
        assertTrue(instance.delete(entity));
    }

    /**
     * Test of findByName method, of class LocalSettingDAO.
     */
    @Test
    public void testFindByName() {
        SettingDAO instance = new LocalSettingDAO();
        
        String name = "";
        Setting result = instance.findByName(name);
        assertNull(result);
        
        name = "slowpokemode";
        result = instance.findByName(name);
        assertNotNull(result);
    }

    /**
     * Test of findAll method, of class LocalSettingDAO.
     */
    @Test
    public void testFindAll() {
        LocalSettingDAO instance = new LocalSettingDAO();
        Collection<Setting> result = instance.findAll();
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
    
}
