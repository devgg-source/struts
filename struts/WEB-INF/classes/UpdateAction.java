
import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport {

    private static final long serialVersionUID = -1905974197186620917L;
    private String id = "";
    private String description = "";
    private String msg = "";
    ResultSet rs = null;
    Admin adm = new Admin();
    String submitType;

    public String execute() throws Exception {
        try {
            if (submitType.equals("updatedata")) {
                rs = adm.fetchDetails(id.trim());
                if (rs != null) {
                    while (rs.next()) {
                        id = rs.getString("id");
                        description = rs.getString("description");

                    }
                }
            } else {
                int i = adm.updateDetails(id, description);
                if (i > 0) {
                    msg = "Record Updated Successfuly";
                } else {
                    msg = "error";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "UPDATE";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }
}
