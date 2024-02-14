//Demonstration of Selection, Insertion, Merge, Quick, and Heap sorting algorithms

import java.io.*;

public class SortingAlgorithms {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static L1ArrayExercise arrayFunction = new L1ArrayExercise();
    static SortingAlgorithms sort = new SortingAlgorithms();

    public static void main(String[] args)throws IOException{
        int[] nums = arrayFunction.buildArray();


    }

    /*
     * Method that utilizes selection sort --> searches for the min value, puts it at the start, repeat
     * @param: int [] arr --> the array to be sorted
     */
    public void SelectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = arr[i];
            int minIndex = i;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < min){
                    min = arr[j];
                    minIndex = j;
                }
            }
            if(i != minIndex){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
                arrayFunction.printArray(arr);
            }

        }
        arrayFunction.printArray(arr);

    }

    /*
     * Method that utilizes insertion sort --> a number is compared with its predecessors and "inserted into the correct location"
     * @param: int[] arr --> the array to be sorted
     */
    public void InsertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i;
            while(j != 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
                arrayFunction.printArray(arr);
            }
        }
    }

}
