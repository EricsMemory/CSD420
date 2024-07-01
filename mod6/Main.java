import java.util.Arrays;
import java.util.Comparator;

//Eric WP CSD 420 Module 6 Programming Assignment
//The purpose of this assignment was to create two methods, one being a comparator and one being a sorting method using
//the created comparator. Then using the bubble sorting algorithm, sort a list using the sorting method and comparator.

public class Main {
    public static void main(String[] args) {

        Integer [] test = {2, 1, 4, 3, 5};
        bubbleSort(test);

        System.out.println(Arrays.toString(test));
    }


    //Creating a comparator to use in the overloaded method
    public static <E extends Comparable<E>> void bubbleSort(E[] list){
        bubbleSort(list, Comparable::compareTo);
    }

    //Creating overloaded sorting method using custom comparator
    public static <E extends Comparable <E>> void bubbleSort(E[] list, Comparator<? super E> comparator) {

        //Check to see if elements were switched or not
        boolean switched;

        //Iterates through the array and has an inner iteration
        for (int i = 0; i < list.length - 1; i++){
            switched = false;
            for (int j = 0; j < list.length - i - 1; j++){

                //If each number and the next are bigger than zero store that number in a temp variable
                if(comparator.compare(list[j],list[j + 1]) > 0){
                    //Creates an empty variable that stores the numbers during the swap
                    E temp = list[j];
                    //The two numbers are swapped and our checker is set to true
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    switched = true;
                }
            }
            if(!switched){
                break;
            }
        }
    }
}