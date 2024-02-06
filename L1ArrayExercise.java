import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L1ArrayExercise{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{

        System.out.println("Welcome to the array builder program");
        System.out.println("What is the size of your array?");
        int n = Integer.parseInt(br.readLine());
        int[] numArray = new int[n];
        int sum = 0;

        //loop through the size of the array and fill it with user input
        for(int i = 0; i < n; i++){
            System.out.println("Enter number " + (i + 1));
            numArray[i] = Integer.parseInt(br.readLine());
        }

        printArray(numArray);

        //loop through the array and use an accumulator to keep track of the sum
        for(int i = 0; i < n; i++){
            sum+= numArray[i];
        }

        System.out.println();
        System.out.println("The sum is " + sum);
        System.out.println();

        System.out.println("The sorted array is:");

        for(int i = numArray.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(numArray[j] > numArray[j+1]){
                    int temp = numArray[j];
                    numArray[j] = numArray[j+1];
                    numArray[j+1] = temp;
                }
            }
        }

        printArray(numArray);

    }

    //the method printArray is used to print the contents of an array with size n in a formatted manner @param: arr --> the given array
    public static void printArray(int[] arr){
        System.out.print("[");
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            System.out.print(arr[i] + ", ");
        }

        System.out.print(arr[n-1] + "]");
        System.out.println();
    }
}