package Lessons;

public class TestBarbie {
    static Barbie barbie = new Barbie();

    public static void main(String[]args){

        barbie.setName("a");
        System.out.println(barbie.getName());

        barbie.setShirtColor("Red");

        System.out.println("This Barbie's shirt color is: " + barbie.getShirtColor());

    }
}
