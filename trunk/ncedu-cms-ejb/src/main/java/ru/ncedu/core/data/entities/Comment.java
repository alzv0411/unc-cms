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
package ru.ncedu.core.data.entities;

import java.sql.Date;
import java.util.Objects;

/**
 * The class <code>Comment</code> represents <code>comments</code> table record
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
public class Comment {
    
    private long commentId;
    private long pageId;
    private String comment;    
    private long createdBy;
    private Date createdWhen;    
    private long modifiedBy;
    private Date modifiedWhen;
    
    /**
     * Creates <code>Comment</code> instance
     */
    public Comment()
    {        
    }
    
    /**
     * Creates <code>Comment</code> instance by data
     * @param commentId - comment id number
     * @param pageId - page id number
     * @param comment - comment content
     * @param createdBy - creator-user id number
     * @param createdWhen - creation date
     * @param modifiedBy - modifier-user id number
     * @param modifiedWhen - modification date
     */
    public Comment(long commentId, long pageId, String comment, long createdBy, Date createdWhen, long modifiedBy, Date modifiedWhen)
    {
        this.commentId = commentId;
        this.pageId = pageId;
        this.comment = comment;
        this.createdBy = createdBy;
        this.createdWhen = createdWhen;
        this.modifiedBy = modifiedBy;
        this.modifiedWhen = modifiedWhen;
    }
    
    /**
     * Gets comment id number
     * @return comment id number
     */
    public long getCommentId()
    {
        return this.commentId;
    }
    
    /**
     * Sets comment id number
     * @param commentId - comment id number
     */
    public void setCommentId(long commentId)
    {
        this.commentId = commentId;
    }
    
    /**
     * Gets page id number
     * @return page id number
     */
    public long getPageId()
    {
        return this.pageId;
    }
    
    /**
     * Sets page id number
     * @param pageId - page id number
     */
    public void setPageId(long pageId)
    {
        this.pageId = pageId;
    }
    
    /**
     * Gets comment content
     * @return comment content
     */
    public String getComment()
    {
        return this.comment;
    }
    
    /**
     * Sets comment content
     * @param comment - comment content
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    /**
     * Gets creator-user id number
     * @return creator-user id number
     */
    public long getCreatedBy()
    {
        return this.createdBy;
    }
    
    /**
     * Sets creator-user id number
     * @param createdBy - creator-user id number
     */
    public void setCreatedBy(long createdBy)
    {
        this.createdBy = createdBy;
    }
    
    /**
     * Gets creation date
     * @return creation date
     */
    public Date getCreatedWhen()
    {
        return this.createdWhen;
    }
    
    /**
     * Sets creation date
     * @param createdWhen - creation date
     */
    public void setCreatedWhen(Date createdWhen)
    {
        this.createdWhen = createdWhen;
    }
    
    /**
     * Gets modifier-user id number
     * @return modifier-user id number
     */
    public long getModifiedBy()
    {
        return this.modifiedBy;
    }
    
    /**
     * Sets modifier-user id number
     * @param modifiedBy - modifier-user id number
     */
    public void setModifiedBy(long modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }
    
    /**
     * Gets modification date
     * @return modification date
     */
    public Date getModifiedWhen()
    {
        return this.modifiedWhen;
    }
    
    /**
     * Sets modification date
     * @param modifiedWhen - modification date
     */
    public void setModifiedWhen(Date modifiedWhen)
    {
        this.modifiedWhen = modifiedWhen;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (this.commentId ^ (this.commentId >>> 32));
        hash = 83 * hash + (int) (this.pageId ^ (this.pageId >>> 32));
        hash = 83 * hash + Objects.hashCode(this.comment);
        hash = 83 * hash + (int) (this.createdBy ^ (this.createdBy >>> 32));
        hash = 83 * hash + Objects.hashCode(this.createdWhen);
        hash = 83 * hash + (int) (this.modifiedBy ^ (this.modifiedBy >>> 32));
        hash = 83 * hash + Objects.hashCode(this.modifiedWhen);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (this.commentId != other.commentId) {
            return false;
        }
        if (this.pageId != other.pageId) {
            return false;
        }
        if (!Objects.equals(this.comment, other.comment)) {
            return false;
        }
        if (this.createdBy != other.createdBy) {
            return false;
        }
        if (!Objects.equals(this.createdWhen, other.createdWhen)) {
            return false;
        }
        if (this.modifiedBy != other.modifiedBy) {
            return false;
        }
        if (!Objects.equals(this.modifiedWhen, other.modifiedWhen)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Comment{" + "commentId=" + this.commentId + ", pageId=" + this.pageId + ", comment=" + comment + ", createdBy=" + createdBy + ", createdWhen=" + createdWhen + ", modifiedBy=" + modifiedBy + ", modifiedWhen=" + modifiedWhen + '}';
    }
}
