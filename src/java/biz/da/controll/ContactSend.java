/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.da.controll;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.da.access.CommentSendMail;
import entity.da.access.DataAccess;
import java.util.Map;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Windows
 */
public class ContactSend extends ActionSupport {

    private String userName;
    private String userPhone;
    private String body;
    private String email;

    private String from = "duynt60@gmail.com";
    private String password = "Theduy86.";
    private String to = "duynt_b01416@fpt.aptech.ac.vn";
    static Properties properties = new Properties();

    static {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");

    }

    private boolean sendMail() {
        try {
            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication
                        getPasswordAuthentication() {
                            return new PasswordAuthentication(from, password);
                        }
                    });
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(email);
            message.setText(body);
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ContactSend() {
    }

    public String execute() throws Exception {
        try {
            Map<String, Object> session = ActionContext.getContext().getSession();
            if (userName.isEmpty() || userPhone.isEmpty() || body.isEmpty() || email.isEmpty()) {
                session.put("sendError", "a in form have character * not empty");
                return ERROR;
            } else {
                if (userName.length() > 50 || email.length() > 100 || body.length() > 1000) {
                    session.put("sendError", "Please Note: Name lesser 50 or Emai lesser 100 or SUBJECT lesser 1000 character");
                    return ERROR;
                } else {
                    if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                        session.put("sendError", "Invalid email!");
                        return ERROR;
                    } else {
                        DataAccess da = new DataAccess();
                        boolean bl = da.addComment(new CommentSendMail(userName, email, userPhone, body));
                        if (bl == true) {
                            if (sendMail() == true) {
                                return SUCCESS;
                            } else {
                                session.put("sendError", "Email can not send to Vendor");
                                return ERROR;
                            }
                        } else {
                            session.put("sendError", "message is not sent");
                            return ERROR;
                        }
                    }
                }
            }
        } catch (Exception e) {
            return ERROR;
        }
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
