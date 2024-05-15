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

package Lessons;
public class Animal {
    private double size;
    private String name;
    private String species;
    private String colour;
    private int offspring;

    public Animal(){
        offspring = 0;
        size = 0;
        name = "default";
        species = "default";
        colour = "unknown";
    }

    public Animal(String name, String species){
        this.name = name;
        this.species = species;
        size = 0;
        offspring = 0;
        colour = "unknown";
    }


    public Animal(String name, String species, double size){
        this.name = name;
        this.species = species;
        this.size = size;
        offspring = 0;
        colour = "unknown";
    }

    public Animal(String name, String species, double size, String colour){
        this.name = name;
        this.species = species;
        this.size = size;
        offspring = 0;
        this.colour = colour;
    }

    public void setOffspring(int offspring){
        this.offspring = offspring;
    }

    public int getOffspring(){
        return offspring;
    }

    public void giveBirth(int kids){
        offspring += kids;
    }

    public void setColour(String colour){
        this.colour = colour;
    }

    public String getColour(){
        return colour;
    }

    public void setSize(double size){
        this.size = size;
    }

    public double getSize(){
        return size;
    }

    public void grow(double amount){
        size += amount;
    }

    public void setSpecies(String species){
        this.species = species;
    }

    public String getSpecies(){
        return species;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAction(String action){
        System.out.println(name + " the " + species + " is " + action);
    }

    public void run(){
        System.out.println(name + " the " + species + " is running!");
    }

    public void eat(){
        System.out.println(name + " the " + species + " is eating!");
    }

    public void sleep(){
        System.out.println(name + " the " + species + " is sleeping!");
    }
}
