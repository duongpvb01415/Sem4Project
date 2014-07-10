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
public class Category {
    private int id;
    private String name;
    private int descriptions;

    public Category() {
    }

    public Category(String name, String descriptions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", descriptions=" + descriptions + '}';
    }

    public Category(int id, String name, int descriptions) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
    }

    public Category(String name, int descriptions, int id) {
        this.name = name;
        this.descriptions = descriptions;
        this.id = id;
    }


    public Category(String name, int descriptions) {
        this.name = name;
        this.descriptions = descriptions;
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

    public int getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(int descriptions) {
        this.descriptions = descriptions;
    }
    
    
}
