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
import ru.ncedu.core.data.accessobjects.RightDAO;
import ru.ncedu.core.data.entities.Right;

/**
 *
 * @author dmitry
 */
public class LocalRightDAO implements RightDAO{
    
    private static final List<Right> localStorage = Collections.synchronizedList(new ArrayList<Right>());
    static {
        localStorage.add(new Right(1,1,0,0));
        localStorage.add(new Right(2,2,0,1));
        localStorage.add(new Right(3,3,1,0));
        localStorage.add(new Right(4,4,1,1));
        localStorage.add(new Right(5,5,0,0));
    }
    
    @Override
    public int insert(Right entity) {
        if (entity == null) {
            return 0;
        }

        Right groupRight = findById(entity.getGroupId());
        Right pageRight = findById(entity.getPageId());

        if ((groupRight != null) && (pageRight != null)) {
            return -1;
        }       
        
        for (Iterator<Right> it = localStorage.iterator(); it.hasNext();) {
            Right iterationGroupRight = it.next();
            Right iterationPageRight = it.next();
            if ((iterationGroupRight.getGroupId() == entity.getGroupId()) && (iterationPageRight.getPageId() == entity.getPageId())) {
                return 0;
            }
        }

        localStorage.add(entity);

        return 1;
    }
    
    @Override
    public boolean update(Right entity) {
        if (entity == null) {
            return false;
        }

        Right groupRight = findById(entity.getGroupId());
        Right pageRight = findById(entity.getPageId());

        if ((groupRight == null) || (pageRight == null)) {
            return false;
        }

        groupRight.setRead(entity.getRead());
        groupRight.setWrite(entity.getWrite());

        return true;
    }
    
    @Override
    public boolean delete(Right entity) {
        if (entity == null) {
            return false;
        }
        
        for (Iterator<Right> it = localStorage.iterator(); it.hasNext();) {
            Right groupRight = it.next();
            Right pageRight = it.next();
            if ((groupRight.getGroupId() == entity.getGroupId()) && (pageRight.getPageId() == entity.getPageId())) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public Right findById(long id) {
        for (Right groupRight : localStorage) {
            if (groupRight.getGroupId() == id) {
                return groupRight;
            }
        }

        return null;
    }
    
    @Override
    public List<Right> findAll() {
        return localStorage;
    }
}
