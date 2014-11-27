/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.security;

import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ru.ncedu.core.data.accessobjects.impl.LocalUserDAO;
import ru.ncedu.core.data.entities.User;
import ru.ncedu.core.security.SecurityBean;
import static ru.ncedu.core.security.SecurityConstants.*;
import ru.ncedu.core.security.SecurityException;
import ru.ncedu.core.utils.Encrypt;
import ru.ncedu.core.utils.StringUtils;

/**
 * The class <code>AuthentificationBean</code> represents authentification API
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
@Stateless
@LocalBean
public class AuthentificationBean extends SecurityBean {
    /**
     * Sets default user setting if user does not exist
     * @throws SecurityException 
     */
    public void cheackAuthentification() throws SecurityException
    {
        if(authorization() == null) //User is Guest if not authentificated
        {
            logout();
        }
    }
    
    /**
     * Sets new user setting
     * @throws SecurityException 
     */
    public void login() throws SecurityException
    {
        Map<String, String[]> parameters = request.getParameterMap();
        if(parameters.containsKey(USER_EMAIL_PARAM) && parameters.containsKey(USER_PASSWORD_PARAM))
        {
            String email = parameters.get(USER_EMAIL_PARAM)[0];
            email = email.trim();
            if(StringUtils.isEmpty(email))
            {
                throw new SecurityException("Enter email");
            }

            String password = parameters.get(USER_PASSWORD_PARAM)[0];
            if(StringUtils.isEmpty(password))
            {
                throw new SecurityException("Enter password");
            }                
            password = Encrypt.getHash(password);

            User user = userDAO.findByEmail(email);                
            if(user != null)
            {
                if(user.getPassword().equals(password))
                {
                    session.setAttribute(USER_INSTANCE, user);
                }
                else
                {
                    throw new SecurityException("Invalid login or password");
                }
            }
            else
            {
                throw new SecurityException("Invalid login or password");
            }        
        }
    }
    
    /**
     * Sets default user settings
     */
    public void logout()
    {
        session.setAttribute(USER_INSTANCE, LocalUserDAO.GUEST);
    }
}
