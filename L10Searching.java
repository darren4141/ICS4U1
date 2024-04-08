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
    
    public static int binarySearchIterative(String[] names, String target, int low, int high){

        while(high < low){
            int middle = low + ((high-low) / 2);
            if(names[middle].equals(target)){
                return middle;
            }else if(names[middle].compareTo(target) > 0){
                high = middle -1;
            }else{
                low = middle + 1;
            }
        }

        return -1;

    }

    public static int binarySearchRecursive(String[] names, String target, int low, int high){
        if(high < low){
            return -1;
        }

        int middle = low + ((high-low)/2);

        if(names[middle].equals(target)){
            return middle;
        }else if(names[middle].compareTo(target) > 0){
            return binarySearchRecursive(names, target, low, middle - 1);
        }else{
            return binarySearchRecursive(names, target, middle + 1, high);
        }

    }

}
