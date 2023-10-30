import java.util.Date;
import java.util.LinkedList;

public interface Reader {
    public LinkedList<String> getNames();
    public Date getBirthDate();
    public String getPhoneNumber();
    public Character getSex();
}