import java.io.IOException;
import java.util.Scanner;

public class L10Searching {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException{
        int[] arr = new int[10];
        fillArray(arr);

        sequentialSearch(arr, 7);
    }

    public static void fillArray(int[] nums) throws IOException{
        for(int i = 0; i < nums.length; i++){
            nums[i] = sc.nextInt();
        }
    }

    public static int sequentialSearch(int[] nums, int target){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }

        return -1;
    }

}
