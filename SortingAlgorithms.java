//Demonstration of Selection, Insertion, Merge, Quick, and Heap sorting algorithms

import java.io.*;

public class SortingAlgorithms {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static L1ArrayExercise arrayFunction = new L1ArrayExercise();
    static SortingAlgorithms sort = new SortingAlgorithms();
    static DarrenUtils util = new DarrenUtils();

    public static void main(String[] args)throws IOException{
        int[] nums = arrayFunction.buildArray();
        String[] menu = {"Selection Sort", "Insertion sort", "Quick Sort", "Merge Sort", "Heap Sort"};

        util.printMenu(menu);
        int choice = Integer.parseInt(br.readLine());

        switch(choice){
            case 1:
                System.out.println("Unsorted array:");
                arrayFunction.printArray(nums);
                sort.selectionSort(nums);
                break;
            case 2:
                System.out.println("Unsorted array:");
                arrayFunction.printArray(nums);
                sort.insertionSort(nums);
                break;
            case 3:
                System.out.println("Unsorted array:");
                arrayFunction.printArray(nums);
                sort.quickSort(nums, 0, nums.length-1);
                break;
            case 4:
                System.out.println("Unsorted array:");
                arrayFunction.printArray(nums);
                sort.mergeSort(nums, 0, nums.length-1);
                break;
            case 5:
                System.out.println("Unsorted array:");
                arrayFunction.printArray(nums);
                sort.heapSort(nums);   
                break;    
            default:
                System.out.println("Please enter a valid value");
                break;
        }
    }

    /*
     * Method that swaps two elements at indexs i and j in an array
     * @param: 
     * int[] arr --> the given array
     * int i --> the index of the first element
     * int j --> the index of the second element
     */
    public void swap(int[]arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * Method that utilizes selection sort --> searches for the min value, puts it at the start, repeat
     * @param: int [] arr --> the array to be sorted
     */
    public void selectionSort(int[] arr){
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
                sort.swap(arr, i, minIndex);
                arrayFunction.printArray(arr);
            }

        }
        arrayFunction.printArray(arr);

    }

    /*
     * Method that utilizes insertion sort --> a number is compared with its predecessors and "inserted into the correct location"
     * @param: int[] arr --> the array to be sorted
     */
    public void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i;
            while(j != 0 && arr[j] < arr[j-1]){
                sort.swap(arr, j, j-1);
                j--;
                arrayFunction.printArray(arr);
            }
        }
    }

    /*
     * Method that utilizes quick sort --> choose a pivot, put all smaller elements to left of pivot, and repeats
     * @param:
     * int[] arr --> the array to be sorted
     * int low --> the lowest index included in the sort
     * int high --> the highest index included in the sort
     */
    public void quickSort(int[] arr, int low, int high){
        if(high > low){
            int pivot = arr[high];
            int lowPosition = low - 1;

            for(int i = low; i < high; i++){
                if(arr[i] < pivot){
                    lowPosition++;
                    sort.swap(arr, i, lowPosition);
                    arrayFunction.printArray(arr);
                }
            }

            int pivotIndex = lowPosition + 1;
            sort.swap(arr, high, lowPosition+1);
            arrayFunction.printArray(arr);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /*
     * Method that utilizes merge sort algorithm --> seperate array into subarrays, merge them back together sorted
     * @param:
     * int[] arr --> the array to be sorted
     * int low --> the lowest element in the array
     * int high --> the highest element in the array
     */
    public void mergeSort(int[] arr, int low, int high){
        if(high > low){
            int middle = (high + low) /2;
            mergeSort(arr, low, middle);
            mergeSort(arr, middle + 1, high);

            int sizeLeft = middle - low + 1;
            int sizeRight = high - middle;

            int[] left = new int[sizeLeft];
            int[] right = new int[sizeRight];

            for(int i = 0; i < sizeLeft; i++)
                left[i] = arr[low + i];
            for(int i = 0; i < sizeRight; i++)
                right[i] = arr[middle + 1 + i];

            int i = 0, j = 0;

            int k = low;

            while(i < sizeLeft && j < sizeRight){
                if(left[i] <= right[j]){
                    arr[k] = left[i];
                    i++;
                }else{
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }

            while(i < sizeLeft){
                arr[k] = left[i];
                k++;
                i++;
            }

            while(j < sizeRight){
                arr[k] = right[j];
                k++;
                j++;
            }

            arrayFunction.printArray(left);
            arrayFunction.printArray(right);
            arrayFunction.printArray(arr);

        }
    }

    public void heapSort(int[] arr){
        for(int i = arr.length / 2 - 1; i >= 0; i--){
            heapify(arr, arr.length, i);
        }

        for(int i = arr.length - 1; i > 0; i--){
            sort.swap(arr, 0, i);
            heapify(arr, i, 0);
        }

        arrayFunction.printArray(arr);

    }

    public void heapify(int[] arr, int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }

        if(left < n && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
            sort.swap(arr, i, largest);
            heapify(arr, n, largest);
        }

    }

}
