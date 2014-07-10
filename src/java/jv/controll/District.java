/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jv.controll;

/**
 *
 * @author Windows
 */
public class District {
    private int id;
    private String name;

    public District(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public District(String name, int id) {
        
        this.name = name;
        this.id = id;
    }

    public District() {
    }

    @Override
    public String toString() {
        return "District{" + "id=" + id + ", name=" + name + '}';
    }

    
    public District(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
