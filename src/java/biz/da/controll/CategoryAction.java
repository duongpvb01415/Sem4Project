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
import entity.da.access.Category;
import entity.da.access.DataAccess;
import java.util.Map;

/**
 *
 * @author Windows
 */
public class CategoryAction extends ActionSupport {
    private int category;
    private String nameCategory;
    private int descriptions;
    private int idCategory;
    public CategoryAction() {
    }
    
    public String execute() throws Exception {
        
        try {
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("addCategory", "addCategory");
            if (nameCategory.isEmpty()) {
                session.put("categoryError", "Merge fields are not empty");
                return ERROR;
            } else {
                if (nameCategory.length() > 100) {
                    session.put("categoryError", "data in fields that are too much for regulative");
                    return ERROR;
                } else {
                    if (category > 0) {

                        DataAccess da = new DataAccess();
                        boolean bl = da.editCategory(new Category(nameCategory, descriptions, category));
                        if (bl == true) {
                            session.put("categoryError", null);
                            session.put("close", "close");
                            return SUCCESS;
                        } else {
                            session.put("categoryError", "category can not be created at this time");
                            return ERROR;
                        }
                    } else {

                        DataAccess da = new DataAccess();
                        boolean bl = da.addCategory(new Category(nameCategory, descriptions));
                        if (bl == true) {
                            session.put("categoryError", null);
                            session.put("close", "close");
                            return SUCCESS;
                        } else {
                            session.put("categoryError", "category can not be created at this time");
                            return ERROR;
                        }
                    }
                }
            }
        } catch (Exception e) {
            return ERROR;
        }
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setDescriptions(int descriptions) {
        this.descriptions = descriptions;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
    
}
