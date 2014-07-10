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
import entity.da.access.About;
import entity.da.access.DataAccess;
import entity.da.access.Home;
import entity.da.access.Logo;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Windows
 */
public class HomeAction extends ActionSupport {
    private About a;
    private int logodelete;
    private int iddelete;
    private int id;
    private int home;
    private String title;
    private String logo;
    private String content1;
    private String content2;
    private String content3;
    private Home h;
    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;
    private List<Home> lis;
    private List<Logo> lisLogo;
    private String aboutTitle;
    private String description;
    private List<About> lisAbout;
    private int idAbout;
    private int editIdAbout;
    private int idAboutdelete;
    private String link;
    public HomeAction() {
    }
    
    public String execute() throws Exception {
         try {
            Map<String, Object> session = ActionContext.getContext().getSession();
            DataAccess da = new DataAccess();
            if (home == 1) {
                
                session.put("home1", "home1");
                lisAbout = da.getListAbout();
                lisLogo = da.getListLogo();
                h = da.getHome();
                if (h != null) {
                    return SUCCESS;
                }
            }
            if (home == 2) {
                session.put("home2", "home2");
                lisAbout = da.getListAbout();
                return SUCCESS;
            }
            if (home == 3) {
                session.put("home3", "home2");
                lisAbout = da.getListAbout();
                lis = da.getListSlide();
                return SUCCESS;
            }
            if (home == 4) {
                session.put("home4", "home2");
                lisAbout = da.getListAbout();
                lisLogo = da.getListLogo();
                return SUCCESS;
            }
            
            if (editIdAbout>0 || home == 5) {
                session.put("home5", "home2");
                a = da.getAboutById(editIdAbout);
                lisAbout = da.getListAbout();
                return SUCCESS;
            }

            if (iddelete > 0) {
                boolean bl = da.deleteSlide(iddelete);
                if (bl) {
                    return SUCCESS;
                }
            }
            if(idAboutdelete>0){
                boolean bl = da.deleteAbout(idAboutdelete);
                return SUCCESS;
            }
            if (logodelete > 0) {
                boolean bl = da.deleteLogo(logodelete);
                if (bl) {
                    return SUCCESS;
                }
            }
            if (id == 1) {

                boolean bl = uploadImag();
                if (bl == true) {
                    boolean add = da.uploadSlide(new Home("upload/slide/" + myFileFileName));
                    if (add == true) {
                        ActionContext.getContext().getSession().put("myFile1", myFileFileName + "Upload Success");
                        ActionContext.getContext().getSession().put("logo", myFileFileName);
                        return SUCCESS;
                    } else {
                        ActionContext.getContext().getSession().put("myFile1", myFileFileName + "Can not add file name to database");
                        return ERROR;
                    }
                } else {
                    ActionContext.getContext().getSession().put("myFile1", myFileFileName + " this avaiable in folder Slide, pleaes rename file");
                    return ERROR;
                }
            }
            if (id == 2) {
                h = da.getHome();
                session.put("home1", "home1");
                if (title.isEmpty() || content1.isEmpty() || content2.isEmpty() || content3.isEmpty() || link.isEmpty()) {
                    session.put("error", "not be so empty Fields marked *");
                    return ERROR;
                } else {
                    if (title.length() > 200 || content1.length() > 277 || content3.length() > 277 || content2.length() > 277 || link.length()>100) {
                        session.put("error", "characters at schools are being exceeded allowable number, please check back");
                        return ERROR;
                    } else {
                        boolean bl = da.editHome(new Home(logo, title, content1, content2, content3 ,link));
                        if (bl == false) {
                            session.put("error", "Edit Fauil");
                            return ERROR;
                        } else {
                            session.put("error", "Edit Success");
                            return SUCCESS;
                        }
                    }
                }

            }
            if (id == 3) {
                boolean bl = uploadLogo();
                if (bl == true) {
                    boolean add = da.uploadLogo(new Logo("upload/logo/" + myFileFileName));
                    if (add == true) {
                        ActionContext.getContext().getSession().put("myFile1", myFileFileName + "Upload Success");
                        ActionContext.getContext().getSession().put("logo", myFileFileName);
                        return SUCCESS;
                    } else {
                        ActionContext.getContext().getSession().put("myFile1", myFileFileName + "Can not add file name to database");
                        return ERROR;
                    }
                } else {
                    ActionContext.getContext().getSession().put("myFile1", myFileFileName + " this avaiable in folder Slide, pleaes rename file");
                    return ERROR;
                }
            }
            if(id==4){
                if (aboutTitle.isEmpty() || description.isEmpty()) {
                    session.put("error", "not be so empty Fields marked *");
                    return ERROR;
                } else {
                    if (aboutTitle.length() > 300 || description.length() > 1000) {
                        session.put("error", "characters at schools are being exceeded allowable number, please retry*");
                        return ERROR;
                    } else {
                        if (idAbout > 0) {
                            boolean bl = da.editAbout(new About(aboutTitle, description, idAbout));
                            if (bl == true) {
                                return SUCCESS;
                            } else {
                                session.put("error", "Can not add to database");
                                return ERROR;
                            }
                        } else {
                            boolean bl = da.addAbout(new About(aboutTitle, description));
                            if (bl == true) {
                                return SUCCESS;
                            } else {
                                session.put("error", "Can not add to database");
                                return ERROR;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
            return ERROR;
        }
        return ERROR;
    }
    public boolean uploadImag() {
        try {
            DataAccess da = new DataAccess();
            Home h = new Home();
            h = da.getHome();
            destPath = h.getRootUpload()+"upload\\slide";
            File destFile = new File(destPath, myFileFileName);
            FileUtils.copyFile(myFile, destFile);

        } catch (IOException ex) {
            Logger.getLogger(HomeAction.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean uploadLogo() {
        try {
            DataAccess da = new DataAccess();
            Home h = new Home();
            h = da.getHome();
            destPath = h.getRootUpload()+"upload\\logo";
            File destFile = new File(destPath, myFileFileName);
            FileUtils.copyFile(myFile, destFile);

        } catch (IOException ex) {
            Logger.getLogger(HomeAction.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
        
    public void setLink(String link) {
        this.link = link;
    }

    public void setAboutTitle(String aboutTitle) {
        this.aboutTitle = aboutTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Home> getLis() {
        return lis;
    }

    public void setId(int id) {
        this.id = id;
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

    public Home getH() {
        return h;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public void setIddelete(int iddelete) {
        this.iddelete = iddelete;
    }

    public List<Logo> getLisLogo() {
        return lisLogo;
    }

    public void setLogodelete(int logodelete) {
        this.logodelete = logodelete;
    }

    public List<About> getLisAbout() {
        return lisAbout;
    }

    public About getA() {
        return a;
    }

    public void setIdAbout(int idAbout) {
        this.idAbout = idAbout;
    }

    public void setEditIdAbout(int editIdAbout) {
        this.editIdAbout = editIdAbout;
    }

    public void setIdAboutdelete(int idAboutdelete) {
        this.idAboutdelete = idAboutdelete;
    }

    
}
