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
import ru.ncedu.core.data.accessobjects.CommentDAO;
import ru.ncedu.core.data.entities.Comment;

/**
 * The class <code>LocalCommentDAO</code> imitates real <code>comments</code> connection
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
public class LocalCommentDAO implements CommentDAO {

    /**
     * DataBase imitation
     */
    private static final List<Comment> localStorage = Collections.synchronizedList(new ArrayList<Comment>());
    
    static {
        localStorage.add(new Comment(1L, 0L, "UnsupportedPage0", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis())));
        localStorage.add(new Comment(2L, 0L, "UnsupportedPage1", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis())));
        localStorage.add(new Comment(3L, 0L, "UnsupportedPage2", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis())));
        localStorage.add(new Comment(4L, 0L, "UnsupportedPage3", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis())));
        localStorage.add(new Comment(5L, 0L, "UnsupportedPage4", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis())));
        localStorage.add(new Comment(6L, 0L, "UnsupportedPage5", 0L, new Date(System.currentTimeMillis()), 0L, new Date(System.currentTimeMillis())));        
    }
    
    /**
     * Inserts value in database
     * @param entity - value to insert
     * @return -1 if value already exists</br>0 if value is nuul</br>1 if valeu inserted
     */
    @Override
    public int insert(Comment entity) {
        if (entity == null) {
            return 0;
        }

        Comment comment = findById(entity.getCommentId());

        if (comment != null) {
            return -1;
        }

        localStorage.add(entity);

        return 1;
    }

    /**
     * Updates value in database
     * @param entity - value to update
     * @return false if value is null or not exists
     */
    @Override
    public boolean update(Comment entity) {
        if (entity == null) {
            return false;
        }

        Comment comment = findById(entity.getCommentId());

        if (comment == null) {
            return false;
        }

        comment.setCommentId(entity.getCommentId());
        comment.setPageId(entity.getPageId());
        comment.setComment(entity.getComment());
        comment.setCreatedBy(entity.getCreatedBy());
        comment.setCreatedWhen(entity.getCreatedWhen());
        comment.setModifiedBy(entity.getModifiedBy());
        comment.setModifiedWhen(entity.getModifiedWhen());
        
        return true;
    }

    /**
     * Deletes value from database
     * @param entity - value to detele
     * @return false if value is null or not exists
     */
    @Override
    public boolean delete(Comment entity) {
        if (entity == null) {
            return false;
        }
        
        for (Iterator<Comment> it = localStorage.iterator(); it.hasNext();) {
            Comment user = it.next();
            if (user.getCommentId() == entity.getCommentId()) {
                it.remove();
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Gets <code>Comment</code> by id
     * @param id - comment id number
     * @return comment
     */
    @Override
    public Comment findById(long id) {
        for (Comment comment : localStorage) {
            if (comment.getCommentId() == id) {
                return comment;
            }
        }

        return null;
    }

    /**
     * Gets all <code>Comment</code> in database
     * @return list of comments
     */
    @Override
    public List<Comment> findAll() {
        return localStorage;
    }
}
