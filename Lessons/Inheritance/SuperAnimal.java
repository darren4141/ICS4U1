//====================================================================================================================================================================================================================================================================
//
//"OOP activity 2" Program
//Darren Liu
//May 17, 2024
//Java 8
//
//====================================================================================================================================================================================================================================================================
//	  
//Problem definition:	Create an SuperAnimal class that extends the Animal class and adds on three new attributes
//
//	====================================================================================================================================================================================================================================================================

package Lessons.Inheritance;

public class SuperAnimal extends Animal{
    private boolean wings;
    private boolean canTeleport;
    private boolean laserEyes;
    private String laserEyesColour;

    /*
     * This method is the constructor method for the SuperAnimal class
     * @param: none
     * @return: void
     */
    public SuperAnimal(){
        super.setName("default");
        super.setSpecies("default");
        super.setSize(0);
        super.setOffspring(0);
        super.setColour("unknown");
    }

    /*
     * This method is the constructor method for the SuperAnimal class
     * @param:
     *  String name: the name of the animal
     *  String species: the species of the animal
     * @return: void
     */
    public SuperAnimal(String name, String species){
        super.setName(name);
        super.setSpecies(species);
        super.setSize(0);
        super.setOffspring(0);
        super.setColour("unknown");
    }

    /*
     * This method is the constructor method for the SuperAnimal class
     * @param:
     *  String name: the name of the animal
     *  String species: the species of the animal
     *  boolean wings: whether or not the animal can fly
     *  boolean canTeleport: whether or not the animal can teleport
     * @return: void
     */
    public SuperAnimal(String name, String species, boolean wings, boolean canTeleport){
        super.setName(name);
        super.setSpecies(species);
        super.setSize(0);
        super.setOffspring(0);
        super.setColour("unknown");
        this.wings = wings;
        this.canTeleport = canTeleport;
    }

    /*
     * This method is the constructor method for the SuperAnimal class
     * @param:
     *  String name: the name of the animal
     *  String species: the species of the animal
     *  double size: the size of the animal in an arbitrary unit
     *  boolean wings: whether or not the animal can fly
     *  boolean canTeleport: whether or not the animal can teleport
     * @return: void
     */
    public SuperAnimal(String name, String species, double size, boolean wings, boolean canTeleport){
        super.setName(name);
        super.setSpecies(species);
        super.setSize(size);
        super.setOffspring(0);
        super.setColour("unknown");
        this.wings = wings;
        this.canTeleport = canTeleport;
    }

    /*
     * This method is the constructor method for the SuperAnimal class
     * @param:
     *  String name: the name of the animal
     *  String species: the species of the animal
     *  double size: the size of the animal in an arbitrary unit
     *  String colour: the colour of the animal
     *  boolean wings: whether or not the animal can fly
     *  boolean canTeleport: whether or not the animal can teleport
     * @return: void
     */
    public SuperAnimal(String name, String species, double size, String colour, boolean wings, boolean canTeleport){
        super.setName(name);
        super.setSpecies(species);
        super.setSize(size);
        super.setOffspring(0);
        super.setColour(colour);
        this.wings = wings;
        this.canTeleport = canTeleport;
    }

    /*
     * This is a setter method for the boolean wings variable
     * @param:
     *  boolean wings: whether or not the animal can fly
     * @return: void
     */
    public void setWings(boolean wings){
        this.wings = wings;
    }

    /*
     * This method outputs a message based on the wings attribute
     * @param: none
     * @return: void
     */
    public String fly(){
        if(wings){
            return super.getName() + " can fly!";
        }else{
            return super.getName() + " cannot fly!";
        }
    }

    /*
     * This is a setter method for the boolean teleport variable
     * @param:
     *  boolean teleport: whether or not the animal can teleport
     * @return: void
     */
    public void setTeleport(boolean canTeleport){
        this.canTeleport = canTeleport;
    }

    /*
     * This method outputs a message based on the canTeleport attribute
     * @param:
     *  String toPlace: the place to teleport to
     * @return: void
     */
    public String teleport(String toPlace){
        if(canTeleport){
            return super.getName() + " teleported to " + toPlace + "!";
        }else{
            return super.getName() + " cannot teleport!";
        }
    }

    /*
     * This is a setter method for the boolean laserEyes variable
     * @param:
     *  boolean laserEyes: whether or not the animal can shoot laser eyes
     * @return: void
     */
    public void setLaserEyes(boolean laserEyes){
        this.laserEyes = laserEyes;
    }

    /*
     * This is a setter method for the String laserEyesColour variable
     * @param:
     *  String laserEyesColour: the colour of the animal's laser eyes
     * @return: void
     */
    public void setLaserEyesColour(String laserEyesColour){
        this.laserEyesColour = laserEyesColour;
    }

    /*
     * This method outputs a message based on the laserEyes and laserEyesColour attributes
     * @param: none
     * @return: void
     */
    public String shootLaserEyes(){
        if(laserEyes){
            return super.getName() + " is shooting " + laserEyesColour + " lasers from its eyes!";
        }else{
            return super.getName() + " cannot shoot lasers...";
        }
    }
}
