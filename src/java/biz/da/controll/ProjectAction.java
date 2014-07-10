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
import entity.da.access.DataAccess;
import entity.da.access.Home;
import entity.da.access.Project;
import java.io.File;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Windows
 */
public class ProjectAction extends ActionSupport {
    private int id_user;
    private String start_time;
    private float total_price;
    private String phone;
    private String addresss;
    private String avatar;
    private String more;
    private int status;
    private String time_request;
    private File myFile;
    private String myFileContentType;
    private String myFileFileName;
    private String destPath;
    private int procc;
    public ProjectAction() {
    }
    
    public String execute() throws Exception {
            try {
            DataAccess da = new DataAccess();
            CartAccess ca = new CartAccess();
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("procc", null);
            session.put("cart", null);
            if (id_user < 0) {
                session.put("error", "We do not recognize your user ID. Contact your administrator");
                session.put("procc", "procc");
                return ERROR;
            } else {
                if (start_time.isEmpty() || phone.isEmpty() || addresss.isEmpty()) {
                    session.put("error", "The position of the character form * are required to enter the data");
                    session.put("procc", "procc");
                    return ERROR;
                } else {
                   
                    if (start_time.length() > 100 || phone.length() > 12 || addresss.length() > 200 || more.length() > 3000) {
                        session.put("error", "Note the number of characters at schools Start Day <100, Phone <12, Address <200, Request more <3000");
                        session.put("procc", "procc");
                        return ERROR;
                    } else {
                        if (!isNumeric(phone)) {
                            session.put("error", "Make sure the policy is the phone number of characters");
                            session.put("procc", "procc");
                            return ERROR;
                        } else {
                            if (uploadImag()) {
                                session.put("procc", "procc");
                                Date date = new Date();
                                SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a");
                                session.put("time_request", ft.format(date));
                                boolean bl = ca.createProject(new Project(id_user, start_time, total_price, Integer.parseInt(phone), addresss, "upload/avatar/" + myFileFileName, more, status, ft.format(date)));
                                if (bl) {
                                    session.put("procc", null);
                                    session.put("getProject", "getProject");
                                    Project p = ca.getIdByUserIDAndTime(ft.format(date), id_user);
                                    session.put("error", "We have received information about the project. We'll contact telephone number you provided, and execute the project on the date and location received as above.");
                                    session.put("id_project", p.getId());
                                    return SUCCESS;
                                } else {
                                    session.put("procc", "procc");
                                    session.put("error", "We can not take a project that you require at this time, please try again later ");
                                    return ERROR;
                                }
                            } else {
                                session.put("procc", "procc");
                                session.put("error", "Please use an avatar image by selecting");
                                return ERROR;
                            }
                        }
                    }
                }
            }
        } catch (Exception ex) {
             ex.printStackTrace();
            return ERROR;
        }

    }
      public boolean uploadImag() {
        DataAccess da = new DataAccess();
        Home h = new Home();
        h = da.getHome();
        destPath = h.getRootUpload()+"upload\\avatar";
        try {
            System.out.println("Src File name: " + myFile);
            System.out.println("Dst File name: " + myFileFileName);
            File destFile;
            try {
                destFile = new File(destPath, myFileFileName);
            } catch (Exception e) {
                return false;
            }
            FileUtils.copyFile(myFile, destFile);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void setProcc(int procc) {
        this.procc = procc;
    }

    
    public static boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }

   

    public void setTime_request(String time_request) {
        this.time_request = time_request;
    }

    
    public void setStatus(int status) {
        this.status = status;
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

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setMore(String more) {
        this.more = more;
    }

}
