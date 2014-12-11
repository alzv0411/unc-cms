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

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import ru.ncedu.core.data.accessobjects.PageDAO;
import ru.ncedu.core.data.entities.Page;

/**
 *
 * @author Alexander Zvyagintsev <alzv0411@gmail.com>
 */
public class LocalPageDAO implements PageDAO {
    
    private static final List<Page> localStorage = Collections.synchronizedList(new ArrayList<Page>());
    static {
        localStorage.add(new Page(1L, 1L, "Public", "Public page", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis()), "Some properties"));        
        localStorage.add(new Page(2L, 2L, "Others", "Others page", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis()), "More properties"));
        localStorage.add(new Page(3L, 3L, "Moders", "Moders page", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis()), "And more..."));
        localStorage.add(new Page(4L, 4L, "Admins", "Admins page", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis()), "And more..."));
        localStorage.add(new Page(5L, 5L, "Default", "Default page", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis()), "And more..."));
    }
    
    /**
     * Imitates A_I in database
     */
    private static long AUTO_INCREMENT = localStorage.size() + 1;

    /**
     * Adds page and sets pageId number automatically
     * @param entity - page to add
     * @return page id number
     */
    @Override
    public Page add(Page entity)
    {
        entity.setPageId(AUTO_INCREMENT);
        localStorage.add(entity);
        ++AUTO_INCREMENT;
        
        return entity;
    }
    
    @Override
    public int insert(Page entity) {
        if (entity == null) {
            return 0;
        }

        Page page = findById(entity.getPageId());

        if (page != null) {
            return -1;
        }

        localStorage.add(entity);

        return 1;
    }

    @Override
    public boolean update(Page entity) {
        if (entity == null) {
            return false;
        }

        Page page = findById(entity.getPageId());

        if (page == null) {
            return false;
        }

        page.setParentId(entity.getParentId());
        page.setTitle(entity.getTitle());
        page.setContent(entity.getContent());
        page.setCreatedBy(entity.getCreatedBy());
        page.setCreatedWhen(entity.getCreatedWhen());
        page.setModifiedBy(entity.getModifiedBy());
        page.setModifiedWhen(entity.getModifiedWhen());
        page.setProperties(entity.getProperties()); 

        return true;
    }

    @Override
    public boolean delete(Page entity) {
        if (entity == null) {
            return false;
        }
        
        for (Iterator<Page> it = localStorage.iterator(); it.hasNext();) {
            Page page = it.next();
            if (page.getPageId() == entity.getPageId()) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Page findById(long id) {
        for (Page page : localStorage) {
            if (page.getPageId() == id) {
                return page;
            }
        }

        return null;
    }

    @Override
    public List<Page> findAll() {
        return localStorage;
    }

}
