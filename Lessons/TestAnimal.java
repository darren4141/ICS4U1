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

package Lessons;

public class TestAnimal {
    static Animal myAnimal = new Animal("Jeff", "shark", 200);
    static Animal myAnimal2 = new Animal();

    public static void main (String[] args){
        System.out.println(myAnimal.getName());

        myAnimal.setName("tom");
        System.out.println(myAnimal.getName());

        System.out.println(myAnimal.getOffspring());
        myAnimal.setOffspring(2);
        System.out.println(myAnimal.getOffspring());
        myAnimal.giveBirth(3);
        System.out.println(myAnimal.getOffspring());

        myAnimal.setAction("running");

        myAnimal2.eat();
        myAnimal2.setColour("red");

        System.out.println(myAnimal2.getColour());

        System.out.println(myAnimal.getColour());

    }
}
