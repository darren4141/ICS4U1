package Lessons;
public class Animal {
    private double size = 0;
    private String name;
    private String species;
    private String colour;
    private int offspring = 0;

    public Animal(String name, String species){
        this.name = name;
        this.species = species;
    }

    public Animal(String name, String species, double size){
        this.name = name;
        this.species = species;
        this.size = size;
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

}
