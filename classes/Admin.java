package apache.webapps.struts.webinf.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/websparrow", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int registerUser(String uname, String uemail, String upass, String udeg) throws Exception {
        int i = 0;
        try {
            String sql = "INSERT INTO STRUTS2CRUD VALUES (?,?,?,?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, uemail);
            ps.setString(3, upass);
            ps.setString(4, udeg);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }
}
