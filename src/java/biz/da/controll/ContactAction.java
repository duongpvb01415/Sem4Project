/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biz.da.controll;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.da.access.CommentSendMail;
import entity.da.access.Contact;
import entity.da.access.DataAccess;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Windows
 */
public class ContactAction extends ActionSupport {
    private DataAccess cd = new DataAccess();
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
    private int id;
    private Contact c;
    private int editContact;
    private int id_comment;
    private List<CommentSendMail> listSend;
        private CommentSendMail cm;
    public ContactAction() {
    }
    
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        c=cd.getContact();
        listSend = cd.getListComment();
        if(id_comment>0){
            if(cd.deleteComment(id_comment)==false){
                return ERROR;
            }
        }
        if(id==1){
            session.put("contact", "contact");
        }else if(id==2){
            session.put("contact", null);
        }
        cm = cd.getComment(id);
        if(editContact>0){
            if(checkFormContact()==false){
                return ERROR;
            }
        }
        return SUCCESS;
    }

    
    public boolean checkFormContact(){
        try{
            Map<String, Object> session = ActionContext.getContext().getSession();
        
        if (company.isEmpty() || phone.isEmpty() || fax.isEmpty() || address1.isEmpty() || address2.isEmpty() || contry.isEmpty()) {
            session.put("error", "a in form have character * not empty");
        }else{
            if (company.length() > 100) {
                session.put("error", "character length many by form Company ");
                return false;
            } else {
                if (phone.length() > 12) {
                    session.put("error", "character length many by form Phone");
                    return false;
                } else {
                    if (fax.length() > 12) {
                        session.put("error", "character length many by form Fax");
                        return false;
                    } else {
                        if (address1.length() > 100 || address2.length() > 100) {
                            session.put("error", "character length many by form Address");
                            return false;
                        } else {
                            if (contry.length() > 50) {
                                session.put("error", "character length many by form Contry");
                                return false;
                            } else {
                                if (content.length() > 1000) {
                                    session.put("error", "character length many by form Content");
                                    return false;
                                } else {
                                    if (title.length() > 200) {
                                        session.put("error", "character length many by form Title");
                                        return false;
                                    }else{
                                        if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                                            session.put("error", "Email format wrong");
                                            return false;
                                        }else{
                                            boolean bl = cd.adminEditContact(new Contact(company, phone, fax, email, address1, address2, contry, timeIn1, timeOut1, timeIn2, timeOut2, content, title));
                                            if(bl){
                                                session.put("error", "Update Contact Success");
                                                return true;
                                            }else{
                                                session.put("error", "Update Contact Fail");
                                                return false;
                                            }
                                        }
                                        
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        }catch(Exception e){
            return false;
        }
        return false;
    }

    public void setEditContact(int editContact) {
        this.editContact = editContact;
    }

    public CommentSendMail getCm() {
        return cm;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public void setTimeIn1(String timeIn1) {
        this.timeIn1 = timeIn1;
    }

    public void setTimeOut1(String timeOut1) {
        this.timeOut1 = timeOut1;
    }

    public void setTimeIn2(String timeIn2) {
        this.timeIn2 = timeIn2;
    }

    public void setTimeOut2(String timeOut2) {
        this.timeOut2 = timeOut2;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setC(Contact c) {
        this.c = c;
    }

    public Contact getC() {
        return c;
    }

    public List<CommentSendMail> getListSend() {
        return listSend;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }
    
}
