/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.da.access;

import com.opensymphony.xwork2.Result;
import java.sql.Connection;
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
public class CartAccess {

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=EProject1;user=sa;password=123456");
        } catch (Exception ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean addCart(Cart c) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("insert into Cart values(?,?,?,?,?,?,?,?)");
            ps.setInt(1, c.getId_user());
            ps.setInt(2, c.getId_dis());
            ps.setString(3, c.getName_service());
            ps.setFloat(4, c.getPrice_service());
            ps.setInt(5, c.getDay_service());
            ps.setString(6, c.getImage_service());
            ps.setInt(7, c.getId_service());
            ps.setInt(8, c.getQuatity());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("ok");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delCart(int id) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("delete from Cart where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Cart> getCartByIdUser(int id_user) {
        List<Cart> lisCart = new LinkedList<>();
        try {
            PreparedStatement ps = getConnection().prepareStatement("select * from Cart where id_user=? order by id desc");
            ps.setInt(1, id_user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lisCart.add(new Cart(rs.getInt("id"), rs.getInt("id_user"), rs.getInt("id_dis"), rs.getString("name_service"), rs.getFloat("price_service"), rs.getInt("day_service"), rs.getString("image_service"), rs.getInt("id_service"), rs.getInt("quatity")));
                System.out.println(lisCart);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lisCart;
    }

    public District getIdByIdService(int id_service) {
        District d = new District();
        try {
            PreparedStatement ps = getConnection().prepareStatement("select id_category from Servicer where id=?");
            ps.setInt(1, id_service);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                PreparedStatement ps1 = getConnection().prepareStatement("select id_district from Category where id=?");
                ps1.setInt(1, rs.getInt("id_category"));
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    PreparedStatement ps2 = getConnection().prepareStatement("select * from District where id=?");
                    ps2.setInt(1, rs1.getInt("id_district"));
                    ResultSet rs2 = ps2.executeQuery();
                    while (rs2.next()) {
                        d.setId(rs2.getInt("id"));
                        d.setName(rs2.getString("name"));
                        System.out.println(d);
                        return d;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public float getPriceByIdUser(int id_user) {
        float total = 0;
        try {
            PreparedStatement ps = getConnection().prepareStatement("select SUM(price_service) as TotalPrice from Cart where id_user=?");
            ps.setInt(1, id_user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getFloat("TotalPrice");
                System.out.println(total);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int getDayByIdUser(int id_user) {
        int total = 0;
        try {
            PreparedStatement ps = getConnection().prepareStatement("select SUM(day_service) as TotalDay from Cart where id_user=?");
            ps.setInt(1, id_user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                total = rs.getInt("TotalDay");
                System.out.println(total);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public boolean deleteCartAll(int id_user) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("delete from Cart where id_user=?");
            ps.setInt(1, id_user);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteCartByIdService(int id_service, int id_user) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("delete from Cart where id_service=? and id_user=?");
            ps.setInt(1, id_service);
            ps.setInt(2, id_user);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean createProject(Project p) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("insert into Project values(?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, p.getId_user());
            ps.setString(2, p.getStart_time());
            ps.setFloat(3, p.getTotal_price());
            ps.setInt(4, p.getPhone());
            ps.setString(5, p.getAddress());
            ps.setString(6, p.getAvatar());
            ps.setString(7, p.getMore());
            ps.setInt(8, p.getStartus());
            ps.setString(9, p.getTime_request());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("OK");
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Project getIdByUserIDAndTime(String time, int id_user) {
        Project p = new Project();
        try {
            PreparedStatement ps = getConnection().prepareStatement("select * from Project where id_user=? and time_request=?");
            ps.setInt(1, id_user);
            ps.setString(2, time);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setId_user(rs.getInt("id_user"));
                p.setStart_time(rs.getString("start_time"));
                p.setTotal_price(rs.getFloat("total_price"));
                p.setPhone(rs.getInt("phone"));
                p.setAddress(rs.getString("addresss"));
                p.setAvatar(rs.getString("avatar"));
                p.setMore(rs.getString("more"));
                p.setStartus(rs.getInt("startus"));
                p.setTime_request(rs.getString("time_request"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    public Project getIdByUserID(int id) {
        Project p = new Project();
        try {
            PreparedStatement ps = getConnection().prepareStatement("select * from Project where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setId_user(rs.getInt("id_user"));
                p.setStart_time(rs.getString("start_time"));
                p.setTotal_price(rs.getFloat("total_price"));
                p.setPhone(rs.getInt("phone"));
                p.setAddress(rs.getString("addresss"));
                p.setAvatar(rs.getString("avatar"));
                p.setMore(rs.getString("more"));
                p.setStartus(rs.getInt("startus"));
                p.setTime_request(rs.getString("time_request"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public int getTotalHours(int id_project){
        int totalHour=0;
        try {
            PreparedStatement ps = getConnection().prepareStatement("select SUM(hour_service) as totalHour from OrderService where id_project=?");
            ps.setInt(1, id_project);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                totalHour = rs.getInt("totalHour");
                System.out.println(totalHour);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalHour;
    }

    public boolean addOrder(List<Cart> lisC, int id_project, int id_user) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("insert into OrderService values(?,?,?,?,?)");
            for (Cart cart : lisC) {
                ps.setInt(1, id_project);
                ps.setInt(2, cart.getId_service());
                ps.setFloat(3, cart.getPrice_service());
                ps.setInt(4, cart.getDay_service());
                ps.setString(5, cart.getName_service());
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    boolean bl = deleteCartByIdService(cart.getId_service(), id_user);
                    if (bl == false) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean testIdSerInCart(int id_user, int id_service){
        try {
            PreparedStatement ps = getConnection().prepareStatement("select id_service from Cart where id_user=? and id_service=?");
            ps.setInt(1, id_user);
            ps.setInt(2, id_service);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public List<Project> getProjectUser(int id_user) {
        List<Project> list = new LinkedList<>();
        try {
            PreparedStatement ps = getConnection().prepareStatement("select * from Project where id_user=? order by id desc");
            ps.setInt(1, id_user);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Project(rs.getInt("id"), rs.getInt("id_user"), rs.getString("start_time"), rs.getFloat("total_price"), rs.getInt("phone"), rs.getString("addresss"), rs.getString("avatar"), rs.getString("more"), rs.getInt("startus"), rs.getString("time_request")));
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean editStatusProject(int startus, int id_project) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("update Project set startus=? where id=?");
            ps.setInt(1, startus);
            ps.setInt(2, id_project);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Orders> getListServiceByIdProject(int id_project) {
        List<Orders> lisSv = new LinkedList<>();
        try {
            PreparedStatement ps = getConnection().prepareStatement("select * from OrderService where id_project=?");
            ps.setInt(1, id_project);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lisSv.add(new Orders(rs.getInt("id"), rs.getInt("id_project"), rs.getInt("id_service"), rs.getFloat("price_service"), rs.getInt("hour_service"), rs.getString("name_service")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lisSv;
    }
    public List<Project> getProjectStatus(int status) {
        List<Project> list = new LinkedList<>();
        try {
            PreparedStatement ps = getConnection().prepareStatement("select * from Project where startus=? order by id desc");
            ps.setInt(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Project(rs.getInt("id"), rs.getInt("id_user"), rs.getString("start_time"), rs.getFloat("total_price"), rs.getInt("phone"), rs.getString("addresss"), rs.getString("avatar"), rs.getString("more"), rs.getInt("startus"), rs.getString("time_request")));
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }


    public List<Project> getProject() {
        List<Project> list = new LinkedList<>();
        try {
            PreparedStatement ps = getConnection().prepareStatement("select * from Project order by id desc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Project(rs.getInt("id"), rs.getInt("id_user"), rs.getString("start_time"), rs.getFloat("total_price"), rs.getInt("phone"), rs.getString("addresss"), rs.getString("avatar"), rs.getString("more"), rs.getInt("startus"), rs.getString("time_request")));
                System.out.println(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Service> getListSerNews() {
        List<Service> lis = new LinkedList<>();
        try {
            PreparedStatement ps = getConnection().prepareStatement("SELECT TOP 4 * from Servicer order by id desc");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lis.add(new Service(rs.getInt("id"), rs.getInt("id_category"), rs.getString("name"), rs.getString("contents"), rs.getFloat("price"), rs.getString("images"), rs.getString("descriptions"), rs.getInt("day_completion")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lis;
    }

    public List<Project> getTop3ProjectAccomplished(int startus) {
        List<Project> lis = new LinkedList<>();
        try {
            PreparedStatement ps = getConnection().prepareStatement("SELECT TOP 3 * from Project where startus=? order by id desc");
            ps.setInt(1, startus);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lis.add(new Project(rs.getInt("id"), rs.getInt("id_user"), rs.getString("start_time"), rs.getFloat("total_price"), rs.getInt("phone"), rs.getString("addresss"), rs.getString("avatar"), rs.getString("more"), rs.getInt("startus"), rs.getString("time_request")));
                System.out.println(lis);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lis;
    }
    public boolean deleteProject(int id) {
        try {
            PreparedStatement ps = getConnection().prepareStatement("delete from Project where id=?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CartAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        CartAccess ca = new CartAccess();
//        ca.getIdByIdService(23);
//        ca.addCart(new Cart(2, ca.getIdByIdService(23).getId(), "Nội Thất Văn Phòng", 100, 3, "upload/Untitled.png"));
//        ca.getCartByIdUser(2);
//        ca.getPriceByIdUser(11);
//        ca.getDayByIdUser(11);
//        ca.createProject(new Project(2, "3-12-198", 300, 912966288, "Ha Dong", "imaf.jpf", "kodask", 1, "845"));
//        ca.getProjectUser(11);
//        ca.getListServiceByIdProject(25);
//        ca.getTop3ProjectAccomplished(1);
//        ca.getListServiceByIdProject(102);
//        ca.getTotalHours(102);
        ca.testIdSerInCart(12, 28);
    }
}
