package Lessons;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DarrenUtils {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    /*
     * The method printMenu is used to print an array of Strings in a menu format
     * @param: String[] options --> the menu options
     */
    public void printMenu(String[] options){
        System.out.println("What would you like to do?");

        for(int i = 0; i < options.length; i++){
            System.out.println((i+1) + ". " + options[i]);
        }

        System.out.println((options.length + 1) + ". Exit");
    }

    /*
     * the method printArray is used to print the contents of an array with size n
     * in a formatted manner
     * @param: int[] arr --> the given array
     */
    public void printArray(int[] arr) {
        System.out.print("[");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.print(arr[n - 1] + "]");
        System.out.println();
    }

    /*
     * the method buildArray is used to fill an empty array with int values
     * 
     * @return: int[] arr --> an array with values entered by the user
     */
    public int[] buildArray() throws IOException {
        System.out.println("What is the size of your array?");
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // loop through the size of the array and fill it with user input
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1));
            arr[i] = Integer.parseInt(br.readLine());
        }

        return arr;

    }
}
