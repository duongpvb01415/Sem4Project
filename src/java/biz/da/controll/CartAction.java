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
import entity.da.access.Cart;
import entity.da.access.CartAccess;
import entity.da.access.Category;
import entity.da.access.CommentProject;
import entity.da.access.Contact;
import entity.da.access.DataAccess;
import entity.da.access.Home;
import entity.da.access.Orders;
import entity.da.access.Project;
import entity.da.access.Service;
import entity.da.access.Users;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import jv.controll.District;

/**
 *
 * @author Windows
 */
public class CartAction extends ActionSupport {

    private String content;
    private Contact c;
    private Home h;
    private List<District> lisDis;
    private List<Cart> lisCart;
    private int id_service;
    private String name_service;
    private String image_service;
    private float price_service;
    private int day_service;
    private int id_user;
    private int ID;
    private float total;
    private int totalDay;
    private int procc;
    private int proccess;
    private int back;
    private Project p;
    private Users u;
    private Orders o;
    private int verify;
    private List<Category> allCategory;
    private int cancel;
    private int id_project;
    private int itempProject;
    private List<Service> listTop5Service;
    private int status;
    private List<Orders> listSvByProject;
    private List<Project> listProjectUser;
    private List<CommentProject> lisComProject;
    private int partridge;
    private int totalHour;

    public CartAction() {
    }

    public String execute() throws Exception {
        try {
            DataAccess da = new DataAccess();
            CartAccess ca = new CartAccess();
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("show", "show");
            session.put("cart", "cart");

            h = da.getHome();
            c = da.getContact();
            lisDis = da.getAllDistrict();
            int get_user = (int) session.get("id");
            lisCart = ca.getCartByIdUser(get_user);
            allCategory = da.getListCategory();
            listTop5Service = ca.getListSerNews();

            if (itempProject > 0) {
                session.put("idProject", itempProject);
                p = ca.getIdByUserID(itempProject);
                totalHour = ca.getTotalHours(itempProject);
                listSvByProject = ca.getListServiceByIdProject(itempProject);
                lisComProject = da.getByIdProject(itempProject);

                session.put("itempProject", "itempProject");
            }
            if (cancel == 4) {
                boolean bl = ca.editStatusProject(cancel, id_project);
                if (bl == false) {
                    return ERROR;
                }
            }
            if (verify > 0) {
                session.put("cart", null);
                boolean bl = ca.addOrder(lisCart, (int) session.get("id_project"), (int) session.get("id"));
                session.put("security", null);
                if (bl == false) {
                    return ERROR;
                }
            }
            if (session.get("getProject") != null) {
                p = ca.getIdByUserIDAndTime((String) session.get("time_request"), (int) session.get("id"));
                lisCart = ca.getCartByIdUser((int) session.get("id"));
            }
            if (procc > 0) {
                session.put("procc", "procc");
                session.put("cart", null);
                session.put("security", "security");
            }
            if (ID > 0) {
                boolean bl = ca.delCart(ID);
                session.put("account", "account");
                if (bl == false) {
                    return ERROR;
                }
            }
            if (get_user > 0 || status > 0) {
                lisCart = ca.getCartByIdUser(get_user);
                total = ca.getPriceByIdUser(get_user);
                totalDay = ca.getDayByIdUser(get_user);
                if (status == 0) {
                    listProjectUser = ca.getProjectUser(get_user);
                } else {
                    listProjectUser = ca.getProjectStatus(status);
                }
            }
            if (id_user > 0) {
                District d = ca.getIdByIdService(id_service);
                int idDis = d.getId();
                if (id_user == 0 || idDis == 0 || name_service == null || price_service == 0 || day_service == 0 || image_service == null) {
                    return ERROR;
                } else {
                    if (ca.testIdSerInCart(id_user, id_service) == true) {
                        session.put("cartError", "This service already exists in your cart");
                        return ERROR;
                    } else {
                        if(partridge<1 || partridge >2000 ){
                            session.put("cartError", "quantity in the cart at least 1 and at most 2000");
                            return ERROR;
                        }else{
                            boolean bl = ca.addCart(new Cart(id_user, idDis, name_service, partridge * price_service, partridge * day_service, image_service, id_service, partridge));
                            if (bl == false) {
                                return ERROR;
                            }
                        } 
                    }
                }
            }
            if (content.isEmpty() || content.length() < 6) {
                session.put("content", "enter comment length > 6 character");
                return ERROR;
            } else {
                Date date = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a");
                boolean bl = da.addCommentProject(new CommentProject(get_user, (int) session.get("idProject"), ft.format(date), content));
                if (bl == false) {
                    return ERROR;
                }
            }
            return SUCCESS;
        } catch (Exception ex) {
            return ERROR;
        }
    }

    public void setPartridge(int partridge) {
        this.partridge = partridge;
    }

    public List<CommentProject> getLisComProject() {
        return lisComProject;
    }

    public List<Service> getListTop5Service() {
        return listTop5Service;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Orders> getListSvByProject() {
        return listSvByProject;
    }

    public void setItempProject(int itempProject) {
        this.itempProject = itempProject;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public void setCancel(int cancel) {
        this.cancel = cancel;
    }

    public List<Project> getListProjectUser() {
        return listProjectUser;
    }

    public List<Category> getAllCategory() {
        return allCategory;
    }

    public void setVerify(int verify) {
        this.verify = verify;
    }

    public void setO(Orders o) {
        this.o = o;
    }

    public Project getP() {
        return p;
    }

    public Users getU() {
        return u;
    }

    public void setBack(int back) {
        this.back = back;
    }

    public void setProccess(int proccess) {
        this.proccess = proccess;
    }

    public int getTotalDay() {
        return totalDay;
    }

    public float getTotal() {
        return total;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List<Cart> getLisCart() {
        return lisCart;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public Contact getC() {
        return c;
    }

    public Home getH() {
        return h;
    }

    public List<District> getLisDis() {
        return lisDis;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public void setImage_service(String image_service) {
        this.image_service = image_service;
    }

    public void setPrice_service(float price_service) {
        this.price_service = price_service;
    }

    public void setDay_service(int day_service) {
        this.day_service = day_service;
    }

    public void setProcc(int procc) {
        this.procc = procc;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getTotalHour() {
        return totalHour;
    }

    public int getId_service() {
        return id_service;
    }

    
}
