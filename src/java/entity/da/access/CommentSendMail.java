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
public class CommentSendMail {
    private int id;
    private String userName;
    private String email;
    private String userPhone;
    private String body;

    public CommentSendMail() {
    }

    public CommentSendMail(String userName, String email, String userPhone, String body) {
        this.userName = userName;
        this.email = email;
        this.userPhone = userPhone;
        this.body = body;
    }

    public CommentSendMail(int id, String userName, String email, String userPhone, String body) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.userPhone = userPhone;
        this.body = body;
    }

    @Override
    public String toString() {
        return "CommentSendMail{" + "id=" + id + ", userName=" + userName + ", email=" + email + ", userPhone=" + userPhone + ", body=" + body + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
