import java.io.*;

public class L4TwoDArrays {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException{
        L4TwoDArrays TwoDArray = new L4TwoDArrays();
        System.out.println("welcome!");

        int[][] numsColRow = TwoDArray.build2dArrayColRow();
        TwoDArray.print2dArray(numsColRow);

        int[][] numsRowCol = TwoDArray.build2dArrayRowCol();
        TwoDArray.print2dArray(numsRowCol);
    }

    /*
     * Method builds a 2d array by inputting rows first
     * @return: int[][] nums --> the built array
     */
    public int[][] build2dArrayColRow() throws IOException{
        System.out.println("How many columns does your array have?");
        int col = Integer.parseInt(br.readLine());
        
        System.out.println("How many rows does your array have?");
        int row = Integer.parseInt(br.readLine());

        int[][] nums = new int[col][row];

        for(int i = 0; i < col; i++){
            for(int j = 0; j < row; j++){
                System.out.println("Enter value located at column: " + i + " and row: " + j);
                nums[i][j] = Integer.parseInt(br.readLine());
            }
        }

        return nums;
    }

    /*
     * Method builds a 2d array by inputting columns first
     * @return: int[][] nums --> the built array
     */
    public int[][] build2dArrayRowCol()throws IOException{
        System.out.println("How many rows does your array have?");
        int row = Integer.parseInt(br.readLine());
        
        System.out.println("How many columns does your array have?");
        int col = Integer.parseInt(br.readLine());

        int[][] nums = new int[col][row];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.println("Enter value located at column: " + i + " and row: " + j);
                nums[j][i] = Integer.parseInt(br.readLine());
            }
        }

        return nums;
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
}
