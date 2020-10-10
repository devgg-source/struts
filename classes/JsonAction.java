import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class JsonAction {

    private String name = "Atul Rai";
    private String[] education = { "MCA", "BCA" };
    private int mobileNumber = 123456789;
    private int[] favoriteNumber = { 11, 22, 33 };
    private Map<String, String> marks = new HashMap<String, String>();
    private List<String> books = new ArrayList<String>();

    public JsonAction() {
        books.add("Java");
        books.add("C");
        books.add("C++");
        books.add("PHP");
        marks.put("Java", "72");
        marks.put("C", "58");
        marks.put("C++", "83");
        marks.put("PHP", "66");
    }

    public String execute() {
        return Action.SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getEducation() {
        return education;
    }

    public void setEducation(String[] education) {
        this.education = education;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int[] getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(int[] favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }

    public Map<String, String> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, String> marks) {
        this.marks = marks;
    }
}