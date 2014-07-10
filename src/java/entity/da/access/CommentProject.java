/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.da.access;

/**
 *
 * @author Windows
 */
public class CommentProject {
    private int id;
    private int id_user;
    private String name;
    private int id_project;
    private String time_content;
    private String content;

    public CommentProject(int id_user, int id_project, String time_content, String content) {
        this.id_user = id_user;
        this.id_project = id_project;
        this.time_content = time_content;
        this.content = content;
    }

    public CommentProject(int id, String name, int id_project, String time_content, String content) {
        this.id = id;
        this.name = name;
        this.id_project = id_project;
        this.time_content = time_content;
        this.content = content;
    }

    public CommentProject(int id, int id_user, int id_project, String time_content, String content) {
        this.id = id;
        this.id_user = id_user;
        this.id_project = id_project;
        this.time_content = time_content;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public String getTime_content() {
        return time_content;
    }

    public void setTime_content(String time_content) {
        this.time_content = time_content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
}
