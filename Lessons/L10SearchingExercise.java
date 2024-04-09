package Lessons;

import java.io.IOException;
import java.util.Scanner;

public class L10SearchingExercise{
    static final int NUMNAMES = 5;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[]args) throws IOException{
        String[] names = new String[NUMNAMES];
        int[] numbers = new int[NUMNAMES];

        System.out.println("Enter " + NUMNAMES + " names and their respective phone numbers!");

        for(int i = 0; i < NUMNAMES; i++){
            System.out.println("What is the name of person #" + (i+1));
            names[i] = sc.next().toLowerCase();
            System.out.println("What is the phone number of person #" + (i+1));
            numbers[i] = sc.nextInt();
        }

        sortNames(names, numbers);

        for(String s : names){
            System.out.println(s + " ");
        }

        System.out.println("Located at index: " + findName(names, "a".toLowerCase(), 0, NUMNAMES));
    }

    public static void sortNames(String[] names, int[] numbers){
        for(int i = 0; i < names.length; i++){
            int minIndex = i;
            for(int j = i+1; j < names.length; j++){
                if(names[minIndex].compareTo(names[j]) > 0){
                    minIndex = j;
                }
            }

            String tempName = names[i];
            int tempMark = numbers[i];

            names[i] = names[minIndex];
            numbers[i] = numbers[minIndex];

            names[minIndex] = tempName;
            numbers[minIndex] = tempMark;
        }
    }

    public static int findName(String[] names, String name, int min, int max){
        int middle = min + ((max-min)/2);

        if(min > max){
            return -1;
        }

        System.out.println("Checking " + names[middle]);

        if(names[middle].equals(name)){
            return middle;
        }else if(names[middle].compareTo(name) > 0){
            System.out.println("LESS");
            return findName(names, name, min, middle-1);
        }else{
            System.out.println("GREATER");
            return findName(names, name, middle + 1, max);
        }
    }
}