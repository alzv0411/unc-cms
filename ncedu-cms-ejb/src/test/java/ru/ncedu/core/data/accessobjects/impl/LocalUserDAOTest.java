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
import ru.ncedu.core.data.accessobjects.UserDAO;
import ru.ncedu.core.data.entities.User;

/**
 *
 * @author Alexander Zvyagintsev <alzv0411@gmail.com>
 */
public class LocalUserDAOTest {
    
    public LocalUserDAOTest() {
    }

    /**
     * Test of insertUser method, of class LocalUserDAO.
     */
    @Test
    public void testInsertUser() {
        UserDAO instance = new LocalUserDAO();
        
        User entity = null;
        int expResult = 0;
        int result = instance.insert(entity);
        assertEquals(expResult, result);
        
        entity = new User(1L, "user@ncedu.ru", null, 0L, null, null, null, null);
        expResult = -1;
        result = instance.insert(entity);
        assertEquals(expResult, result);
        
        entity.setUserId(101L);
        expResult = 1;
        result = instance.insert(entity);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateUser method, of class LocalUserDAO.
     */
    @Test
    public void testUpdateUser() {
        UserDAO instance = new LocalUserDAO();
        
        User entity = null;
        assertFalse(instance.update(entity));
        
        entity = new User(1001L, null, null, 0L, null, null, null, null);
        assertFalse(instance.update(entity));
        
        entity = new User(5L, "user@ncedu.ru", null, 0L, null, null, null, null);
        assertTrue(instance.update(entity));
    }

    /**
     * Test of deleteUser method, of class LocalUserDAO.
     */
    @Test
    public void testDeleteUser() {
        UserDAO instance = new LocalUserDAO();
        
        User entity = null;
        assertFalse(instance.delete(entity));
        
        entity = new User(1001L, null, null, 0L, null, null, null, null);
        assertFalse(instance.delete(entity));
        
        entity = new User(4L, "user@ncedu.ru", null, 0L, null, null, null, null);
        assertTrue(instance.delete(entity));
    }

    /**
     * Test of findById method, of class LocalUserDAO.
     */
    @Test
    public void testFindById() {
        UserDAO instance = new LocalUserDAO();
        
        long id = 0L;
        User result = instance.findById(id);
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
        LocalUserDAO instance = new LocalUserDAO();
        Collection<User> result = instance.findAll();
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
    
    /**
     * Test of findByEmail method, of class LocalUserDAO.
     */
    @Test
    public void testFindByEmail() {
        UserDAO instance = new LocalUserDAO();
        
        String email = null;
        User result = instance.findByEmail(email);
        assertNull(result);
        
        email = "wrong_email";
        result = instance.findByEmail(email);
        assertNull(result);
        
        email = "admin@ncedu.ru";
        result = instance.findByEmail(email);
        assertNotNull(result);
    }
}
