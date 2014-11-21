/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.ncedu.core.utils.Encrypt;

/**
 *
 * @author Roman Semenov <romansemenov@gmail.com>
 */
public class EncryptTest {
    
    public EncryptTest() {
    }

    /**
     * Test of getHash method, of class Encrypt.
     */
    @Test
    public void testGetHash() throws Exception {
        System.out.println("getHash:" + Encrypt.ALGORITHM);
        System.out.println("12345 -> " + Encrypt.getHash("12345"));        
        assertEquals(null, Encrypt.getHash(null));        
        assertEquals(null, Encrypt.getHash(""));
    }
    
}
