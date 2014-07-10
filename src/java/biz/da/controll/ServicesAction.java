
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
import entity.da.access.CartAccess;
import entity.da.access.Category;
import entity.da.access.DataAccess;
import entity.da.access.Home;
import entity.da.access.Service;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.List;
import java.util.Map;
import jv.controll.District;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Windows
 */
public class ServicesAction extends ActionSupport {

    private int id;
    private List<District> listDisTrict;
    private List<Category> listCategory;
    private List<Category> cmbCategory;
    private List<Service> listServiceInDistrict;
    private List<Service> listService;
    private int showId;
    private int idService;
    private Service s;
    private int pub;
    private int addDistrict;
    private String name;
    private DataAccess da = new DataAccess();
    private CartAccess ca = new CartAccess();
    private int table;
    private District d;
    private int idDistrict;
    private String content;
    private int id_category;
    private float price;
    private String descriptions;
    private int day_completion;
    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;
    private int idSer;
    private int delService;
    private int idCategory;
    public ServicesAction() {
    }

    public String execute() throws Exception {
        try {

            Map<String, Object> session = ActionContext.getContext().getSession();
            DataAccess da = new DataAccess();
            session.put("services", "services");
            if(idCategory>0){
                if(da.deleteCategory(idCategory)==false){
                    return ERROR;
                }
            }
            if (pub == 1) {
                session.put("addDistrict", "addCategory");
            } else if (pub == 2) {
                session.put("addCategory", "addDistrict");
                session.put("addDistrict", null);
            }
            if (pub == 3) {
                session.put("addService", "services");
            }
            if (showId > 0) {
                session.put("showId", showId);
                listCategory = da.getCategoryByDistrict((int)session.get("showId"));
                session.put("listCategory", "listCategory");
                listServiceInDistrict = da.getServiceByDistrict((int)session.get("showId"));
            }
            cmbCategory = da.getListCategory();
            listDisTrict = da.getAllDistrict();

            if (id == 0) {
                listService = da.getAllListService();
            } else {
                listService = da.getListByIdCategory(id);
            }
            if (idDistrict > 0) {
                boolean bl = da.deleteDistrict(idDistrict);
                if (bl == false) {
                    return ERROR;
                }
            }
            if (idService > 0) {
                session.put("addService", "services");
                s = da.getServiceById(idService);
                session.put("detailService", "detailService");
                
            }
            if (table > 0 || id > 0) {
                d = da.getDistrictById(id);
                session.put("addDistrict", "addCategory");
                if (addDistrict() == false) {
                    return ERROR;
                }
            }
            if (day_completion > 0) {
                if(addService()==false){
                    return ERROR;
                }
            }
            if(delService>0){
                if(da.deleteService(delService)==false){
                    return ERROR;
                }
            }

            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }

    public boolean addDistrict() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (name.isEmpty()) {
            session.put("error", "Do not leave empty");
            return false;
        } else {
            if (name.length() > 100) {
                session.put("error", "Character limit of 100 characters");
                return false;
            } else {
                if (id > 0) {
                    boolean bl = da.editDistrict(new District(name, id));
                    if (bl == false) {
                        session.put("error", "Can not add to database");
                        return false;
                    } else {
                        session.put("tab", "district");
                        session.put("error", "Add to database Success");
                    }
                } else {
                    boolean bl = da.addDistrict(new District(name));
                    if (bl == false) {
                        session.put("error", "Can not add to database");
                        return false;
                    } else {
                        session.put("tab", "district");
                        session.put("error", "Add to database Success");
                    }
                }
            }
        }
        return true;
    }

    public boolean addService() {

        Map<String, Object> session = ActionContext.getContext().getSession();
        if (name.isEmpty() || descriptions.isEmpty() || content.isEmpty()) {
            session.put("error", "You did not select the file or the fields marked * are empty");
            return false;
        } else {
            if (name.length() > 300 || descriptions.length() > 2999 || content.length() > 200) {
                session.put("error", "Name or policy content exceeds the number of characters allowed, please re-enter");
                return false;
            } else {
                if (!isNumeric(Integer.toString(day_completion)) || Integer.toString(day_completion).length() > 2) {
                    session.put("error", "Time Expiration policy is not to enter alphanumeric characters, the amount does not exceed 2");
                    return false;
                } else {
                    if (uploadImag() == false) {
                        session.put("error", "Can not upload photos to the server, please try again");
                        return false;
                    } else {
                        if (id_category == 0) {
                            session.put("error", "please add Category");
                            return false;
                        } else {
                            DataAccess da = new DataAccess();
                            if (idSer > 0) {
                                boolean bl = da.editService(new Service(id_category, name, content, price, "upload/service/" + myFileFileName, descriptions, day_completion, idSer));
                                if (bl == true) {
                                    session.put("error", null);
                                    return true;
                                } else {
                                    return false;
                                }
                            } else {
                                boolean bl = da.addService(new Service(id_category, name, content, price, "upload/service/" + myFileFileName, descriptions, day_completion));
                                if (bl == true) {
                                    session.put("error", null);
                                    return true;
                                } else {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public boolean uploadImag() {
        DataAccess da = new DataAccess();
        Home h = new Home();
        h = da.getHome();
        destPath = h.getRootUpload()+"upload\\service";
        try {
            System.out.println("Src File name: " + myFile);
            System.out.println("Dst File name: " + myFileFileName);

            File destFile = new File(destPath, myFileFileName);
            try {
                FileUtils.copyFile(myFile, destFile);
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

    public void setIdSer(int idSer) {
        this.idSer = idSer;
    }

    public void setDelService(int delService) {
        this.delService = delService;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Service getS() {
        return s;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setDay_completion(int day_completion) {
        this.day_completion = day_completion;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    public District getD() {
        return d;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddDistrict(int addDistrict) {
        this.addDistrict = addDistrict;
    }

    public void setPub(int pub) {
        this.pub = pub;
    }

    public List<District> getListDisTrict() {
        return listDisTrict;
    }

    public List<Category> getListCategory() {
        return listCategory;
    }

    public List<Category> getCmbCategory() {
        return cmbCategory;
    }

    public List<Service> getListService() {
        return listService;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Service> getListServiceInDistrict() {
        return listServiceInDistrict;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    public String getMyFileContentType() {
        return myFileContentType;
    }

    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }

    public String getMyFileFileName() {
        return myFileFileName;
    }

    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }

    public String getDestPath() {
        return destPath;
    }

    public void setDestPath(String destPath) {
        this.destPath = destPath;
    }

}
