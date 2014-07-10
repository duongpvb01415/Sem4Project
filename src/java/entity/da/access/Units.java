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
public class Units {
    private int id;
    private String name;

    public Units(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Units( String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Units(String name) {
        this.name = name;
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
    
    
}
