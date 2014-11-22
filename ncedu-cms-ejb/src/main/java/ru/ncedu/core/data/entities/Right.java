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

/**
 *
 * @author dmitry
 */
public class Right {
    
    private long groupId;
    private long pageId;
    private long read;
    private long write;
    
    public Right() {
    }
    
    public Right(long groupId, long pageId, long read, long write) {
        this.groupId = groupId;
        this.pageId = pageId;
        this.read = read;
        this.write = write;
    }
    
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getPageId() {
        return pageId;
    }

    public void setPageId(long pageId) {
        this.pageId = pageId;
    }
    
    public long getRead() {
        return read;
    }

    public void setRead(long read) {
        this.read = read;
    }
    
    public long getWrite() {
        return write;
    }

    public void setWrite(long write) {
        this.write = write;
    }
    
    @Override
     public String toString() {
        return "Right{" + "groupId=" + groupId + ", pageId=" + pageId + ", read=" + read + ", write=" + write + '}';
    }
}
