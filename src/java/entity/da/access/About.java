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
public class About {
    private int id;
    private String title;
    private String descriptions;

    public About() {
    }

    public About(String title, String descriptions) {
        this.title = title;
        this.descriptions = descriptions;
    }

    public About(int id, String title, String descriptions) {
        this.id = id;
        this.title = title;
        this.descriptions = descriptions;
    }

    public About(String title, String descriptions,int id) {
        
        this.title = title;
        this.descriptions = descriptions;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
    
    
}
