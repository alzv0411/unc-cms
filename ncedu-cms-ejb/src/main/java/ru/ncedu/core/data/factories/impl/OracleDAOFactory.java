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
package ru.ncedu.core.data.factories.impl;


import ru.ncedu.core.data.accessobjects.AttachmentDAO;

import ru.ncedu.core.data.accessobjects.CommentDAO;

import ru.ncedu.core.data.accessobjects.GroupDAO;
import ru.ncedu.core.data.accessobjects.PageDAO;
import ru.ncedu.core.data.accessobjects.UserDAO;
import ru.ncedu.core.data.accessobjects.SettingDAO;
import ru.ncedu.core.data.factories.DAOFactory;

/**
 *
 * @author Alexander Zvyagintsev <alzv0411@gmail.com>
 */
public class OracleDAOFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    @Override
    public PageDAO getPageDAO() {
        throw new UnsupportedOperationException("Not supported yet. Will be available for 99,99$ only for premium users"); 
    }

    @Override
    public GroupDAO getGroupDAO() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public AttachmentDAO getAttachmentDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public SettingDAO getSettingDAO() {
        throw new UnsupportedOperationException("Not supported yet.");    
    }

    @Override
    public CommentDAO getCommentDAO() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
