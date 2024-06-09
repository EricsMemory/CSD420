import java.util.ArrayList;
import java.util.Random;

//CSD 420 Eric Williams-Phillips
//The purpose of this program is to generate 50 random numbers between 1 and 20 into an array and create a method that
//takes that array and returns all the original values EXCEPT for duplicates

public class Main {

    public static void main(String[] args) {

        //Creating an empty array
        ArrayList<Integer> originalArray = new ArrayList<>();

        //Creating a Random object
        Random rand = new Random();

        //Repeating the following action 50 times
        for (int i = 0; i <= 50; i++) {
            //Create a random number with a range of 20
            int range = rand.nextInt(20) + 1;
            //Add each of those numbers to the empty array created above
            originalArray.add(range);

        }

        //Print every value from the returned array of method below
        System.out.println(removeDuplicates(originalArray));
    }

    //Creating method that returns a clone of the original array but without duplicate numbers
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        //New empty array
        ArrayList<E> newArray = new ArrayList<>();

        //For every number in the designated array, add it to the new array if the new array does not already
        //contain it (this will ensure duplicates are not added)
        for (E e : list) {
            if (!newArray.contains(e)) {
                newArray.add(e);
            }
        }

        //Return the new array
        return newArray;
    }
}