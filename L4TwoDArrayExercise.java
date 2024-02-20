import java.util.Scanner;

public class L4TwoDArrayExercise {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        
    }

    public int[][] fillTwoDArray(int rows, int cols){
        int[][] nums = new int[cols][rows];

        for(int i = 0; i < rows; i++){
            System.out.println("Enter the contents of row " + (i + 1) + ", seperated with spaces");
            for(int j = 0; j < cols; j++){
                nums[i][j] = Integer.parseInt(sc.next());
            }
        }
        return nums;
    }
    
}
