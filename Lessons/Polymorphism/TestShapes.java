package Lessons.Polymorphism;

import java.io.IOException;
import java.util.Scanner;

public class TestShapes {
    public static void main(String[]args) throws IOException{
        Shape[] myShapes = new Shape[3];
        Scanner sc = new Scanner(System.in);
        char response;
        for(int i = 0; i < myShapes.length; i++){
            System.out.println("What shape would you like to draw? \n1. c = circle \n2. s = square \n3. t = triangle");
            response = sc.nextLine().charAt(0);

            if(response == 'c'){
                myShapes[i] = new Circle();
            }else if (response == 's'){
                myShapes[i] = new Square();
            }else if(response == 't'){
                myShapes[i] = new Triangle();
            }
        }

        System.out.println("Here are the shapes you entered:");

        for(Shape s : myShapes){
            s.draw();
        }
    }
    
}
