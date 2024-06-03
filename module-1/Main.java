import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        int[] randInt = new int[5];
        double[] randDouble = new double[5];
        Date date = new Date();
        File file = new File("EricWilliamsdatafile.dat");

        for(int x = 0; x < 5; x++) {
            randInt[x] = rand.nextInt(5) + 1;
        }

        for(int x = 0; x < 5; x++) {
            randDouble[x] = rand.nextDouble() * 5;
        }

        try{
            PrintWriter writer = new PrintWriter(file);
            for(int x = 0; x < 5; x++) {
                writer.println(randInt[x]);
            }
            for(int x = 0; x < 5; x++) {
                writer.println(randDouble[x]);
            }
            writer.println(date);

            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}