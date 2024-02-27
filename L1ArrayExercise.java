import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class L1ArrayExercise {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        L1ArrayExercise arrayFunction = new L1ArrayExercise();
        boolean done = false;

        System.out.println("Welcome to the array builder program");
        int[] numArray = arrayFunction.buildArray();

        while (!done) {
            System.out.println("What would you like to do?\n1. View array\n2. View array in reverse\n3. Find the average\n4. Find the max value\n5. Find the min value\n6. Search for a specific number\n7. Sort array\n8. Find the sum of the elements\n9. Find the amount of positive numbers\n10. Exit");
            int choice = Integer.parseInt(br.readLine());
            switch (choice) {
                case 1:
                    System.out.println("Here is the array");
                    arrayFunction.printArray(numArray);
                    break;
                case 2:
                    System.out.println("Here is the array in reverse");
                    arrayFunction.printArrayRev(numArray);
                    break;
                case 3:
                    System.out.println("The average of the array is: ");
                    System.out.println(arrayFunction.average(numArray));
                    break;
                case 4:
                    System.out.println("The max value of the array is: ");
                    System.out.println(arrayFunction.maxValue(numArray));
                    break;
                case 5:                    
                    System.out.println("The min value of the array is: ");
                    System.out.println(arrayFunction.minValue(numArray));
                    break;
                case 6:
                    System.out.println("What number would you like to search for?");
                    int num = Integer.parseInt(br.readLine());
                    System.out.println(num + " appears at positions: ");
                    arrayFunction.printArray(arrayFunction.search(numArray, num));
                    break;
                case 7:
                    System.out.println("Here is the sorted array: ");
                    arrayFunction.sortArrayImproved(numArray);
                    arrayFunction.printArray(numArray);
                    break;
                case 8:
                    System.out.println("The sum of the elements in the array is: ");
                    System.out.println(arrayFunction.sumArray(numArray));
                    break;
                case 9:
                    System.out.println("The amount of positive elements in the array is: ");
                    System.out.println(arrayFunction.countPos(numArray));
                    break;
                case 10:
                    System.out.println("bye");
                    done = true;
                    break;
                default:
                    System.out.println("Please enter a valid value");

            }

        }

    }

    /*
     * the method printArray is used to print the contents of an array with size n
     * in a formatted manner
     * 
     * @param: int[] arr --> the given array
     */
    public void printArray(int[] arr) {
        System.out.print("[");
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + ", ");
        }

        System.out.print(arr[n - 1] + "]");
        System.out.println();
    }

    /*
     * the method printArrayRev is used to print the contents of an array with size
     * n in reverse and in a formatted manner
     * 
     * @param: int[] arr --> the given array
     */
    public void printArrayRev(int[] arr) {
        System.out.print("[");
        int n = arr.length;
        for (int i = n - 1; i > 0; i--) {
            System.out.print(arr[i] + ", ");
        }

        System.out.print(arr[0] + "]");
        System.out.println();
    }

    /*
     * the method average is used to find the average of an array of any size
     * 
     * @param: int[] arr --> the given array
     * 
     * @return: double avg --> the average
     */
    public double average(int[] arr) {
        double avg = ((double)sumArray(arr) / (double)arr.length);
        return avg;
    }

    /*
     * the method maxValue is used to find the largest value in an array
     * 
     * @param: int[] arr --> the given array
     * 
     * @return: int max --> the largest value
     */
    public int maxValue(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    /*
     * the method minValue is used to find the smallest value in an array
     * 
     * @param: int[] arr --> the given array
     * 
     * @return: int minValue --> the smallest value
     */
    public int minValue(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /*
     * the method search is used to find the positions of a certain number in an
     * array
     * 
     * @param:
     * int[] arr --> the given array
     * int num --> the number to find
     * 
     * @return: int[] positions --> the positions of the number to find
     */
    public int[] search(int[] arr, int num) {
        int frequency = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                frequency++;
        }

        int[] positions = new int[frequency];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                positions[count] = i;
                count++;
            }
        }
        return positions;
    }

    /*
     * the method sortArray is used to sort an array using the bubble sort method
     * 
     * @param: int[] arr --> the given array
     */
    public void sortArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /*
     * the method sortArrayImproved is used to sort an array using the improved
     * bubble sort method (ends the bubble sort if there are no more swaps to be
     * done)
     * 
     * @param: int[] arr --> the given array
     */
    public void sortArrayImproved(int[] arr) {
        boolean swapped = true;

        for (int i = arr.length - 1; i > 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /*
     * the method sumArray is used to find the sum of the array
     * 
     * @param: int[] arr --> the given array
     * 
     * @return: int sum --> the sum of the elements in the array
     */
    public int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /*
     * the method buildArray is used to fill an empty array with int values
     * 
     * @return: int[] arr --> an array with values entered by the user
     */
    public int[] buildArray() throws IOException {
        System.out.println("What is the size of your array?");
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // loop through the size of the array and fill it with user input
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1));
            arr[i] = Integer.parseInt(br.readLine());
        }

        return arr;

    }

    /*
     * the method countPos is used to count the number of positive elements in an
     * array
     * 
     * @param: int[] arr --> the given array
     * 
     * @return: int count --> the number of positive elements
     */
    public int countPos(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                count++;
            }
        }
        return count;
    }

        /*
     * Method that utilizes insertion sort --> a number is compared with its predecessors and "inserted into the correct location"
     * @param: int[] arr --> the array to be sorted
     */
    public void insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i;
            while(j != 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }

}