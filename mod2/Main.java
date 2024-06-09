public class Main {

    //CSD 420 Eric Williams-Phillips Module 2 Programming Assignment
    //The task of this program was to accept an integer parameter and find the sum of all
    //numbers between 1/2 and i / i + 1

    public static void main(String[] args) {
        System.out.println(sum(9));
        System.out.println(sum(14));
        System.out.println(sum(4));

    }

    public static double sum(double i){

        //If our number is equal to 1, return 1 / 2
        if (i == 0){
            return ( i / (i + 1));
        }
        //Otherwise return i / i + 1 and add it to the result of this function but subtract 1 from i
        //This will continue to go until i = 1, and we can't subtract any further without breaking
        //the 0 denominator law of division
        else {
            return  (i / (i + 1)) + sum(i - 1);
        }

    }

}