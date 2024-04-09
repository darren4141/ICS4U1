package Lessons;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class L10SearchingExerciseQ2 {
    static final int FILELINES = 109582;
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[]args) throws IOException{
        String[] words = populateWordArray();

        String guess = sc.next();

        long startTime1 = Calendar.getInstance().getTimeInMillis();
        System.out.println(binarySearchRecursive(words, guess, 0, FILELINES));
        System.out.println("Time taken to run: " + (Calendar.getInstance().getTimeInMillis() - startTime1));

        long startTime2 = Calendar.getInstance().getTimeInMillis();
        System.out.println(binarySearchIterative(words, guess, 0, FILELINES));
        System.out.println("Time taken to run: " + (Calendar.getInstance().getTimeInMillis() - startTime2));

    }

    public static String[] populateWordArray() throws IOException{
        File wordList = new File("Lessons/wordlist.txt");
        Scanner fileReader = new Scanner(wordList);
        String[] words = new String[FILELINES];

        for(int i = 0; i < FILELINES && fileReader.hasNext(); i++){
            words[i] = fileReader.next();
        }

        fileReader.close();
        return words;
    }

    public static boolean binarySearchIterative(String[] words, String word, int min, int max){
        for(int i = 0; i < max; i++){
            if(words[i].equals(word)){
                return true;
            }
        }
        return false;
    }

    public static boolean binarySearchRecursive(String[] words, String word, int min, int max){
        int middle = min + ((max-min)/2);

        if(min > max){
            return false;
        }

        if(words[middle].equals(word)){
            return true;
        }else if(words[middle].compareTo(word) > 0){
            return binarySearchRecursive(words, word, min, middle - 1);
        }else{
            return binarySearchRecursive(words, word, middle + 1, max);
        }
    }

}
