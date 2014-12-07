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
package ru.ncedu.core.data.accessobjects.impl;

import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.ncedu.core.data.accessobjects.RightDAO;
import ru.ncedu.core.data.entities.Right;

/**
 *
 * @author dmitry
 */
public class LocalRightDAOTest {
    
    public LocalRightDAOTest() {
    }

    /**
     * Test of insert method, of class LocalRightDAO.
     */
    @Test
    public void testInsertRight() {
        RightDAO instance = new LocalRightDAO();
        
        Right entity = null;
        int expResult = 0;
        int result = instance.insert(entity);
        assertEquals(expResult, result);
        
        entity = new Right(1L, 1L, 1L, 1L);
        expResult = -1;
        result = instance.insert(entity);
        assertEquals(expResult, result);
        
        entity.setGroupId(101L);
        entity.setPageId(101L);
        expResult = 1;
        result = instance.insert(entity);
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class LocalRightDAO.
     */
    @Test
    public void testUpdateRight() {
        RightDAO instance = new LocalRightDAO();
        
        Right entity = null;
        assertFalse(instance.update(entity));
        
        entity = new Right(1001L, 1L, 1L, 1L);
        assertFalse(instance.update(entity));
        
        entity = new Right(1L, 1L, 1L, 1L);
        assertTrue(instance.update(entity));
    }

    /**
     * Test of delete method, of class LocalRightDAO.
     */
    @Test
    public void testDeleteRight() {
        RightDAO instance = new LocalRightDAO();
        
        Right entity = null;
        assertFalse(instance.delete(entity));
        
        entity = new Right(1001L, 1L, 1L, 1L);
        assertFalse(instance.delete(entity));
        
        entity = new Right(2L, 1L, 1L, 1L);
        assertTrue(instance.delete(entity));
    }

    /**
     * Test of findByGroup method, of class LocalRightDAO.
     */
    @Test
    public void testFindByGroup() {
        RightDAO instance = new LocalRightDAO();
        
        long id = 10L;
        Right result = instance.findByGroup(id);
        assertNull(result);
        
        id = 1L;
        result = instance.findByGroup(id);
        assertNotNull(result);
    }

    /**
     * Test of findByPage method, of class LocalRightDAO.
     */
    @Test
    public void testFindByPage() {
        RightDAO instance = new LocalRightDAO();
        
        long pageId = 0L;
        Right result = instance.findByPage(pageId);
        assertNull(result);
        
        pageId = 1L;
        result = instance.findByPage(pageId);
        assertNotNull(result);
    }

    /**
     * Test of findByGroupIdPageId method, of class LocalRightDAO.
     */
    @Test
//    @Ignore
    public void testFindByGroupIdPageId() {
        RightDAO instance = new LocalRightDAO();
                
        long groupId = 0L;
        long pageId = 101L;        
                
        Right result = instance.findByGroupIdPageId(groupId, pageId);
        Right expResult = instance.findByGroupIdPageId(0, 0);
        assertEquals(expResult, result);
        
        groupId = 1L;
        pageId = 1L;
        result = instance.findByGroupIdPageId(groupId, pageId);
        assertNotNull(result);        
    }

    /**
     * Test of findAll method, of class LocalRightDAO.
     */
    @Test
    public void testFindAll() {
        LocalRightDAO instance = new LocalRightDAO();
        Collection<Right> result = instance.findAll();
        assertNotNull(result);
        assertTrue(result.size() > 0);        
    }
    
}
