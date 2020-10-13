
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {

    // method for create connection

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection("jdbc:mysql://localhost/stu?autoReconnect=true&useSSL=false", "karthik",
                    "1234");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // method for save user data in database
    public int createItem(String id, String description) throws Exception {
        int i = 0;
        try {
            String sql = "INSERT INTO crud VALUES (?,?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, description);

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

    public ResultSet report() throws SQLException, Exception {
        ResultSet rs = null;
        try {
            String sql = "SELECT id,description,role FROM crud";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }

    public ResultSet fetchDetails(String id) throws SQLException, Exception {
        ResultSet rs = null;
        try {
            String sql = "SELECT id,description FROM crud WHERE id=?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }

    public int updateDetails(String id, String description) throws SQLException, Exception {
        getConnection().setAutoCommit(false);
        int i = 0;
        try {
            String sql = "UPDATE crud SET id=?,description=? WHERE id=?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, description);
            ps.setString(3, id);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            getConnection().rollback();
            return 0;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }

    public int deleteDetails(String id1, String id2) throws SQLException, Exception {
        getConnection().setAutoCommit(false);
        int i = 0;
        try {
            String sql = "DELETE FROM crud WHERE id in (?,?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id1);
            ps.setString(2, id2);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            getConnection().rollback();
            return 0;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }
}
