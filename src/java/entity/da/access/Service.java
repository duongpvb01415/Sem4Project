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
public class Service {
    private int id;
    private int id_category;
    private String name;
    private String content;
    private float price;
    private String images;
    private String descriptions;
    private int day_completion;
    
    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", id_category=" + id_category + ", name=" + name + ", price=" + price + ", images=" + images + ", descriptions=" + descriptions + ", day_completion=" + day_completion + '}';
    }

    public Service( int id_category, String name,String content, float price, String images, String descriptions, int day_completion, int id) {
        this.id_category = id_category;
        this.name = name;
        this.content = content;
        this.price = price;
        this.images = images;
        this.descriptions = descriptions;
        this.day_completion = day_completion;
        this.id = id;
    }

    public Service(int id_category, String name, String content, float price, String images, String descriptions, int day_completion) {
        this.id_category = id_category;
        this.name = name;
        this.content = content;
        this.price = price;
        this.images = images;
        this.descriptions = descriptions;
        this.day_completion = day_completion;
    }

    
    

    public Service(int id, int id_category, String name, String content, float price, String images, String descriptions, int day_completion) {
        this.id = id;
        this.id_category = id_category;
        this.name = name;
        this.content = content;
        this.price = price;
        this.images = images;
        this.descriptions = descriptions;
        this.day_completion = day_completion;
    }


    public Service() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getDay_completion() {
        return day_completion;
    }

    public void setDay_completion(int day_completion) {
        this.day_completion = day_completion;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
