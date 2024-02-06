import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L1ArrayExercise{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{

        L1ArrayExercise ae = new L1ArrayExercise();

        System.out.println("Welcome to the array builder program");
        int [] numArray = ae.buildArray();

    }

    //the method printArray is used to print the contents of an array with size n in a formatted manner @param: arr --> the given array
    public void printArray(int[] arr){
        System.out.print("[");
        int n = arr.length;
        for(int i = 0; i < n-1; i++){
            System.out.print(arr[i] + ", ");
        }

        System.out.print(arr[n-1] + "]");
        System.out.println();
    }

    public void printArrayRev(int [] arr){
        System.out.print("[");
        int n = arr.length;
        for(int i = n-1; i > 0; i--){
            System.out.print(arr[i] + ", ");
        }

        System.out.print(arr[0] + "]");
        System.out.println();
    }

    public double average(int [] arr){
        return (double)(sumArray(arr) / arr.length);
    }

    public int maxValue(int [] arr){
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public int minValue(int [] arr){
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public int[] search(int [] arr, int num){
        int frequency = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num) frequency++;
        }

        int [] positions = new int[frequency];
        int count = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                positions[count] = i;
                count++;
            }
        }
        return positions;
    }

    public void sortArray(int[]arr){
        for(int i = arr.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public int sumArray(int[]arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }

    public int[] buildArray() throws IOException{
        System.out.println("What is the size of your array?");
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        //loop through the size of the array and fill it with user input
        for(int i = 0; i < n; i++){
            System.out.println("Enter number " + (i + 1));
            arr[i] = Integer.parseInt(br.readLine());
        }

        return arr;

    }

    public void countPos(int [] arr){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0 ){
                count++;
            }
        }
    }




}