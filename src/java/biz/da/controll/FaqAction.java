/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package biz.da.controll;

import static com.opensymphony.xwork2.Action.ERROR;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import entity.da.access.DataAccess;
import entity.da.access.Faq;
import entity.da.access.News;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Windows
 */
public class FaqAction extends ActionSupport {
    private int id;
    private String name;
    private String desc;
    private int addNew;
    private List<News> list;
    private List<Faq> ls;
    private News n;
    private String question;
    private String response;
    private Faq f;
    private int addFaq;
    public FaqAction() {
    }
    
    public String execute() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        DataAccess da = new DataAccess();
        list = da.getAllNews();
        ls = da.getListFaq();
        session.put("addFaq", null);
        session.put("addNews", null);
        
        if(id==1){
            session.put("addFaq", "addFaq");
        }else if(id==2){
            session.put("addFaq", null);
            session.put("addNews", "addNews");
        }
        n = da.getNewById(id);
        if(addNew>0){
            if(addNews()==false){
                return ERROR;
            }
        }
        if(addFaq>0){
            if(addFaq()==false){
                return ERROR;
            }
        }
        return SUCCESS;
    }
    public boolean addNews(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        DataAccess da = new DataAccess();
        if (name.isEmpty() || desc.isEmpty()) {
                session.put("errorEmpty", "Not to empty one of the above");
                return false;
            } else {
                if (name.length() > 65 || desc.length() > 3000) {
                    session.put("errorEmpty", "characters must not be allowed limit.");
                    return false;
                } else {
                    if(id>0){
                        Date date = new Date();
                        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a");
                        boolean bl = da.editNews(new News(name, desc, ft.format(date), id));
                        if (bl == false) {
                            session.put("errorEmpty", "Edit new error unknown");
                            return false;
                        } else {
                            session.put("errorEmpty", "Edit New Success");
                        }
                    }else{
                        
                        Date date = new Date();
                        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a");
                        boolean bl = da.addNews(new News(name, desc, ft.format(date)));
                        if (bl == false) {
                            session.put("errorEmpty", "Add new error unknown");
                            return false;
                        } else {
                            session.put("errorEmpty", "Add New Success");
                        }
                    }
                }
            }
        return true;
    }

    public boolean addFaq(){
        Map<String, Object> session = ActionContext.getContext().getSession();
        DataAccess da = new DataAccess();
        if(question.isEmpty() || response.isEmpty()){
            session.put("errorFaq", "Not to empty one of the above");
            return false;
        }else{
            if(question.length()>200 || response.length()>3000){
                session.put("errorFaq", "characters must not be allowed limit.");
                return false;
            }else{
                if(id>0){
                    boolean bl = da.editFaq(new Faq(question, response,id));
                    f = da.getFaqById(id);
                    if(bl==false){
                        session.put("errorFaq", "Add new error unknown");
                        return false;
                    }else{
                        session.put("errorFaq", "Add New Success");
                        return true;
                    }
                }else{
                    boolean bl = da.addFaq(new Faq(question, response));
                    f = da.getFaqById(id);
                    if(bl==false){
                        session.put("errorFaq", "Add new error unknown");
                        return false;
                    }else{
                        session.put("errorFaq", "Add New Success");
                        return true;
                    }
                }
            }
        }
    }
    
    public List<News> getList() {
        return list;
    }

    public List<Faq> getLs() {
        return ls;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setAddNew(int addNew) {
        this.addNew = addNew;
    }

    public Faq getF() {
        return f;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setAddFaq(int addFaq) {
        this.addFaq = addFaq;
    }

}
