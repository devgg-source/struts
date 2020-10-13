
import com.opensymphony.xwork2.ActionSupport;

public class CreateAction extends ActionSupport {

	// private static final long serialVersionUID = 2139116285823340125L;
	private String id, description;
	private String msg = "";
	Admin admin = null;
	int ctr = 0;

	public String execute() throws Exception {
		admin = new Admin();

		try {
			if (id.length() > 0 && description.length() > 0 && id != "" && description != "")
				ctr = admin.createItem(id, description);
			if (ctr > 0) {
				msg = "Item Created Successfully";
			} else {
				msg = "Some error";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "CREATE";
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

}
