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
public class Orders {

    private int id;
    private int id_project;
    private int id_service;
    private float price_service;
    private int hour_service;
    private String name_service;

    public Orders(int id_project, int id_service, float price_service, int hour_service, String name_service) {
        this.id_project = id_project;
        this.id_service = id_service;
        this.price_service = price_service;
        this.hour_service = hour_service;
        this.name_service = name_service;
    }

    public Orders(int id_project, int id_service, float price_service, int hour_service, String name_service, int id) {
        this.id_project = id_project;
        this.id_service = id_service;
        this.price_service = price_service;
        this.hour_service = hour_service;
        this.name_service = name_service;
        this.id = id;
    }

    public Orders() {
    }

    public Orders(int id, int id_project, int id_service, float price_service, int hour_service, String name_service) {
        this.id = id;
        this.id_project = id_project;
        this.id_service = id_service;
        this.price_service = price_service;
        this.hour_service = hour_service;
        this.name_service = name_service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public float getPrice_service() {
        return price_service;
    }

    public void setPrice_service(float price_service) {
        this.price_service = price_service;
    }

    public int getHour_service() {
        return hour_service;
    }

    public void setHour_service(int hour_service) {
        this.hour_service = hour_service;
    }

    public String getName_service() {
        return name_service;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

   

}
