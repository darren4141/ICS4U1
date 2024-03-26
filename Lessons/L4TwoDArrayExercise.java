package Lessons;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class L4TwoDArrayExercise {
    static File file = new java.io.File("TwoDArray.txt");
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException{
        Scanner fileScanner = new Scanner(file);
        L4TwoDArrayExercise TwoDArray = new L4TwoDArrayExercise();
        int row = fileScanner.nextInt();
        int col = fileScanner.nextInt();
        int[][] fileNums = TwoDArray.readTwoDArray(row, col, fileScanner);

        TwoDArray.showSum(fileNums);
    }
    
    public int[][] readTwoDArray(int rows, int cols, Scanner fileScanner){
        int[][] arr = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                arr[i][j] = fileScanner.nextInt();
            }
            fileScanner.nextLine();
        }
        return arr;
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
        int[] rowSum = new int[arr.length];
        int[] colSum = new int[arr[0].length];

        for(int i = 0; i < arr.length; i++){
            rowSum[i] = 0;
            for(int j = 0; j < arr[i].length; j++){
                rowSum[i]+=arr[i][j];
            }
        }

        for(int i = 0; i < arr[0].length; i++){
            colSum[i] = 0;
            for(int j = 0; j < arr.length; j++){
                colSum[i]+=arr[j][i];
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print("|[" + arr[i][0]);
            for(int j = 1; j < arr[i].length; j++){
                System.out.print(", " + arr[i][j]);
            }
            System.out.println("]| " + rowSum[i]);
        }

        System.out.print("--");
        for(int i = 0; i < arr[0].length; i++){
            System.out.print("---");
        }

        System.out.println();
        System.out.print("|[" + colSum[0]);
        for(int i = 1; i < arr[0].length; i++){
            System.out.print(", " + colSum[i]);
        }
        System.out.println("]|");
    }
    
}
