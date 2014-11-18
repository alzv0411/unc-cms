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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ru.ncedu.core.data.accessobjects.AttachmentDAO;

import ru.ncedu.core.data.entities.Attachment;

/**
 *
 * @author Viktor
 */
public class LocalAttachmentDAO implements AttachmentDAO {

    private static final List<Attachment> localStorage = Collections.synchronizedList(new ArrayList<Attachment>());
    static {
        localStorage.add(new Attachment(1, 1, "Attachment1", "C:\\solidangle1\\mtoadeploy_1"));
        localStorage.add(new Attachment(2, 2, "Attachment2", "C:\\solidangle2\\mtoadeploy_2"));
        localStorage.add(new Attachment(3, 3, "Attachment3", "C:\\solidangle3\\mtoadeploy_3"));
        localStorage.add(new Attachment(4, 4, "Attachment4", "C:\\solidangle4\\mtoadeploy_4"));
 
    }

    @Override
    public int insert(Attachment entity) {
        if (entity == null) {
            return 0;
        }

        Attachment attachment = findById(entity.getAttachmentId());

        if (attachment != null) {
            return -1;
        }

        localStorage.add(entity);

        return 1;
    }

    @Override
    public boolean update(Attachment entity) {
        if (entity == null) {
            return false;
        }

        Attachment attachment = findById(entity.getAttachmentId());

        if (attachment == null) {
            return false;
        }

        attachment.setAttachmentId(entity.getAttachmentId());
        attachment.setPageId(entity.getPageId());
        attachment.setName(entity.getName());
        attachment.setFilepath(entity.getFilepath());

        return true;
    }

  
    @Override
    public boolean delete(Attachment entity) {
        if (entity == null) {
            return false;
        }
        
        for (Iterator<Attachment> it = localStorage.iterator(); it.hasNext();) {
            Attachment attachment = it.next();
            if (attachment.getAttachmentId() == entity.getAttachmentId()) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }


    @Override
    public Attachment findById(long id) {
        for (Attachment attachment : localStorage) {
            if (attachment.getAttachmentId() == id) {
                return attachment;
            }
        }

        return null;
    }


    @Override
    public List<Attachment> findAll() {
        return localStorage;
    }

 

}
