//====================================================================================================================================================================================================================================================================
//
//"OOP activity 2" Program
//Darren Liu
//May 14, 2024
//Java 8
//
//====================================================================================================================================================================================================================================================================
//	  
//Problem definition:	Test out the animal class by creating two animal objects
//
//	====================================================================================================================================================================================================================================================================

package Lessons.Inheritance;

public class TestAnimal {
    //declare two animals with different constructors
    static Animal myAnimal = new Animal("Jeff", "shark", 200);
    static Animal myAnimal2 = new Animal();

    public static void main (String[] args){

        //demonstration of default name
        System.out.println(myAnimal.getName());

        //set a name then print
        myAnimal.setName("tom");
        System.out.println(myAnimal.getName());

        //output offspring, set an offspring value, output again, give birth, output again
        System.out.println(myAnimal.getOffspring());
        myAnimal.setOffspring(2);
        System.out.println(myAnimal.getOffspring());
        myAnimal.giveBirth(3);
        System.out.println(myAnimal.getOffspring());

        //demonstrate the action methods
        myAnimal.setAction("running");

        myAnimal2.eat();

        //demonstrate the colour attribute
        myAnimal2.setColour("red");

        System.out.println(myAnimal2.getColour());

        System.out.println(myAnimal.getColour());

    }
}
