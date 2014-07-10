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
import java.util.Map;

/**
 *
 * @author Windows
 */
public class LogoutAction extends ActionSupport {
    
    public LogoutAction() {
    }
    
    public String execute() throws Exception {
        try {
            Map<String, Object> session = ActionContext.getContext().getSession();
            session.put("name", null);
            session.put("email", null);
            session.put("birth", null);
            session.put("gender", null);
            session.put("admin", null);
            session.put("id", null);
            session.put("show", null);
            return SUCCESS;
        } catch (Exception e) {
            return ERROR;
        }
    }
    
}
