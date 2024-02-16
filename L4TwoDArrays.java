import java.io.*;

public class L4TwoDArrays {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public int[][] build2dArray() throws IOException{
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
}
