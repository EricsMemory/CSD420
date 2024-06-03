import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read {

    public static void main(String[] args) {
        try{
            File myFile = new File("EricWilliamsdatafile.dat");
            Scanner scan = new Scanner(myFile);

            while(scan.hasNextLine()){
                System.out.println(scan.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
