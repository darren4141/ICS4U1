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
public class Animal {
    private double size;
    private String name;
    private String species;
    private String colour;
    private int offspring;

    /*
     * This method is the constructor method for the Animal class
     * @param: none
     * @return: void
     */
    public Animal(){
        offspring = 0;
        size = 0;
        name = "default";
        species = "default";
        colour = "unknown";
    }

    /*
     * This method is the constructor method for the Animal class
     * @param:
     *  String name: the name of the animal
     *  String species: the species of the animal
     * @return: void
     */
    public Animal(String name, String species){
        this.name = name;
        this.species = species;
        size = 0;
        offspring = 0;
        colour = "unknown";
    }

    /*
     * This method is the constructor method for the Animal class
     * @param:
     *  String name: the name of the animal
     *  String species: the species of the animal
     *  double size: the size of the animal in an arbitrary unit
     * @return: void
     */
    public Animal(String name, String species, double size){
        this.name = name;
        this.species = species;
        this.size = size;
        offspring = 0;
        colour = "unknown";
    }

    /*
     * This method is the constructor method for the Animal class
     * @param:
     *  String name: the name of the animal
     *  String species: the species of the animal
     *  double size: the size of the animal in an arbitrary unit
     *  String colour: the colour of the animal
     * @return: void
     */
    public Animal(String name, String species, double size, String colour){
        this.name = name;
        this.species = species;
        this.size = size;
        offspring = 0;
        this.colour = colour;
    }

    /*
     * This is a setter method for the int offspring variable
     * @param:
     *  int offspring: the number of offspring to set
     * @return: void
     */
    public void setOffspring(int offspring){
        this.offspring = offspring;
    }

    /*
     * This is a getter method for the int offspring variable
     * @param: none
     * @return: the int offspring attribute of the animal class
     */
    public int getOffspring(){
        return offspring;
    }

    /*
     * This is a method that increments the int offspring variable by an int kids parameter
     * @param:
     *  int kids: the number of kids to increment by
     * @return: void
     */
    public void giveBirth(int kids){
        offspring += kids;
    }

    /*
     * This is a setter method for the String colour variable
     * @param:
     * String colour: the colour of the animal to set
     * @return: void
     */
    public void setColour(String colour){
        this.colour = colour;
    }

    /*
     * This is a getter method for the String colour variable
     * @param: none
     * @return: the String colour attribute of the animal class
     */
    public String getColour(){
        return colour;
    }

    /*
     * This is a setter method for the double size variable
     * @param:
     *  double size: the size of the animal to set in an arbitrary unit
     * @return: void
     */
    public void setSize(double size){
        this.size = size;
    }

    /*
     * This is a getter method for the double size variable
     * @param: none
     * @return: the double size attribute of the animal class
     */
    public double getSize(){
        return size;
    }

    /*
     * This is a method that increments the double size variable by a double amount parameter
     * @param:
     *  double amount: the amount to increment by in an arbitrary unit
     * @return: void
     */
    public void grow(double amount){
        size += amount;
    }

    /*
     * This is a setter method for the String species variable
     * @param:
     * String species: the species of the animal to set
     * @return: void
     */
    public void setSpecies(String species){
        this.species = species;
    }

    /*
     * This is a getter method for the String species variable
     * @param: none
     * @return: the String species attribute of the animal class
     */
    public String getSpecies(){
        return species;
    }

    /*
     * This is a setter method for the String name variable
     * @param:
     * String name: the name of the animal to set
     * @return: void
     */
    public void setName(String name){
        this.name = name;
    }

    /*
     * This is a getter method for the String name variable
     * @param: none
     * @return: the String name attribute of the animal class
     */
    public String getName(){
        return name;
    }

    /*
     * The following method outputs a message based on a String aciton parameter
     * @param:
     *  String action: the action to be included in the message
     * @return: void
     */
    public void setAction(String action){
        System.out.println(name + " the " + species + " is " + action);
    }

    /*
     * The following method outputs a running message for the animal class
     * @param: none
     * @return: void
     */
    public void run(){
        System.out.println(name + " the " + species + " is running!");
    }

    /*
     * The following method outputs a eating message for the animal class
     * @param: none
     * @return: void
     */
    public void eat(){
        System.out.println(name + " the " + species + " is eating!");
    }

    /*
     * The following method outputs a sleeping message for the animal class
     * @param: none
     * @return: void
     */
    public void sleep(){
        System.out.println(name + " the " + species + " is sleeping!");
    }
}
