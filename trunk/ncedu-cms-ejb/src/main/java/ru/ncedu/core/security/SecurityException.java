/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.security;

/**
 * The class <code>SecurityException</code> represents security exceptions
 * @author Roman
 */
public class SecurityException extends Exception {

    public SecurityException(String error) {
        super(error);
    }
    
}
