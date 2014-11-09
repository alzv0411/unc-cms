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

import java.util.Objects;

/**
 *
 * @author Alexander Zvyagintsev <alzv0411@gmail.com>
 */
public class Group {
    
    private long groupId;
    private long parentId;
    private String name;

    public Group() {
    }

    public Group(long groupId, long parentId, String name) {
        this.groupId = groupId;
        this.parentId = parentId;
        this.name = name;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.groupId ^ (this.groupId >>> 32));
        hash = 67 * hash + (int) (this.parentId ^ (this.parentId >>> 32));
        hash = 67 * hash + Objects.hashCode(this.name);
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
        final Group other = (Group) obj;
        if (this.groupId != other.groupId) {
            return false;
        }
        if (this.parentId != other.parentId) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Group{" + "groupId=" + groupId + ", parentId=" + parentId + ", name=" + name + '}';
    }
    
}
