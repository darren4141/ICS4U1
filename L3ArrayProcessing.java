import java.io.*;
import java.util.Random;

public class L3ArrayProcessing{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Random rand = new Random();
    static L1ArrayExercise arrayFunction = new L1ArrayExercise();

    public static void main(String[]args) throws IOException{
        L3ArrayProcessing arrayProcessing = new L3ArrayProcessing();

        final int SIZE = 6;
        final int RANDOMSIZE = 10;
        final int RANDOMMAX = 100;

        arrayProcessing.randomNoDuplicates(RANDOMSIZE, RANDOMMAX);
        arrayProcessing.noDuplicates(SIZE);
    }

    /*
     * the method noDuplicates is used to fill an array with integer values while not allowing duplicates, it prints the values
     * @param: int size --> size of the array
     */
    public void noDuplicates(int size) throws IOException{
        int[] nums = new int[size];
        boolean repeat = false;
        System.out.println("Please enter " + size + " unique numbers: ");

        for(int i = 0; i < size; i++){

            if(repeat){
                System.out.println("You already entered this number! Please enter a new number");
                repeat = false;
            }

            System.out.println("Enter number " + (i+1));
            int num = Integer.parseInt(br.readLine());

            for(int j = 0; j < i; j++){
                if(nums[j] == num){
                    repeat = true;
                    i--;
                }
            }

            if(!repeat){
                nums[i] = num;
            }

        }

        arrayFunction.printArray(nums);
    }

    /*
     * the method randomNoDuplicates fills an array with random values while preventing duplicate values
     * @param:
     * int size --> the size of the array
     * int max --> the maximum value of the random numbers
     */
    public void randomNoDuplicates(int size, int max){

        if(size > max){
            System.out.println("Error: the array size is too large for the specified maximum");
            return;
        }

        int[] randNums = new int[size];
        boolean repeat = false;

        for(int i = 0; i < size; i++){
            int num = rand.nextInt(max);

            for(int j = 0; j < i; j++){
                if(randNums[j] == num){
                    repeat = true;
                    i--;
                }
            }

            if(repeat){
                repeat = false;
                i--;
            }else if(!repeat){
                randNums[i] = num;
            }
        }

        arrayFunction.printArray(randNums);

    }

}