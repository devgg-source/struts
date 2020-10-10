import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.json.*;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

    private String user;
    private String password;
    private String name;
    // JDBC driver name and database URL
    // static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    // static final String DB_URL = "jdbc:mysql://localhost/stu";

    // Database credentials
    static final String USER = "karthik";
    static final String PASS = "1234";

    public String execute() throws Exception {
        String ret = "failure";
        Connection conn = null;
        // JSONObject js = new JSONObject();
        try {
            String URL = "jdbc:mysql://localhost/stu";
            System.out.println("hosted");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.print("loaded");
            conn = DriverManager.getConnection(URL, "karthik", "1234");
            System.out.println("connected");
            // System.out.println(username + " " + password);
            String sql = "SELECT username FROM login WHERE username = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("retrived");
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            System.out.println(user);
            System.out.println(password);
            System.out.println("haha");
            // rs.next();

            while (rs.next()) {
                name = rs.getString(1);
                System.out.println(name);
                System.out.println("executed");
                ret = "success";

            }
        } catch (Exception e) {
            ret = "failure";
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
        return ret;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}