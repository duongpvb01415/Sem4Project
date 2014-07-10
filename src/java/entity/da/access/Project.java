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
public class Project {
    private int id;
    private int id_user;
    private String start_time;
    private float total_price;
    private int phone;
    private String address;
    private String avatar;
    private String more;
    private int startus;
    private String time_request;

    public Project(int id, int id_user, String start_time, float total_price, int phone, String address, String avatar, String more, int startus, String time_request) {
        this.id = id;
        this.id_user = id_user;
        this.start_time = start_time;
        this.total_price = total_price;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
        this.more = more;
        this.startus = startus;
        this.time_request = time_request;
    }

    public Project(int id_user, String start_time, float total_price, int phone, String address, String avatar, String more, String time_request) {
        this.id_user = id_user;
        this.start_time = start_time;
        this.total_price = total_price;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
        this.more = more;
        this.time_request = time_request;
        
    }

    public Project(int id_user, String start_time, float total_price, int phone, String address, String avatar, String more, int startus, String time_request) {
        this.id_user = id_user;
        this.start_time = start_time;
        this.total_price = total_price;
        this.phone = phone;
        this.address = address;
        this.avatar = avatar;
        this.more = more;
        this.startus = startus;
        this.time_request = time_request;
    }

    public Project() {
    }

    public String getTime_request() {
        return time_request;
    }

    public void setTime_request(String time_request) {
        this.time_request = time_request;
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

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public int getStartus() {
        return startus;
    }

    public void setStartus(int startus) {
        this.startus = startus;
    }
    
    
}
