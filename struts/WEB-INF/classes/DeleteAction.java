
import com.opensymphony.xwork2.ActionSupport;

import jdk.jfr.Description;

public class DeleteAction extends ActionSupport {

    private static final long serialVersionUID = -146601914103585418L;
    String id, msg;
    Admin adm = new Admin();

    @Override
    public String execute() throws Exception {
        try {
            int isDeleted = adm.deleteDetails(id);
            if (isDeleted > 0) {
                msg = "Record deleted successfully";
            } else {
                msg = "Some error";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "DELETE";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
