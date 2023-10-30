import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Person {
    private String firstName;
    private String secondName;
    private String lastName;
    private Date birthDate;
    private String phoneNumber;
    private Character sex;

    public Person(String firstName, String secondName, String lastName, Date birthDate, String string, Character sex)
    {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = string;
        this.secondName = secondName;
        this.sex = sex;

    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return String return the secondName
     */
    public String getSecondName() {
        return secondName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return Date return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @return int return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    /**
     * @return Character return the sex
     */
    public Character getSex() {
        return sex;
    }

    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        return String.format("<%s><%s><%s><%s><%s><%s>\n",this.lastName,this.firstName, this.secondName, formatter.format(this.birthDate), this.phoneNumber,this.sex);
    }

}