/*
 * Why read from files?
 * - Speed -> not limited by speed of user input, get data from sources other than the keyboard
 * - Less errors
 * - Easier to read, individual cases
 * - Changing info is easy
 * - Large data can be entered quickly
 * - At testing stage, data can be carefully chosen to test data
 * 
 * 
 * Why write to files?
 * - Data can be saved for future use
 * - Print hard copy results and distribute it
 * - Manipulate the data
 * - Analyze the data
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class L7FileWriting {

    public static void main(String[] args) throws FileNotFoundException{
        //steps to output to a file:

        PrintWriter output = new PrintWriter("darrenliu.txt");
        Scanner input = new Scanner(System.in);
        File file = new File("darrenliu.txt");
        Scanner fileScanner = new Scanner(file);

        output.println("hello");
        output.println("world!");

        System.out.println("Please enter your name:" );

        String name = input.nextLine();

        output.println(name);
        output.close();

        while(fileScanner.hasNextLine()){
            System.out.println(fileScanner.nextLine());
        }

    }
    
}
