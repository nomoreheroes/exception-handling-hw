import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerReader implements Reader{

    private String[] source;
    private LinkedList<String> names = new LinkedList<String>();
    private Date birthDate;
    private String phoneNumber;
    private Character sex;

    private boolean isName(String str)
    {
            //строка из символов, первая буква заглавная, остальные - строчные
            Pattern pattern = Pattern.compile("^[A-ZА-Я][a-zа-я]+$");
            Matcher matcher = pattern.matcher(str);
            return matcher.find();
    }

    private boolean maybeDate(String str)
    {
        //строка "две цифры-точка-две цифры-точка-четыре цифры"
        Pattern pattern = Pattern.compile("^[0-9]{2}\\.[0-9]{2}\\.[0-9]{4}$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private boolean isPhoneNumber(String str)
    {
        //строка - несколько цифр
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    private boolean isSex(String s)
    {
        return s.charAt(0)=='f' || s.charAt(0) =='m';
    }

    public ScannerReader()
    {
        System.out.println("Введите данные в произвольном порядке: ФИО, дата рождения, номер телефона, пол (f/m)");
        //у меня windows，поэтому кодировка 866 (еще пришлось помучиться, прежде чем разобрался)
        //предполагаю, на других платформах все по другому
        Scanner scanner = new Scanner(System.in,"cp866");
        String s = scanner.nextLine();
        this.source = s.split("\\s+");;
        for(int i=0;i<this.source.length;i++)
        {
            //если нулевой элемент массива строка, то и первый и второй должны быть строками - это ФИО\
            if(isName(this.source[i]))
            {
                if(i+2 < this.source.length)
                {
                    this.names.add(this.source[i]);
                    if(this.isName(this.source[i+1]) && this.isName(this.source[i+2]))
                    {
                        this.names.add(this.source[i+1]);
                        this.names.add(this.source[i+2]);
                    } else {
                        new RuntimeException("Неверно введены данные: Фамилия, имя и отчество должны следовать друг за другом, разденные пробелом");
                    }
                    i = i+2;
                } else {
                    new RuntimeException("Неверно введены данные: Фамилия, имя и отчество должны следовать друг за другом, разденные пробелом");
                }
            }
            if(maybeDate(this.source[i])) 
            {
                try {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
                    this.birthDate = formatter.parse(this.source[i]);
                } catch (ParseException e) {
                    throw new RuntimeException("Неверный формат данных: неверно указана дата рождения");
                }
            }
            if(isPhoneNumber(this.source[i]))
            {
                this.phoneNumber = this.source[i];
            }
            if(isSex(this.source[i]))
            {
                this.sex = this.source[i].charAt(0);
            }
        }
        if(this.names.size()!=3) 
        {
            new RuntimeException("Неверно введены данные: Фамилия, имя и отчество обязательно должны быть указаны");
        }
        if(this.birthDate == null)
        {
            throw new RuntimeException("Неверный формат данных: не указана дата рождения");
        }
        if(this.phoneNumber== null)
        {
            throw new RuntimeException("Неверный формат данных: не указан номер телефона");
        }
        if(this.sex == null)
        {
            throw new RuntimeException("Неверный формат данных: не указан или неверно указан пол");
        }       
    }

    public LinkedList<String> getNames()
    {
        return this.names;

    };
    public Date getBirthDate()
    {
        return this.birthDate;

    };
    public String getPhoneNumber()
    {
        return this.phoneNumber;

    };
    public Character getSex()
    {
        return this.sex;
    };
}