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
public class Cart {
    private int id;
    private int id_user;
    private int id_dis;
    private String name_service;
    private float price_service;
    private int day_service;
    private String image_service;
    private int id_service;
    private int quatity;

    public Cart(int id_user, int id_dis, String name_service, float price_service, int day_service, String image_service, int id_service, int quatity) {
        this.id_user = id_user;
        this.id_dis = id_dis;
        this.name_service = name_service;
        this.price_service = price_service;
        this.day_service = day_service;
        this.image_service = image_service;
        this.id_service = id_service;
        this.quatity = quatity;
    }

    public Cart(int id, int id_user, int id_dis, String name_service, float price_service, int day_service, String image_service, int id_service, int quatity) {
        this.id = id;
        this.id_user = id_user;
        this.id_dis = id_dis;
        this.name_service = name_service;
        this.price_service = price_service;
        this.day_service = day_service;
        this.image_service = image_service;
        this.id_service = id_service;
        this.quatity = quatity;
    }

    public Cart(int id_user, int id_dis, String name_service, float price_service, int day_service, String image_service, int id_service, int quatity, int id) {

        this.id_user = id_user;
        this.id_dis = id_dis;
        this.name_service = name_service;
        this.price_service = price_service;
        this.day_service = day_service;
        this.image_service = image_service;
        this.id_service = id_service;
        this.quatity = quatity;
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", id_user=" + id_user + ", id_dis=" + id_dis + ", name_service=" + name_service + ", price_service=" + price_service + ", day_service=" + day_service + ", image_service=" + image_service + '}';
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

    public int getId_dis() {
        return id_dis;
    }

    public void setId_dis(int id_dis) {
        this.id_dis = id_dis;
    }

    public String getName_service() {
        return name_service;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public float getPrice_service() {
        return price_service;
    }

    public void setPrice_service(float price_service) {
        this.price_service = price_service;
    }

    public int getDay_service() {
        return day_service;
    }

    public void setDay_service(int day_service) {
        this.day_service = day_service;
    }

    public String getImage_service() {
        return image_service;
    }

    public void setImage_service(String image_service) {
        this.image_service = image_service;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public int getQuatity() {
        return quatity;
    }

    public void setQuatity(int quatity) {
        this.quatity = quatity;
    }

    
}
