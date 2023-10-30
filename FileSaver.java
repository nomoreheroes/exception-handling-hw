import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileSaver implements Saver {

    @Override
    public void save(Person person) {
        String filename = String.format("%s.txt",person.getLastName());
        try {
            Writer fileWriter = new FileWriter(filename,true);
            fileWriter.write(person.toString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(String.format("Возникли проблемы с записью в файл: %s",e.getMessage()));
        }
    }
    
}