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
import entity.da.access.CartAccess;
import entity.da.access.Category;
import entity.da.access.Contact;
import entity.da.access.DataAccess;
import entity.da.access.Home;
import entity.da.access.Project;
import entity.da.access.Service;
import java.util.List;
import java.util.Map;
import jv.controll.District;

/**
 *
 * @author Windows
 */
public class ProjectShow extends ActionSupport {
    private int IDGroup;
    private Home h;
    private Contact c;
    private List<Home> lis;
    private List<District> lisDis;
    private List<Category> listCateForDis;
    private List<Service> listSerByIdDis;
    private List<Project> list3TopProUp;
    private List<Project> list3TopProOn;
    private List<Project> list3TopProAc;
    private int status;
    private List<Project> listProject;
    private int idProject;
    public ProjectShow() {
    }
    
    public String execute() throws Exception {
        try {
            Map<String, Object> session = ActionContext.getContext().getSession();
            DataAccess da = new DataAccess();
            CartAccess ca = new CartAccess();
            session.put("totalproject", "totalproject");
            if(idProject>0){
                boolean bl = ca.deleteProject(idProject);
                if(bl==false){
                    return ERROR;
                }
            }
            if(status>0){
                listProject = ca.getProjectStatus(status);
                
            }else{
                listProject = ca.getProject();
            }
            h = da.getHome();
            lis = da.getListSlide();
            lisDis = da.getAllDistrict();
            listCateForDis = da.getCategoryByDistrict(IDGroup);
            listSerByIdDis = da.getServiceByDistrict(IDGroup);
            list3TopProUp = ca.getTop3ProjectAccomplished(1);
            list3TopProOn = ca.getTop3ProjectAccomplished(2);
            list3TopProAc = ca.getTop3ProjectAccomplished(3);
            c = da.getContact();
            return SUCCESS;
        } catch (Exception e) {
            e.toString();
            return ERROR;
        }
    }
     public List<Project> getListProject() {
        return listProject;
    }

    public List<Project> getList3TopProUp() {
        return list3TopProUp;
    }

    public List<Project> getList3TopProOn() {
        return list3TopProOn;
    }

    public List<Project> getList3TopProAc() {
        return list3TopProAc;
    }



    public Contact getC() {
        return c;
    }

    public List<District> getLisDis() {
        return lisDis;
    }

    public List<Category> getListCateForDis() {
        return listCateForDis;
    }

    public List<Service> getListSerByIdDis() {
        return listSerByIdDis;
    }

    public List<Home> getLis() {
        return lis;
    }

    public Home getH() {
        return h;
    }

    public void setIDGroup(int IDGroup) {
        this.IDGroup = IDGroup;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
    
}
