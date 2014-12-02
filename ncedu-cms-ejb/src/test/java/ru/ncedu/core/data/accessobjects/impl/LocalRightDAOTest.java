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

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
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
    @Ignore
    public void testInsert() {
        System.out.println("insert");
        Right entity = null;
        LocalRightDAO instance = new LocalRightDAO();
        int expResult = 0;
        int result = instance.insert(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class LocalRightDAO.
     */
    @Test
    @Ignore
    public void testUpdate() {
        System.out.println("update");
        Right entity = null;
        LocalRightDAO instance = new LocalRightDAO();
        boolean expResult = false;
        boolean result = instance.update(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class LocalRightDAO.
     */
    @Test
    @Ignore
    public void testDelete() {
        System.out.println("delete");
        Right entity = null;
        LocalRightDAO instance = new LocalRightDAO();
        boolean expResult = false;
        boolean result = instance.delete(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class LocalRightDAO.
     */
    @Test
    @Ignore
    public void testFindById() {
        System.out.println("findById");
        long id = 0L;
        LocalRightDAO instance = new LocalRightDAO();
        Right expResult = null;
        Right result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByGroup method, of class LocalRightDAO.
     */
    @Test
    @Ignore
    public void testFindByGroup() {
        System.out.println("findByGroup");
        long id = 0L;
        LocalRightDAO instance = new LocalRightDAO();
        Right expResult = null;
        Right result = instance.findByGroup(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByPage method, of class LocalRightDAO.
     */
    @Test
    @Ignore
    public void testFindByPage() {
        System.out.println("findByPage");
        long id = 0L;
        LocalRightDAO instance = new LocalRightDAO();
        Right expResult = null;
        Right result = instance.findByPage(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByGroupIdPageId method, of class LocalRightDAO.
     */
    @Test
    @Ignore
    public void testFindByGroupIdPageId() {
        System.out.println("findByGroupIdPageId");
        long groupId = 0L;
        long pageId = 0L;
        LocalRightDAO instance = new LocalRightDAO();
        Right expResult = null;
        Right result = instance.findByGroupIdPageId(groupId, pageId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class LocalRightDAO.
     */
    @Test
    @Ignore
    public void testFindAll() {
        System.out.println("findAll");
        LocalRightDAO instance = new LocalRightDAO();
        List<Right> expResult = null;
        List<Right> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
