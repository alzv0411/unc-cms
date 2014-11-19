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
import ru.ncedu.core.data.accessobjects.GroupDAO;
import ru.ncedu.core.data.entities.Group;

/**
 *
 * @author Alexander Zvyagintsev <alzv0411@gmail.com>
 */
public class LocalGroupDAO implements GroupDAO {
    
    private static final List<Group> localStorage = Collections.synchronizedList(new ArrayList<Group>());
    static {
        localStorage.add(new Group(1,0,"group1"));
        localStorage.add(new Group(2,1,"group2"));
        localStorage.add(new Group(3,1,"group3"));
        localStorage.add(new Group(4,2,"group4"));
        localStorage.add(new Group(5,3,"group5"));
    }
    
    @Override
    public int insert(Group entity) {
        if (entity == null) {
            return 0;
        }

        Group group = findById(entity.getGroupId());

        if (group != null) {
            return -1;
        }

        localStorage.add(entity);

        return 1;
    }

    @Override
    public boolean update(Group entity) {
        if (entity == null) {
            return false;
        }

        Group group = findById(entity.getGroupId());

        if (group == null) {
            return false;
        }

        group.setGroupId(entity.getGroupId());
        group.setParentId(entity.getParentId());
        group.setName(entity.getName());

        return true;
    }

    @Override
    public boolean delete(Group entity) {
        if (entity == null) {
            return false;
        }
        
        for (Iterator<Group> it = localStorage.iterator(); it.hasNext();) {
            Group group = it.next();
            if (group.getGroupId() == entity.getGroupId()) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public Group findById(long id) {
        for (Group group : localStorage) {
            if (group.getGroupId() == id) {
                return group;
            }
        }

        return null;
    }

    @Override
    public List<Group> findAll() {
        return localStorage;
    }
    
}
