/*
 * ArrayList exercises
 * Darren Liu
 * February 26th, 2024
 * ICS4U1, Mr Anandarajan
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class L5ArrayListExercise {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException{
        L5ArrayListExercise arrayListOperation = new L5ArrayListExercise();

        ArrayList<Integer> listNums = new ArrayList<Integer>();
        System.out.println("Welcome to the ArrayList program!");

        System.out.println("How large would you like the array list to be?");
        int size = sc.nextInt();
        arrayListOperation.enterFromKeyboard(listNums, size);

        boolean repeat = true;

        while(repeat){
            System.out.println("What would you like to do?");
            System.out.println("1. return the number of positive whole numbers\n2. display array\n3. display array in reverse\n4. find sum of array\n5. find average of array\n6. find max of array\n7. find min of array\n8. search for the indicies of a certain element\n9. sort the array\n10. exit");
            
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println(arrayListOperation.countWhole(listNums));
                    break;
                case 2:
                    arrayListOperation.display(listNums);
                    break;
                case 3:
                    arrayListOperation.displayReverse(listNums);
                    break;
                case 4:
                    System.out.println(arrayListOperation.sum(listNums));
                    break;
                case 5:
                    System.out.println(arrayListOperation.average(listNums));
                    break;
                case 6:
                    System.out.println(arrayListOperation.findMax(listNums));
                    break;
                case 7:
                    System.out.println(arrayListOperation.findMin(listNums));
                    break;
                case 8:
                    System.out.println("What element would you like to search for?");
                    int searchFor = sc.nextInt();
                    arrayListOperation.display(arrayListOperation.search(listNums, searchFor));
                    break;
                case 9:
                    arrayListOperation.improvedBubbleSort(listNums);
                    arrayListOperation.display(listNums);
                    break;
                case 10:
                    System.out.println("Goodbye");
                    repeat = false;
                    break;
                default:
                    System.out.println("Please enter a valid choice!");

            }

        }

    }

    /*
     * Method that fills an ArrayList with user input
     * 
     * @param:
     * ArrayList<Integer> list --> the arraylist to be filled
     * int max --> the number of elements to be added into the arraylist
     */
    public void enterFromKeyboard(ArrayList<Integer> list, int max) throws IOException{
        for(int i = 0; i < max; i++){
            System.out.println("Enter integer " + i + ": ");
            list.add(sc.nextInt());
        }
    }

    /*
     * Method that counts the number of whole positive integers in an arrayList
     * @param: ArrayList<Integer> list --> the given arraylist
     */
    public int countWhole(ArrayList<Integer> list){
        int count = 0;
        for(int i : list){
            if(i > 0){
                count++;
            }
        }
        return count;
    }

    /*
     * Method displays the elements of an arraylist
     * @param: ArrayList<Integer> list --> the given arraylist
     */
    public void display(ArrayList<Integer> list){
        System.out.println(list);
    }

    /*
     * Method displays the elements of an arraylist in reverse
     * @param: ArrayList<Integer> list --> the given arraylist
     */
    public void displayReverse(ArrayList<Integer> list){
        System.out.print("[" + list.get(list.size() - 1));

        for(int i = list.size() - 2; i >= 0; i--){
            System.out.print(", " + list.get(i));
        }

        System.out.println("]");
    }

    /*
     * Method returns the sum of all of the elements in an arraylist
     * @param: ArrayList<Integer> list --> the given arraylist
     * @return: int --> the sum of all of the elements
     */
    public int sum(ArrayList<Integer> list){
        int sum = 0;
        for(int i : list){
            sum += i;
        }
        return sum;
    }

    /*
     * Method returns the average of all of the elements in an arraylist
     * @param: ArrayList<Integer> list --> the given arraylist
     * @return: double --> the average of all of the elements
     */
    public double average(ArrayList<Integer> list){
        double avg = 0;
        for(int i : list){
            avg += i;
        }

        avg = (double) Math.round(avg*10 / list.size())/10;
        return avg;
    }

    /*
     * Method returns the maximum value of all of the elements in an arraylist
     * @param: ArrayList<Integer> list --> the given arraylist
     * @return: int --> the maximum value of all of the elements
     */
    public int findMax(ArrayList<Integer> list){
        int maxIndex = 0;
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) > list.get(maxIndex)){
                maxIndex = i;
            }
        }
        return list.get(maxIndex);
    }

    /*
     * Method returns the minimum value of all of the elements in an arraylist
     * @param: ArrayList<Integer> list --> the given arraylist
     * @return: int --> the minimum value of all of the elements
     */
    public int findMin(ArrayList<Integer> list){
        int minIndex = 0;
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < list.get(minIndex)){
                minIndex = i;
            }
        }
        return list.get(minIndex);
    }

    /*
     * Method searches for the indicies of a certain element in an arraylist
     * @param: 
     * ArrayList<Integer> list --> the given arraylist
     * int num --> the element to search for
     * @return: ArrayList<Integer> --> the positions of the element in the given arraylist
     */
    public ArrayList<Integer> search(ArrayList<Integer> list, int num){
        ArrayList<Integer> positions = new ArrayList<Integer>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) == num){
                positions.add(i);
            }
        }
        return positions;
    }

    /*
     * the method improvedBubbleSort is used to sort an arraylist using the improved
     * bubble sort method (ends the bubble sort if there are no more swaps to be
     * done)
     * 
     * @param: ArrayList<Integer> list --> the given arraylist
     */
    public void improvedBubbleSort(ArrayList<Integer> list){
        boolean swapped = true;
        int i = 0;

        while(swapped) {
            swapped = false;
            i++;
            for (int j = 0; j < list.size() - i; j++) {
                if (list.get(j) > list.get(j+1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }
        }
    }

}
