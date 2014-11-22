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
import ru.ncedu.core.data.accessobjects.SettingDAO;
import ru.ncedu.core.data.accessobjects.UserDAO;
import ru.ncedu.core.data.accessobjects.RightDAO;

import ru.ncedu.core.data.accessobjects.impl.LocalAttachmentDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalCommentDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalGroupDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalSettingDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalUserDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalRightDAO;

import ru.ncedu.core.data.factories.DAOFactory;

import ru.ncedu.core.data.accessobjects.PageDAO;
import ru.ncedu.core.data.accessobjects.impl.LocalPageDAO;

/**
 *
 * @author Alexander Zvyagintsev <alzv0411@gmail.com>
 */
public class LocalDAOFactory extends DAOFactory {

    @Override
    public UserDAO getUserDAO() {
        return new LocalUserDAO();
    }

    @Override
    public GroupDAO getGroupDAO() {
        return new LocalGroupDAO();
    }

    @Override
    public AttachmentDAO getAttachmentDAO() {
         return new LocalAttachmentDAO();
    }

    @Override
    public SettingDAO getSettingDAO() {
        return new LocalSettingDAO();
    }

    @Override
    public CommentDAO getCommentDAO() {
        return new LocalCommentDAO();
    }
    
    @Override
    public RightDAO getRightDAO() {
        return new LocalRightDAO();
    }
    
    @Override
    public PageDAO getPageDAO() {
        return new LocalPageDAO();
    }
    
    
    
}
