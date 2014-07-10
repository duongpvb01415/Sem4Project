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
public class Users {
    private int id;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String birth;
    private boolean typeadmin;
    private boolean gender;

    public Users() {
    }

    public Users(int id, String name, String email, String password, String phone, String address,  String birth, boolean gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        
        this.birth = birth;
        this.gender = gender;
    }

    
    public Users(String name, String email, String password,  String phone, String address, String birth, boolean typeadmin, boolean gender, int id) {
    
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.birth = birth;
        this.typeadmin = typeadmin;
        this.gender = gender;
        this.id = id;
    }

    public Users(String name, String email, String password, String phone, String birth, boolean typeadmin, boolean gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birth = birth;
        this.typeadmin = typeadmin;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", address=" + address + ", phone=" + phone + ", birth=" + birth + ", typeadmin=" + typeadmin + ", gender=" + gender + '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public boolean isTypeadmin() {
        return typeadmin;
    }

    public void setTypeadmin(boolean typeadmin) {
        this.typeadmin = typeadmin;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Users(String name, String email, String password, String phone, String address,  String birth, boolean typeadmin, boolean gender) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        
        this.birth = birth;
        this.typeadmin = typeadmin;
        this.gender = gender;
    }

    public Users(String name, String email, String password, String phone, String address,  String birth, boolean typeadmin) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        
        this.birth = birth;
        this.typeadmin = typeadmin;
    }

    
    
}
