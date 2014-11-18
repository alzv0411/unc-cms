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
import ru.ncedu.core.data.accessobjects.SettingDAO;
import ru.ncedu.core.data.entities.Setting;

/**
 *
 * @author daemon
 */

public class LocalSettingDAO implements SettingDAO {
    
    private static final List<Setting> localStorage = Collections.synchronizedList(new ArrayList<Setting>());
    static {
        localStorage.add(new Setting("slowpokemode", "disabled"));
        localStorage.add(new Setting("language", "en"));
        localStorage.add(new Setting("foo", "bar"));
        localStorage.add(new Setting("clever_title_like_deadmau5_would_use", "knife_party"));
    }
    
    @Override
    public int insertUser(Setting entity) {
        if (entity == null) {
            return 0;
        }
        
        Setting setting = findByName(entity.getName());
        
        if (setting != null) {
            return -1;
        }
        
        localStorage.add(entity);
        
        return 1;
    }
    
    @Override
    public boolean updateUser (Setting entity) {
        if (entity == null) {
            return false;
        }
        
        Setting setting = findByName(entity.getName());
        
        if (setting == null) {
            return false;
        }
        
        setting.setValue(entity.getName());
        
        return true;
    }
    
    @Override
    public boolean deleteUser(Setting entity) {
        if (entity == null) {
            return false;
        }
        
        //Setting setting = findByName(entity.getSettingName());
        
        for (Iterator<Setting> it = localStorage.iterator(); it.hasNext();) {
            Setting setting = it.next();
            if (setting.getName() == entity.getName()) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public Setting findByName(String name) {
        for (Setting setting : localStorage) {
            if (setting.getName().equals(name)) {
                return setting;
            }
        }
        
        return null;
    }
    
    @Override
    public Setting findById(long id){
        return null;
    }
    
    @Override
    public List<Setting> findAll() {
        return localStorage;
    }
}

