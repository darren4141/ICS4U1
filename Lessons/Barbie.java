package Lessons;

public class Barbie extends Toy{

    private String shirtColor;

    public String getName(){
        return "This Barbie is named" + super.getName();
    }

    public void setShirtColor(String color){
        shirtColor = color;
    }
    
    public String getShirtColor(){
        return shirtColor;
    }


}
