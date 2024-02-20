import java.util.Scanner;

public class L4TwoDArrayExercise {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        L4TwoDArrayExercise TwoDArray = new L4TwoDArrayExercise();
        int[][] nums = TwoDArray.fillTwoDArray(4, 3);

        TwoDArray.print2dArray(nums);
        TwoDArray.transpose2DArray(nums);
    }
    
    /*
    * Method that prints out a 2D array in a formatted manner
    * @param: int[][] arr --> the array to be printed
    */
    public void print2dArray(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print("|[" + arr[i][0]);
            for(int j = 1; j < arr[i].length; j++){
                System.out.print(", " + arr[i][j]);
            }
            System.out.println("]|");
        }
    }

    public void transpose2DArray(int[][] arr){
        for(int i = 0; i < arr[i].length; i++){
            System.out.print("|[" + arr[0][i]);
            for(int j = 1; j < arr.length; j++){
                System.out.print(", " + arr[j][i]);
            }
            System.out.println("]|");
        }
    }

    /*
     * Method builds a 2d array by inputting rows
     * @return: int[][] nums --> the built array
     */
    public int[][] fillTwoDArray(int rows, int cols){
        int[][] arr = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            System.out.println("Enter the contents of row " + (i + 1) + ", seperated with spaces");
            for(int j = 0; j < cols; j++){
                arr[i][j] = Integer.parseInt(sc.next());
            }
        }
        return arr;
    }

    public void showSum(int[][] arr){
        
    }
    
}
