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
 *
 * @author Alexander Zvyagintsev <alzv0411@gmail.com>
 */
public class Page {
    
    private long pageId;
    private long parentId;
    private String title;
    private String content;
    private long createdBy;
    private Date createdWhen;
    private long modifiedBy;
    private Date modifiedWhen;
    private String properties;

    public Page() {
    }

    public Page(long pageId, long parentId, String title, String content, long createdBy, Date createdWhen, long modifiedBy, Date modifiedWhen, String properties) {
        this.pageId = pageId;
        this.parentId = parentId;
        this.title = title;
        this.content = content;
        this.createdBy = createdBy;
        this.createdWhen = createdWhen;
        this.modifiedBy = modifiedBy;
        this.modifiedWhen = modifiedWhen;
        this.properties = properties;
    }

    public long getPageId() {
        return pageId;
    }

    public void setPageId(long pageId) {
        this.pageId = pageId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedWhen() {
        return createdWhen;
    }

    public void setCreatedWhen(Date createdWhen) {
        this.createdWhen = createdWhen;
    }

    public long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedWhen() {
        return modifiedWhen;
    }

    public void setModifiedWhen(Date modifiedWhen) {
        this.modifiedWhen = modifiedWhen;
    }
    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (int) (this.pageId ^ (this.pageId >>> 32));
        hash = 83 * hash + (int) (this.parentId ^ (this.parentId >>> 32));
        hash = 83 * hash + Objects.hashCode(this.title);
        hash = 83 * hash + Objects.hashCode(this.content);
        hash = 83 * hash + (int) (this.createdBy ^ (this.createdBy >>> 32));
        hash = 83 * hash + Objects.hashCode(this.createdWhen);
        hash = 83 * hash + (int) (this.modifiedBy ^ (this.modifiedBy >>> 32));
        hash = 83 * hash + Objects.hashCode(this.modifiedWhen);
        hash = 83 * hash + Objects.hashCode(this.properties);
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
        final Page other = (Page) obj;
        if (this.pageId != other.pageId) {
            return false;
        }
        if (this.parentId != other.parentId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.content, other.content)) {
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
        if (!Objects.equals(this.properties, other.properties)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Page{" + "pageId=" + pageId + ", parentId=" + parentId + ", title=" + title + ", content=" + content + ", createdBy=" + createdBy + ", createdWhen=" + createdWhen + ", modifiedBy=" + modifiedBy + ", modifiedWhen=" + modifiedWhen + ", properties=" + properties + '}';
    }

}
