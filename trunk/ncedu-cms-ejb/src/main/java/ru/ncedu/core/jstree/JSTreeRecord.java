/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.jstree;

/**
 * The class <code>JSTreeRecord</code> represents common jsTree record
 * @author Roman Semenov <romansemenov3@gmail.com>
 */
public class JSTreeRecord {
    /**
     * Record id
     */
    private String id;
    
    /**
     * Record parent id
     */
    private String parent;
    
    /**
     * Record text
     */
    private String text;
    
    /**
     * Creates <code>JSTreeRecord</code> 
     * @param id - record id number
     * @param parent - parent id number
     * @param text - record text
     */
    public JSTreeRecord(long id, long parent, String text)
    {
        this.id = String.valueOf(id);
        this.update(parent, text);
    }
    
    /**
     * Updates record data
     * @param parent - parent ID number
     * @param text  - record text
     */
    public final void update(long parent, String text)
    {
        this.parent = ((parent == 0) ? "#" : String.valueOf(parent));
        this.text = text;
    }
    
    @Override
    public String toString()
    {
        return "JSTreeRecord@" + id + ":" + parent + ":" + text;
    }
}
