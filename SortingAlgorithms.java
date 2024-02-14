import java.io.*;

public class SortingAlgorithms {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static L1ArrayExercise arrayFunction = new L1ArrayExercise();
    static SortingAlgorithms sort = new SortingAlgorithms();

    public static void main(String[] args)throws IOException{
        int[] nums = arrayFunction.buildArray();

        sort.SelectionSort(nums);

    }

    /*
     * Method that utilizes selection sort --> searches for the min value, puts it at the start, repeat
     * @param: int [] arr --> the array to be sorted
     */
    public void SelectionSort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            int min = arr[i];
            int minIndex = i;
            for(int j = i; j < arr.length-1; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(i != minIndex){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }

        }

        arrayFunction.printArray(arr);

    }

}
