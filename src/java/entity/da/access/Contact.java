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
public class Contact {
    private String company;
    private String phone;
    private String fax;
    private String email;
    private String address1;
    private String address2;
    private String contry;
    private String timeIn1;
    private String timeOut1;
    private String timeIn2;
    private String timeOut2;
    private String content;
    private String title;

    public Contact() {
    }

    public Contact(String company, String phone, String fax, String email, String address1, String address2, String contry, String timeIn1, String timeOut1, String timeIn2, String timeOut2, String content, String title) {
        this.company = company;
        this.phone = phone;
        this.fax = fax;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.contry = contry;
        this.timeIn1 = timeIn1;
        this.timeOut1 = timeOut1;
        this.timeIn2 = timeIn2;
        this.timeOut2 = timeOut2;
        this.content = content;
        this.title = title;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getTimeIn1() {
        return timeIn1;
    }

    public void setTimeIn1(String timeIn1) {
        this.timeIn1 = timeIn1;
    }

    public String getTimeOut1() {
        return timeOut1;
    }

    public void setTimeOut1(String timeOut1) {
        this.timeOut1 = timeOut1;
    }

    public String getTimeIn2() {
        return timeIn2;
    }

    public void setTimeIn2(String timeIn2) {
        this.timeIn2 = timeIn2;
    }

    public String getTimeOut2() {
        return timeOut2;
    }

    public void setTimeOut2(String timeOut2) {
        this.timeOut2 = timeOut2;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Contact{" + "company=" + company + ", phone=" + phone + ", fax=" + fax + ", email=" + email + ", address1=" + address1 + ", address2=" + address2 + ", contry=" + contry + ", timeIn1=" + timeIn1 + ", timeOut1=" + timeOut1 + ", timeIn2=" + timeIn2 + ", timeOut2=" + timeOut2 + ", content=" + content + ", title=" + title + '}';
    }
    
    
}
