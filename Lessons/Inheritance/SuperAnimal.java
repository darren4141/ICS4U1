package Lessons.Inheritance;

public class SuperAnimal extends Animal{
    private boolean wings;
    private boolean canTeleport;
    private boolean laserEyes;
    private String laserEyesColour;

    public SuperAnimal(){
        super.setName("default");
        super.setSpecies("default");
        super.setSize(0);
        super.setOffspring(0);
        super.setColour("unknown");
    }

    public SuperAnimal(String name, String species){
        super.setName(name);
        super.setSpecies(species);
        super.setSize(0);
        super.setOffspring(0);
        super.setColour("unknown");
    }

    public SuperAnimal(String name, String species, boolean wings, boolean canTeleport){
        super.setName(name);
        super.setSpecies(species);
        super.setSize(0);
        super.setOffspring(0);
        super.setColour("unknown");
        this.wings = wings;
        this.canTeleport = canTeleport;
    }

    public SuperAnimal(String name, String species, double size, boolean wings, boolean canTeleport){
        super.setName(name);
        super.setSpecies(species);
        super.setSize(size);
        super.setOffspring(0);
        super.setColour("unknown");
        this.wings = wings;
        this.canTeleport = canTeleport;
    }

    public SuperAnimal(String name, String species, double size, String colour, boolean wings, boolean canTeleport){
        super.setName(name);
        super.setSpecies(species);
        super.setSize(size);
        super.setOffspring(0);
        super.setColour(colour);
        this.wings = wings;
        this.canTeleport = canTeleport;
    }

    public void setWings(boolean wings){
        this.wings = wings;
    }

    public String fly(){
        if(wings){
            return super.getName() + " can fly!";
        }else{
            return super.getName() + " cannot fly!";
        }
    }

    public void setTeleport(boolean canTeleport){
        this.canTeleport = canTeleport;
    }

    public String teleport(String toPlace){
        if(canTeleport){
            return super.getName() + " teleported to " + toPlace + "!";
        }else{
            return super.getName() + " cannot teleport!";
        }
    }

    public void setLaserEyes(boolean laserEyes){
        this.laserEyes = laserEyes;
    }

    public void setLaserEyesColour(String laserEyesColour){
        this.laserEyesColour = laserEyesColour;
    }

    public String shootLaserEyes(){
        if(laserEyes){
            return super.getName() + " is shooting " + laserEyesColour + " lasers from its eyes!";
        }else{
            return super.getName() + " cannot shoot lasers...";
        }
    }
}
