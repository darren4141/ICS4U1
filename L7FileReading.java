import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class L7FileReading {
    
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("School.txt");
        Scanner input = new Scanner(file);

        while(input.hasNext()){
            String firstName = input.next();
            int avg = input.nextInt();
            System.out.println(firstName + " " + avg);
        }
    }
}
