/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui.da.loading;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.da.access.About;
import entity.da.access.Category;
import entity.da.access.Contact;
import entity.da.access.DataAccess;
import entity.da.access.Faq;
import entity.da.access.Home;
import entity.da.access.News;
import entity.da.access.Service;
import java.util.List;
import java.util.Map;
import jv.controll.District;

/**
 *
 * @author Windows
 */
public class HomeResult extends ActionSupport {
    private int IDGroup;
    private int ID;
    private List<Home> lis;
    private News news;
    private Home h;
    private Service sv;
    private List<Category> listC;
    private List<Category> listTop6Ca;
    private List<News> n;
    private List<About> lisA;
    private List<About> allAbout;
    private List<Service> lisS;
    private List<Service> lisSvCa;
    private int idService;
    private List<Faq> lisF;
    private Contact c;
    private List<District> lisDis;
    private List<Category> listCateForDis;
    private List<Service> listSerByIdDis;
    public HomeResult() {
        
    }
    
    public String execute() throws Exception {
        try {
            
        DataAccess da = new DataAccess();
        Map<String, Object> session = ActionContext.getContext().getSession();
            lisDis = da.getAllDistrict();
            c = da.getContact();
            lisF = da.getListFaq();
            allAbout = da.getListAbout();
            lisA = da.getTop2Desc();
            lis = da.getListSlide();
            h = da.getHome();
            listC = da.getListCategory();
            listTop6Ca = da.getCategoryTop5Desc();
            n = da.getNewsTop5Desc();
            lisS = da.getAllListService();
            session.put("home", "home");
            session.put("about", "about");
            session.put("contact", "contact");
            session.put("login", "login");
            session.put("faq", "faq");
            session.put("clientlogin", "clientlogin");
            session.put("allService", "allService");
            if(IDGroup>0){
                session.put("showServiceByDis", "showServiceByDis");
                session.put("IDGroup", IDGroup);
                listCateForDis = da.getCategoryByDistrict(IDGroup);
                listSerByIdDis = da.getServiceByDistrict(IDGroup);
            }
            if(idService>0){
                session.put("showService", "showService");
                session.put("allService", null);
                sv = da.getServiceById(idService);
                listCateForDis = da.getCategoryByDistrict((int)session.get("IDGroup"));
            }
            if(ID>0){
                session.put("allService", null);
                session.put("category", "category");
                lisSvCa = da.getListByIdCategory(ID);
                listCateForDis = da.getCategoryByDistrict((Integer)session.get("IDGroup"));
            }

            
        return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
      public List<Service> getListSerByIdDis() {
        return listSerByIdDis;
    }

    public List<Category> getListCateForDis() {
        return listCateForDis;
    }
    
    public void setIDGroup(int IDGroup) {
        this.IDGroup = IDGroup;
    }

    public List<District> getLisDis() {
        return lisDis;
    }

    public List<Category> getListTop6Ca() {
        return listTop6Ca;
    }
    
    public Contact getC() {
        return c;
    }

    
    public List<Faq> getLisF() {
        return lisF;
    }
 
    public List<Service> getLisSvCa() {
        return lisSvCa;
    }

    public List<Service> getLisS() {
        return lisS;
    }

    public List<About> getAllAbout() {
        return allAbout;
    }
    
    public List<About> getLisA() {
        return lisA;
    }

    public List<Home> getLis() {
        return lis;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Home getH() {
        return h;
    }

    public List<Category> getListC() {
        return listC;
    }

    public List<News> getN() {
        return n;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public Service getSv() {
        return sv;
    }

    
    
}
