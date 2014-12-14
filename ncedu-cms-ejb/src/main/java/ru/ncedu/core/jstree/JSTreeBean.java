package ru.ncedu.core.jstree;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class JSTreeBean {

    public String getGroupsTreeData(String selectedGroupId) {
        return "[\n" +
                "            { \"id\" : \"ajson2\", \"parent\" : \"#\", \"text\" : \"Admins\", 'state' : { 'opened' : true} },\n" +
                "            { \"id\" : \"ajson3\", \"parent\" : \"ajson2\", \"text\" : \"Moderators\" },\n" +
                "            { \"id\" : \"ajson4\", \"parent\" : \"ajson2\", \"text\" : \"Users\" },\n" +
                "          ]";
    }

    public String getPagesTreeData(String selectedPageId) {
        return "[\n" +
                "            { \"id\" : \"ajson2\", \"parent\" : \"#\", \"text\" : \"Welcome page\", 'state' : { 'opened' : true} },\n" +
                "            { \"id\" : \"ajson3\", \"parent\" : \"ajson2\", \"text\" : \"Page 1\" },\n" +
                "            { \"id\" : \"ajson4\", \"parent\" : \"ajson2\", \"text\" : \"Page 2\" },\n" +
                "          ]";
    }
}
