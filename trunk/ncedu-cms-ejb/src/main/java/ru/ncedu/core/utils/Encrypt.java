/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class <code>Encrypt</code> represents encrypting processing
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
public class Encrypt {
    /**
     * Encryption algorithm
     */
    public static final String ALGORITHM = "SHA1";
    /**
     * Encryption algorithm instance
     */
    private static MessageDigest mDigest;
    
    static {
        try {
            mDigest = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Gets hash equivalent of source
     * @param source - source data
     * @return hash if source not null and not free
     */
    public static String getHash(String source)
    {
        if(source != null)
        {
            if(source.length() > 0)
            {
                byte[] hash = mDigest.digest(source.getBytes());
                String result = "";
                
                for (int i = 0; i < hash.length; i++)
                {
                    result += Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1);
                }

                return result;
            }
            else
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
}
