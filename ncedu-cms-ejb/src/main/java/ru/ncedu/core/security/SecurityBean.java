/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.security;

import java.io.Serializable;
import java.util.Map;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import ru.ncedu.core.data.accessobjects.GroupDAO;
import ru.ncedu.core.data.accessobjects.RightDAO;
import ru.ncedu.core.data.accessobjects.UserDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalGroupDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalRightDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalUserDAO;
import ru.ncedu.core.data.entities.User;
import ru.ncedu.core.utils.Encrypt;
import ru.ncedu.core.utils.StringUtils;
import static ru.ncedu.core.security.SecurityConstants.*;

/**
 * The class <code>SecurityBean</code> represents common security API
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
public abstract class SecurityBean implements Serializable {
    /**
     * Session instance
     */
    @Inject
    protected HttpSession session;
    
    /**
     * Request instance
     */
    @Inject
    protected HttpServletRequest request;
    
    protected UserDAO userDAO;
    protected GroupDAO groupDAO;
    protected RightDAO rightDAO;
    
    {
        userDAO = new LocalUserDAO();
        groupDAO = new LocalGroupDAO();
        rightDAO = new LocalRightDAO();
    }
    
    /**
     * Gets current user
     * @return current user
     */
    public User authorization()
    {
        return (User) session.getAttribute(USER_INSTANCE);
    }
}
