import java.io.File;
import java.io.IOException;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.start();

    }

    private void start() throws IOException {

        WriteToFile writeToFile = new WriteToFile();

        Vehicle vehicle1 = new Vehicle("skoda", 2005, "5ac4487", "red", 7.5);
        Vehicle vehicle2 = new Vehicle();

        Student student1 = new Student("Petr", "Vesely", LocalDate.of(2008,11,9), "8a");

        File file = new File("out.csv");

        writeToFile.writeToFile(file.toPath(), vehicle2);

    }



}
