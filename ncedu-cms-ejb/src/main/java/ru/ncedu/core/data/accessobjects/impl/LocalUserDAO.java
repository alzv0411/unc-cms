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
import ru.ncedu.core.data.accessobjects.UserDAO;
import ru.ncedu.core.data.entities.User;
import ru.ncedu.core.utils.Encrypt;

/**
 *
 * @author Alexander Zvyagintsev <alzv0411@gmail.com>
 */
public class LocalUserDAO implements UserDAO {

    private static final List<User> localStorage = Collections.synchronizedList(new ArrayList<User>());
    static {
        localStorage.add(new User(1L, "admin@ncedu.ru", "4e7afebcfbae000b22c7c85e5560f89a2a0280b4", LocalGroupDAO.ADMINS.getGroupId(), "Admin", "Admin", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        localStorage.add(new User(2L, "moder@ncedu.ru", "4d7c2910be6901811235f18772d1e1f680fb966d", 2L, "Moder", "Moder", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        localStorage.add(new User(3L, "user1@ncedu.ru", "4146594c9c6ac5407a3123560401170c2756a342", 3L, "User1", "User1", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        localStorage.add(new User(4L, "user2@ncedu.ru", "5d731241e892a0e3b7a9c701d65d176830b709cc", 3L, "User2", "User2", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
        localStorage.add(new User(5L, "user3@ncedu.ru", "325ef576f8066a46818c91ef3bbd0db7b2c40b66", 3L, "User3", "User3", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis())));
    }

    /**
     * Anonymous user
     */
    public static final User GUEST = new User(0L, null, null, LocalGroupDAO.GUESTS.getGroupId(), "Guest", "Guest", null, null);
    
    @Override
    public int insert(User entity) {
        if (entity == null) {
            return 0;
        }

        User user = findById(entity.getUserId());

        if (user != null) {
            return -1;
        }

        localStorage.add(entity);

        return 1;
    }

    @Override
    public boolean update(User entity) {
        if (entity == null) {
            return false;
        }

        User user = findById(entity.getUserId());

        if (user == null) {
            return false;
        }

        user.setEmail(entity.getEmail());
        user.setFirstName(entity.getFirstName());
        user.setGroupId(entity.getGroupId());
        user.setLastLogin(entity.getLastLogin());
        user.setLastName(entity.getLastName());
        user.setPassword(entity.getPassword());
        user.setRegisterWhen(entity.getRegisterWhen());

        return true;
    }

    @Override
    public boolean delete(User entity) {
        if (entity == null) {
            return false;
        }
        
        for (Iterator<User> it = localStorage.iterator(); it.hasNext();) {
            User user = it.next();
            if (user.getUserId() == entity.getUserId()) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }

    @Override
    public User findById(long id) {
        for (User user : localStorage) {
            if (user.getUserId() == id) {
                return user;
            }
        }

        return null;
    }

    @Override
    public List<User> findAll() {
        return localStorage;
    }

    @Override
    public User findByEmail(String email) {
        for (User user : localStorage) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        return null;
    }

}
