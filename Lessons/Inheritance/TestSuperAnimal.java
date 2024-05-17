//====================================================================================================================================================================================================================================================================
//
//"OOP activity 2" Program
//Darren Liu
//May 17, 2024
//Java 8
//
//====================================================================================================================================================================================================================================================================
//	  
//Problem definition:	Demonstrate the new and old features of the SuperAnimal class by creating two SuperAnimal objects
//
//	====================================================================================================================================================================================================================================================================

package Lessons.Inheritance;

public class TestSuperAnimal {
    
    public static void main(String[]args){

        //declare two super animals
        SuperAnimal mySuperAnimal = new SuperAnimal("Larry", "bird", true, true);
        SuperAnimal mySuperAnimal2 = new SuperAnimal("Bob", "cow", false, false);

        //demonstrate fly and teleport prompt
        System.out.println(mySuperAnimal.fly());
        System.out.println(mySuperAnimal.teleport("school"));

        System.out.println(mySuperAnimal2.fly());
        System.out.println(mySuperAnimal2.teleport("school"));

        //demonstrate size attribute
        mySuperAnimal.setSize(100);
        System.out.println(mySuperAnimal.getSize());

        //demonstrate offspring attribute
        mySuperAnimal.setOffspring(2);
        System.out.println(mySuperAnimal.getOffspring());
        mySuperAnimal.giveBirth(5);
        System.out.println(mySuperAnimal.getOffspring());

        //demonstrate laser eyes attribute
        mySuperAnimal.setLaserEyes(true);
        mySuperAnimal.setLaserEyesColour("green");

        System.out.println(mySuperAnimal.shootLaserEyes());

        mySuperAnimal2.setLaserEyes(false);

        System.out.println(mySuperAnimal2.shootLaserEyes());
    }
}
