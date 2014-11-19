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
