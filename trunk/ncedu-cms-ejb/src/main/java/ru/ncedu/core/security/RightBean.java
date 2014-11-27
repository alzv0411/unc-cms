/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.security;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import ru.ncedu.core.data.entities.Right;

/**
 * The class <code>RightBean</code> represents rights API
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
@Stateless
@LocalBean
public class RightBean extends SecurityBean {

    /**
     * Gets current right for page
     * @param pageId - page ID number
     * @return 
     */
    public Right getRight(long pageId)
    {
        return rightDAO.findByGroupIdPageId(authorization().getGroupId(), pageId);
    }
    
    /**
     * Gets current read status for page
     * @param pageId - page ID number
     * @return 
     */
    public long canRead(long pageId)
    {
        return getRight(pageId).getRead();
    }
    
    /**
     * Gets current write status for page
     * @param pageId - page ID number
     * @return 
     */
    public long canWrite(long pageId)
    {
        return getRight(pageId).getRead();
    }
}
