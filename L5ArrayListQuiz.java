import java.util.Scanner;
import java.util.ArrayList;

public class L5ArrayListQuiz {
    
/*
 * Part A: Answer the following question as a comment in the java program:a) What are the pros and cons of the data structure arraylist?
 * Pros:
 * - Dynamic size --> ArrayLists can grow and shrink depending on the needs of the program
 * - Can add and remove methods and the size will adjust accordingly
 * - ArrayList class has built in methods such as search and sort
 * Cons:
 * - Can only hold object types, not primitive types
 * - Take up more memory - can be slower
 */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        ArrayList<String> a1 = new ArrayList<String>();
        String input;

        System.out.println("The initial size of a1 after declaration is: " + a1.size()); //output would be 0

        System.out.println("Press a key to continue");
        input = sc.nextLine();

        a1.add("C");
        a1.add("A");
        a1.add("E");
        a1.add("B");
        a1.add("D");
        a1.add("F");

        //Inserting an item A2 in the second position of the array (in between C and A)

        a1.add(1, "A2");

        System.out.println("The size of a1 after entering 7 items is: " + a1.size()); //output would be 7

        System.out.println("The contents of a1 is: " + a1); // output would be [C, A2, A, E, B, D, F]

        a1.remove("F");
        a1.remove(2);

        System.out.println("The size of a1 after removing 2 items is: " + a1.size()); //output would be 5

        System.out.println("The contents of a1 after these removals is: " + a1); // output would be [C, A2, E, B, D, F]
    }

}
