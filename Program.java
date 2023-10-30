public class Program {
    public static void main(String[] args) {
        ScannerReader r = new ScannerReader();
        Person myFriend = new Person(r.getNames().get(1), r.getNames().get(2), r.getNames().get(0), r.getBirthDate(), r.getPhoneNumber(), r.getSex());
        FileSaver f = new FileSaver();
        f.save(myFriend);
    }
}