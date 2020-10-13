
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class ReadAction extends ActionSupport {

    private static final long serialVersionUID = 6329394260276112660L;
    ResultSet rs = null;
    Bean bean = null;
    List<Bean> beanList = null;
    Admin admin = new Admin();
    private boolean noData = false;

    @Override
    public String execute() throws Exception {
        try {
            beanList = new ArrayList<Bean>();
            rs = admin.report();
            int i = 0;
            if (rs != null) {
                while (rs.next()) {
                    i++;
                    bean = new Bean();

                    bean.setId(rs.getString("id"));
                    bean.setDescription(rs.getString("description"));
                    bean.setRole(rs.getString("role"));

                    beanList.add(bean);
                }
            }
            if (i == 0) {
                noData = false;
            } else {
                noData = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return SUCCESS;
        return "READ";
    }

    public boolean isNoData() {
        return noData;
    }

    public void setNoData(boolean noData) {
        this.noData = noData;
    }

    public List<Bean> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<Bean> beanList) {
        this.beanList = beanList;
    }
}
