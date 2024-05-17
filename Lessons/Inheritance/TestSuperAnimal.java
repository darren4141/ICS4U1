//====================================================================================================================================================================================================================================================================
//
//"OOP activity 2" Program
//Darren Liu
//May 14, 2024
//Java 8
//
//====================================================================================================================================================================================================================================================================
//	  
//Problem definition:	Create an animal class with 5 behaviors and 5 attributes of animals
//
//	====================================================================================================================================================================================================================================================================

package Lessons.Inheritance;

public class TestSuperAnimal {
    
    public static void main(String[]args){
        SuperAnimal mySuperAnimal = new SuperAnimal("Larry", "bird", true, true);
        SuperAnimal mySuperAnimal2 = new SuperAnimal("Bob", "cow", false, false);

        System.out.println(mySuperAnimal.fly());
        System.out.println(mySuperAnimal.teleport("school"));

        System.out.println(mySuperAnimal2.fly());
        System.out.println(mySuperAnimal2.teleport("school"));

        mySuperAnimal.setSize(100);
        System.out.println(mySuperAnimal.getSize());

        mySuperAnimal.setOffspring(2);
        System.out.println(mySuperAnimal.getOffspring());
        mySuperAnimal.giveBirth(5);
        System.out.println(mySuperAnimal.getOffspring());

        mySuperAnimal.setLaserEyes(true);
        mySuperAnimal.setLaserEyesColour("green");

        System.out.println(mySuperAnimal.shootLaserEyes());

        mySuperAnimal2.setLaserEyes(false);

        System.out.println(mySuperAnimal2.shootLaserEyes());
    }
}
