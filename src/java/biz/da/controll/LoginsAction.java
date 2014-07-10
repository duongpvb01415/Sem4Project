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
import entity.da.access.DataAccess;
import entity.da.access.Users;
import java.util.Map;

/**
 *
 * @author Windows
 */
public class LoginsAction extends ActionSupport {
    
    private String email;
    private String password;
    private String check;
    private String admin;

    public LoginsAction() {
    }
    
    public String execute() throws Exception {
        try {
            Map<String, Object> session = ActionContext.getContext().getSession();
            if (email.isEmpty() || password.isEmpty()) {
                session.put("loginError", "is not to empty email accounts or pass");
                return ERROR;
            } else {
                if (email.length() > 100) {
                    session.put("loginError", "email length is not greater than the number of 100 characters");
                    return ERROR;
                } else {
                    if (password.length() > 50 || password.equals(" ")) {
                        session.put("loginError", "password length is not greater than the number of 50 characters");
                        return ERROR;
                    } else {
                        if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                            session.put("loginError", "email formats like ex: users@gmail.com");
                        } else {
                            DataAccess da = new DataAccess();
                            Users u = da.getInfoUser(email);
                            if (da.getInfoUser(email) == null) {
                                session.put("loginError", "Email this has not been registered for use");
                                return ERROR;
                            } else {
                                if (!password.equals(u.getPassword())) {
                                    session.put("loginError", "Login wrong password");
                                    return ERROR;
                                } else {
                                    if (session.get("id") != null) {
                                        session.put("loginError", "This account being logged by other users");
                                        return ERROR;
                                    } else {
                                        if (u.isTypeadmin() == true) {
                                            session.put("id", u.getId());
                                            session.put("admin", "admin");
                                            session.put("name", u.getName());
                                            session.put("email", email);
                                            session.put("birth", u.getBirth());
                                            session.put("gender", u.isGender());
                                            return SUCCESS;
                                        } else {
                                            if (check == null) {
                                                session.put("id", u.getId());
                                                session.remove("emaillogin");
                                                session.remove("password");
                                                session.put("name", u.getName());
                                                session.put("email", email);
                                                session.put("birth", u.getBirth());
                                                session.put("gender", u.isGender());
                                                return SUCCESS;
                                            } else {
                                                session.put("id", u.getId());
                                                session.put("emaillogin", email);
                                                session.put("password", password);
                                                session.put("name", u.getName());
                                                session.put("email", email);
                                                session.put("birth", u.getBirth());
                                                session.put("gender", u.isGender());
                                                return SUCCESS;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            return ERROR;
        }
        return ERROR;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
    
}
