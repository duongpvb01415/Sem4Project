/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.da.access;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jv.controll.District;

/**
 *
 * @author Windows
 */
public class DataAccess {

    private static Connection getConecter() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EProject1;user=sa;password=123456");
        } catch (Exception ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Contact getContact() {
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Contact");
            ResultSet rs = ps.executeQuery();
            Contact c;
            while (rs.next()) {
                c = new Contact();
                c.setCompany(rs.getString("company"));
                c.setPhone(rs.getString("phone"));
                c.setFax(rs.getString("fax"));
                c.setEmail(rs.getString("email"));
                c.setAddress1(rs.getString("address1"));
                c.setAddress2(rs.getString("address2"));
                c.setContry(rs.getString("contry"));
                c.setTimeIn1(rs.getString("timeIn1"));
                c.setTimeOut1(rs.getString("timeOut1"));
                c.setTimeIn2(rs.getString("timeIn2"));
                c.setTimeOut2(rs.getString("timeOut2"));
                c.setContent(rs.getString("content"));
                c.setTitle(rs.getString("title"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean adminEditContact(Contact c) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("update Contact set company=?, phone=?, fax=?, email=?, address1=?, address2=?, contry=?, timeIn1=?, timeOut1=?, timeIn2=?, timeOut2=?, content=?, title=?");
            ps.setString(1, c.getCompany());
            ps.setString(2, c.getPhone());
            ps.setString(3, c.getFax());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getAddress1());
            ps.setString(6, c.getAddress2());
            ps.setString(7, c.getContry());
            ps.setString(8, c.getTimeIn1());
            ps.setString(9, c.getTimeOut1());
            ps.setString(10, c.getTimeIn2());
            ps.setString(11, c.getTimeOut2());
            ps.setString(12, c.getContent());
            ps.setString(13, c.getTitle());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("OK");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean addComment(CommentSendMail csm) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into Comment values(?,?,?,?)");
            ps.setString(1, csm.getUserName());
            ps.setString(2, csm.getEmail());
            ps.setString(3, csm.getUserPhone());
            ps.setString(4, csm.getBody());
            int set = ps.executeUpdate();
            if (set > 0) {
                System.out.println("ok");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<CommentSendMail> getListComment() {
        List<CommentSendMail> clist = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Comment");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clist.add(new CommentSendMail(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"), rs.getString("body")));
                System.out.println(clist);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clist;
    }

    public boolean deleteComment(int id) {
        PreparedStatement ps;
        try {
            ps = getConecter().prepareStatement("delete from Comment where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public CommentSendMail getComment(int id) {
        PreparedStatement ps;
        try {
            ps = getConecter().prepareStatement("select * from Comment where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CommentSendMail cm = new CommentSendMail();
                cm.setBody(rs.getString("body"));
                cm.setUserName(rs.getString("name"));
                cm.setUserPhone(rs.getString("phone"));
                cm.setEmail(rs.getString("email"));
                return cm;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Users getInfoUser(String email) {
        Users u = new Users();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Users where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setAddress(rs.getString("adress"));
                u.setPhone(rs.getString("phone"));
                u.setBirth(rs.getString("birth"));
                u.setGender(rs.getBoolean("gender"));
                u.setPassword(rs.getString("pass"));
                u.setTypeadmin(rs.getBoolean("typeadmin"));
                System.out.println(u);
                return u;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean addUser(Users u) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into Users values(?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getPhone());
            ps.setString(5, u.getAddress());
            ps.setString(6, u.getBirth());
            ps.setBoolean(7, u.isGender());
            ps.setBoolean(8, u.isTypeadmin());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("OK");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<Users> getListUser(boolean type) {
        List<Users> ulist = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Users where typeadmin=? order by id desc");
            ps.setBoolean(1, type);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ulist.add(new Users(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("pass"), rs.getString("phone"), rs.getString("adress"), rs.getString("birth"), rs.getBoolean("gender")));
                System.out.println(ulist);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ulist;
    }

    public Users getUserById(int id) {
        Users u = new Users();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Users where id=? order by id");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setPassword(rs.getString("pass"));
                u.setPhone(rs.getString("phone"));
                u.setAddress(rs.getString("adress"));
                u.setBirth(rs.getString("birth"));
                u.setTypeadmin(rs.getBoolean("typeadmin"));
                u.setGender(rs.getBoolean("gender"));
                System.out.println(u);
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean editUser(Users u) {

        try {
            PreparedStatement ps = getConecter().prepareStatement("update Users set name=?, email=?, pass=?, phone=?, adress=?, birth=?, typeadmin=?, gender=? where id=?");

            ps.setString(1, u.getName());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getPhone());
            ps.setString(5, u.getAddress());
            ps.setString(6, u.getBirth());
            ps.setBoolean(7, u.isTypeadmin());
            ps.setBoolean(8, u.isGender());
            ps.setInt(9, u.getId());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("ok");
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("delete from Users where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public boolean addDistrict(District d){
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into District values(?)");
            ps.setString(1, d.getName());
            int rs = ps.executeUpdate();
            if(rs>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean editDistrict(District d){
        try {
            PreparedStatement ps = getConecter().prepareStatement("update District set name=? where id=?");
            ps.setString(1, d.getName());
            ps.setInt(2, d.getId());
            int rs = ps.executeUpdate();
            if(rs>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public District getDistrictById(int id){
        District d = new District();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from District where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                System.out.println(d);
                return d;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    public boolean deleteDistrict(int id){
        try {
            PreparedStatement ps = getConecter().prepareStatement("DELETE FROM District where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if(rs>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<District> getAllDistrict(){
        List<District> lisD = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from District");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lisD.add(new District(rs.getInt("id"), rs.getString("name")));
                System.out.println(lisD);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lisD;
    }
    
    public boolean addCategory(Category u) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into Category values(?, ?)");
            ps.setString(1, u.getName());
            ps.setInt(2, u.getDescriptions());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    } 
    
    public List<Category> getCategoryByDistrict(int id_District){
        List<Category> lisCategory = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Category where id_district=?");
            ps.setInt(1, id_District);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                lisCategory.add(new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("id_district")));
                System.out.println(lisCategory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lisCategory;
    }
    
    public List<Service> getServiceByDistrict(int id_District){
        List<Service> lisService = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select id from Category where id_district=?");
            ps.setInt(1, id_District);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                PreparedStatement ps1 = getConecter().prepareStatement("select * from Servicer where id_category=?");
                ps1.setInt(1, rs.getInt("id"));
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {                    
                    lisService.add(new Service(rs1.getInt("id"), rs1.getInt("id_category"),rs1.getString("name"), rs1.getString("contents"), rs1.getFloat("price"), rs1.getString("images"), rs1.getString("descriptions"), rs1.getInt("day_completion")));
                    System.out.println(lisService);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lisService;
    }
    
    public List<Category> getListCategory() {
        List<Category> list = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Category");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("id_district")));
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public boolean addService(Service s) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into Servicer values(?,?,?,?,?,?,?)");
            ps.setInt(1, s.getId_category());
            ps.setString(2, s.getName());
            ps.setString(3, s.getContent());
            ps.setFloat(4, s.getPrice());
            ps.setString(5, s.getImages());
            ps.setString(6, s.getDescriptions());
            ps.setInt(7, s.getDay_completion());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("ok");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean editService(Service s) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("update Servicer set id_category=?, name=?, contents=?, price=?, images=?, descriptions=?, day_completion=? where id=?");
            ps.setInt(1, s.getId_category());
            ps.setString(2, s.getName());
            ps.setString(3, s.getContent());
            ps.setFloat(4, s.getPrice());
            ps.setString(5, s.getImages());
            ps.setString(6, s.getDescriptions());
            ps.setInt(7, s.getDay_completion());
            ps.setInt(8, s.getId());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public Service getServiceById(int id) {
        Service s = new Service();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Servicer where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setId_category(rs.getInt("id_category"));
                s.setName(rs.getString("name"));
                s.setContent(rs.getString("contents"));
                s.setPrice(rs.getFloat("price"));
                s.setImages(rs.getString("images"));
                s.setDescriptions(rs.getString("descriptions"));
                s.setDay_completion(rs.getInt("day_completion"));
                System.out.println(s);
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public List<Service> getListByIdCategory(int id) {
        List<Service> list = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Servicer where id_category=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Service(rs.getInt("id"), rs.getInt("id_category"), rs.getString("name"), rs.getString("contents"),  rs.getFloat("price"), rs.getString("images"), rs.getString("descriptions"), rs.getInt("day_completion")));
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public List<Service> getAllListService() {
        List<Service> list = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Servicer");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Service(rs.getInt("id"), rs.getInt("id_category"), rs.getString("name"), rs.getString("contents"), rs.getFloat("price"), rs.getString("images"), rs.getString("descriptions"), rs.getInt("day_completion")));
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public boolean deleteCategory(int id) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("delete from Category where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (deleteServiceByIDCategory(id) == true) {
                if (rs > 0) {
                    System.out.println("ok");
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static boolean deleteServiceByIDCategory(int id_category) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("delete from Servicer where id_category=?");
            ps.setInt(1, id_category);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean deleteService(int id) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("delete from Servicer where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public Category getByIdCategory(int id) {
        Category c = new Category();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Category where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescriptions(rs.getInt("id_district"));
                System.out.println(c);
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean editCategory(Category c) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("update Category set name=?, id_district=? where id=?");
            ps.setString(1, c.getName());
            ps.setInt(2, c.getDescriptions());
            ps.setInt(3, c.getId());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("ok");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean addFaq(Faq f) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into Faq values(?,?)");
            ps.setString(1, f.getQuestion());
            ps.setString(2, f.getRespones());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("ok");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean addNews(News f) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into News values(?,?,?)");
            ps.setString(1, f.getName());
            ps.setString(2, f.getDesc());
            ps.setString(3, f.getCurrentDate());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("ok");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean editNews(News f) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("update News set name=?, desciption=?, currentDate=? where id=?");
            ps.setString(1, f.getName());
            ps.setString(2, f.getDesc());
            ps.setString(3, f.getCurrentDate());
            ps.setInt(4, f.getId());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("ok");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<News> getAllNews() {
        List<News> list = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from News order by id desc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new News(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"), rs.getString("currentDate")));
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public News getNewById(int id) {
        News n = new News();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from News where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                n.setId(rs.getInt("id"));
                n.setName(rs.getString("name"));
                n.setDesc(rs.getString("desciption"));
                n.setCurrentDate(rs.getString("currentDate"));
                System.out.println(n);
                return n;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return n;
    }
    
    public List<News> getNewsTop5Desc() {
        List<News> lisN = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("SELECT TOP 5 * from News order by id desc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lisN.add(new News(rs.getInt("id"), rs.getString("name"), rs.getString("desciption"), rs.getString("currentDate")));
                System.out.println(lisN);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lisN;
    }
    
    public List<Category> getCategoryTop5Desc() {
        List<Category> lisN = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("SELECT TOP 6 * from Category order by id desc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lisN.add(new Category(rs.getInt("id"), rs.getString("name"), rs.getInt("id_district")));
                System.out.println(lisN);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lisN;
    }

    public boolean deleteNew(int id) {
        PreparedStatement ps;
        try {
            ps = getConecter().prepareStatement("delete from News where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean editFaq(Faq f) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("update Faq set questions=?, response=? where id=?");
            ps.setString(1, f.getQuestion());
            ps.setString(2, f.getRespones());
            ps.setInt(3, f.getId());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("ok");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public Faq getFaqById(int id) {
        Faq f = new Faq();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Faq where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                f.setId(rs.getInt("id"));
                f.setQuestion(rs.getString("questions"));
                f.setRespones(rs.getString("response"));
                System.out.println(f.toString());
                return f;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return f;
    }

    public List<Faq> getListFaq() {
        List<Faq> ls = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Faq");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ls.add(new Faq(rs.getInt("id"), rs.getString("questions"), rs.getString("response")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ls;
    }

    public boolean deleteFaq(int id) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("delete from Faq where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("ok");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean editHome(Home h) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("update Home set logo=?, title=?, content1=?, content2=?, content3=?, rootUpload=?");
            ps.setString(1, h.getLogo());
            ps.setString(2, h.getTitle());
            ps.setString(3, h.getContent1());
            ps.setString(4, h.getContent2());
            ps.setString(5, h.getContent3());
            ps.setString(6, h.getRootUpload());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean editLogo(Home h) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("update Home set logo=?");
            ps.setString(1, h.getLogo());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Home getHome() {
        Home h = new Home();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Home");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                h.setLogo(rs.getString("logo"));
                h.setTitle(rs.getString("title"));
                h.setContent1(rs.getString("content1"));
                h.setContent2(rs.getString("content2"));
                h.setContent3(rs.getString("content3"));
                h.setRootUpload(rs.getString("rootUpload"));
                System.out.println(h);
                return h;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return h;
    }

    public boolean uploadSlide(Home h) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into Slide values(?)");
            ps.setString(1, h.getSlide());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("OK");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean uploadLogo(Logo l) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into Logo values(?)");
            ps.setString(1, l.getLogo());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("OK");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<Home> getListSlide() {
        List<Home> lis = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Slide");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lis.add(new Home(rs.getInt("id"), rs.getString("slide")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lis;
    }

    public List<Logo> getListLogo() {
        List<Logo> lis = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from Logo");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lis.add(new Logo(rs.getInt("id"), rs.getString("logo")));
                System.out.println(lis);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lis;
    }

    public boolean deleteSlide(int id) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("delete from Slide where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("OK");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean deleteLogo(int id) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("delete from Logo where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("OK");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean addAbout(About a) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into About values(?,?)");
            ps.setString(1, a.getTitle());
            ps.setString(2, a.getDescriptions());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("ok");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean editAbout(About a) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("update About set title=?, descriptions=? where id=?");
            ps.setString(1, a.getTitle());
            ps.setString(2, a.getDescriptions());
            ps.setInt(3, a.getId());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<About> getListAbout() {
        List<About> lis = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from About");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lis.add(new About(rs.getInt("id"), rs.getString("title"), rs.getString("descriptions")));
                System.out.println(lis);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lis;
    }

    public About getAboutById(int id) {
        About a = new About();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from About where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                a.setTitle(rs.getString("title"));
                a.setDescriptions(rs.getString("descriptions"));
                System.out.println(a);
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return a;
    }

    public boolean deleteAbout(int id) {
        try {
            PreparedStatement ps = getConecter().prepareStatement("delete from About where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("OK");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                getConecter().close();
            } catch (SQLException ex) {
                Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public List<About> getTop2Desc() {
        List<About> lisA = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("SELECT TOP 2 * from About order by id desc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lisA.add(new About(rs.getInt("id"), rs.getString("title"), rs.getString("descriptions")));
                System.out.println(lisA);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lisA;
    }
    
    public boolean addCommentProject(CommentProject cp){
        try {
            PreparedStatement ps = getConecter().prepareStatement("insert into CommentProject values(?,?,?,?)");
            ps.setInt(1, cp.getId_user());
            ps.setInt(2, cp.getId_project());
            ps.setString(3, cp.getTime_content());
            ps.setString(4, cp.getContent());
            int rs = ps.executeUpdate();
            if(rs>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<CommentProject> getByIdProject(int id_project){
        List<CommentProject> lis = new LinkedList<>();
        try {
            PreparedStatement ps = getConecter().prepareStatement("select * from CommentProject where id_project=?");
            ps.setInt(1, id_project);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {             
                PreparedStatement ps1 = getConecter().prepareStatement("select name from Users where id=?");
                ps1.setInt(1, rs.getInt("id_user"));
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {                    
                    lis.add(new CommentProject(rs.getInt("id"), rs1.getString("name"), rs.getInt("id_project"), rs.getString("time_content"), rs.getString("content")));
                    System.out.println(lis);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lis;
    }
    
   
    public static void main(String[] args) {
        DataAccess c = new DataAccess();
//        c.editUser(new Users("Nguyen The Duy", "duydata@gmail.com", "123456", "0915996588", "Hoi tu ben xe", "08-02-1996", false, false, 7));
//       
//        c.addService(new Service(1, "Nội Thất Văn Phòng", "Nội Thất Văn Phòng", 100, "Nội Thất Văn Phòng", "Nội Thất Văn Phòng", 3));
//           c.getServiceById(3);
//        c.addCategory(new Category("Nội Thất Văn Phòng", 1));
//        c.getAllDistrict();
//        c.getListCategory();
//        c.getCategoryByDistrict(13);
//        c.getServiceById(23);
//        c.getServiceByDistrict(15);
//        c.getListCategory();
//        c.getListByIdCategory(2);
//        c.getInfoUser("duynt60@gmail.com");
//        c.getByIdProject(91);
//        c.getListUser(true);
        c.getUserById(12);
    }
}
