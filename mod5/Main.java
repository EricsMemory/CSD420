import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

//Eric Williams-Phillips CSD 420 Module 5 Assignment
//The purpose of this assignment is to read a set of words from a file and print the non-duplicates
//in both ascending and descending order

public class Main {
    public static void main(String[] args) {

        //Creating a path for my text file
        String path = "src\\collection_of_words.txt";

        //Creating a hashset that will automatically remove duplicates
        Set<String> nonDupeDesc = new HashSet<>();

        try {
            //Add the lines from the text file into a List of Strings
            List<String> words = Files.readAllLines(Paths.get(path));

            //Append the entire list to the Set to have duplicates removed
            nonDupeDesc.addAll(words);

            //Prints the set in its natural order
            System.out.println(nonDupeDesc);

            //Create a List of Strings and append the Hashset contents to it (this will also have no duplicates)
            List<String> reverseWords = new ArrayList<>(nonDupeDesc);

            //Reverses and prints the List of Strings with no duplicates
            Collections.reverse(reverseWords);
            System.out.println(reverseWords);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}