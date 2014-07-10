/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.da.access;

import java.util.Date;

/**
 *
 * @author Windows
 */
public class News {
    private int id;
    private String name;
    private String desc;
    private String currentDate;

    public News() {
    }

    public News(int id, String name, String desc, String currentDate) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.currentDate = currentDate;
    }
    public News(String name, String desc, String currentDate, int id) {
        this.name = name;
        this.desc = desc;
        this.currentDate = currentDate;
        this.id = id;
    }

    public News(String name, String desc, String currentDate) {
        this.name = name;
        this.desc = desc;
        this.currentDate = currentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
    
    
}
