import java.util.Iterator;
import java.util.LinkedList;

//Eric Williams-Phillips CSD420
//The purpose of this program is to demonstrate the difference in time it takes to traverse a LinkedList of integers
//using an iterator versus using the get(index) method.
public class Main {

    public static void main(String[] args) {

        //Creating Integer LinkedList
        LinkedList<Integer> intBag = new LinkedList<>();

        //Add numbers to the LinkedList
        for (int x = 0; x <= 500000; x++){
            intBag.add(x);

        }

        //Testing traversal with Iterator object, can also be written as a for-loop without the iterator object
        Iterator<Integer> iterator = intBag.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());

        }

        //Testing traversal with get(index) method
        for(Integer index : intBag){
            System.out.println(intBag.get(index));

        }
    }
}