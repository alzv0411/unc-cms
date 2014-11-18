/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ncedu.core.data.accessobjects;

import java.util.List;
import ru.ncedu.core.data.entities.Attachment;


/**
 *
 * @author Viktor 
*/
public interface AttachmentDAO  {
    int insert(Attachment entity);
    boolean update(Attachment entity);
    boolean delete(Attachment entity);
    Attachment findById(long id);
    List<Attachment> findAll();
}
