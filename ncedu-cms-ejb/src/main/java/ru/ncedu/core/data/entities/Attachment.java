/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.data.entities;

/**
 *
 * @author Viktor
 */
public class Attachment {
    
    private long attachmentId;
    private long pageId;
    private String name;
    private String filepath;

    public Attachment() {
    }
    
     public Attachment(long attachmentId, long pageId, String name, String filepath) {
        this.attachmentId = attachmentId;
        this.pageId = pageId;
        this.name = name;
        this.filepath = filepath;    
    }
     
     public long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public long getPageId() {
        return pageId;
    }

    public void setPageId(long pageId) {
        this.pageId = pageId;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    @Override
     public String toString() {
        return "Atatchment{" + "attachmentId=" + attachmentId + ", pageId=" + pageId + ", name=" + name + ", filepath=" + filepath + '}';
    }
}
