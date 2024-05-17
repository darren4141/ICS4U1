package Lessons.Inheritance;

public class SuperAnimal extends Animal{
    private boolean wings;
    private boolean canTeleport;

    public String fly(){
        if(wings){
            return getName() + " can fly!";
        }else{
            return getName() + " cannot fly!";
        }
    }

    public String teleport(String toPlace){
        if(canTeleport){
            return getName() + " teleported to " + toPlace + "!";
        }else{
            return getName() + " cannot teleport!";
        }
    }
}
