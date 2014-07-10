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
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Windows
 */
public class UserAction extends ActionSupport {

    private String name;
    private String email;
    private String pass;
    private String phone;
    private String birth;
    private String typeadmin;
    private String gender;
    private String address;
    private List<Users> lisU;
    private List<Users> lisA;
    private int adduse;
    private int listuse;
    private int id;
    private int id_user;
    private Users use;
    private int idUser;
    private int deleteId;
    public UserAction() {
    }

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        DataAccess da = new DataAccess();
        if (adduse > 0) {
            session.put("addUser", "addUser");
        }
        lisU = da.getListUser(false);
        lisA = da.getListUser(true);

        if (name != null) {
            if (addUser() == false) {
                return ERROR;
            }
        }
        if(idUser>0){
            session.put("idU", da.getUserById(idUser).getId());
            use = da.getUserById((int)session.get("idU"));  
            if(editUser()==false){
                return ERROR;
            }
        }
        if(deleteId>0){
            if(da.deleteUser(deleteId)==false){
                return ERROR;
            }
        }
        return SUCCESS;
    }

    public boolean editUser() {
        try {
            DataAccess da = new DataAccess();
            Map<String, Object> session = ActionContext.getContext().getSession();
            if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || phone.isEmpty()) {
                session.put("error", "not be so empty Fields marked *");
                return false;
            } else {
                if (name.length() > 30 || email.length() > 100 || pass.length() > 50 || phone.length() > 14 || birth.length() > 10) {
                    session.put("error", "characters at schools are being exceeded allowable number, please check back");
                    return false;
                } else {
                    if (isNumeric(phone) == false) {
                        session.put("error", "Check your phone's format is incorrect format");
                        return false;
                    } else {
                        if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                            session.put("error", "Email format is wrong, or check the email");
                            return false;
                        } else {
                            if (gender.equals("Male")) {

                                if (typeadmin.equals("Client")) {
                                    boolean u = da.editUser(new Users(name, email, pass, phone, address, birth, false, true, idUser));
                                    if (u == true) {
                                        return true;
                                    } else {
                                        session.put("error", "Can not edit on database");
                                        return false;
                                    }
                                } else {
                                    boolean u = da.editUser(new Users(name, email, pass, phone, address, birth, true, true, idUser));
                                    if (u = true) {
                                        return true;
                                    } else {
                                        session.put("error", "Can not edit on database");
                                        return false;
                                    }
                                }
                            } else {
                                if (typeadmin.equals("Client")) {
                                    boolean u = da.editUser(new Users(name, email, pass, phone, address, birth, false, false, idUser));
                                    if (u == true) {
                                        return true;
                                    } else {
                                        session.put("error", "Can not edit on database");
                                        return false;
                                    }
                                } else {
                                    boolean u = da.editUser(new Users(name, email, pass, phone, address, birth, true, false, idUser));
                                    if (u = true) {
                                        return true;
                                    } else {
                                        session.put("error", "Can not edit on database");
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addUser() {
        try {
            Map<String, Object> session = ActionContext.getContext().getSession();
            if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || phone.isEmpty()) {
                session.put("error", "not be so empty Fields marked *");
                return false;
            } else {
                if (name.length() > 30 || email.length() > 100 || pass.length() > 50 || phone.length() > 14 || birth.length() > 10) {
                    session.put("error", "characters at schools are being exceeded allowable number, please check back");
                    return false;
                } else {
                    if (isNumeric(phone) == false) {
                        session.put("error", "Check your phone's format is incorrect format");
                        return false;
                    } else {
                        if (!email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                            session.put("error", "Email format is wrong, or check the email");
                            return false;
                        } else {
                            DataAccess da = new DataAccess();
                            if (da.getInfoUser(email) != null) {
                                session.put("error", "This email is already used by another user. Please try with other email");
                                return false;
                            } else {

                                if (gender.equals("Male")) {
                                    if (typeadmin.equals("Admin")) {
                                        boolean u = da.addUser(new Users(name, email, pass, phone, address, birth, true, true));
                                        if (u = true) {
                                            return true;
                                        } else {
                                            session.put("error", "Can not add on database");
                                            return false;
                                        }
                                    } else {
                                        boolean u = da.addUser(new Users(name, email, pass, phone, address, birth, false, true));
                                        if (u == true) {
                                            return true;
                                        } else {
                                            session.put("error", "Can not add on database");
                                            return false;
                                        }
                                    }
                                } else {
                                    if (typeadmin.equals("Admin")) {
                                        boolean u = da.addUser(new Users(name, email, pass, phone, address, birth, true, false));
                                        if (u = true) {
                                            return true;
                                        } else {
                                            session.put("error", "Can not add on database");
                                            return false;
                                        }
                                    } else {
                                        boolean u = da.addUser(new Users(name, email, pass, phone, address, birth, false, false));
                                        if (u = true) {
                                            return true;
                                        } else {
                                            session.put("error", "Can not add on database");
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void setDeleteId(int deleteId) {
        this.deleteId = deleteId;
    }

    public Users getUse() {
        return use;
    }



    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdduse(int adduse) {
        this.adduse = adduse;
    }

    public void setListuse(int listuse) {
        this.listuse = listuse;
    }

    public List<Users> getLisA() {
        return lisA;
    }

    public List<Users> getLisU() {
        return lisU;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setTypeadmin(String typeadmin) {
        this.typeadmin = typeadmin;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
