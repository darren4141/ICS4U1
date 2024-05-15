package Lessons.Polymorphism;

public class Circle extends Shape{

    @Override
    public void draw() {
        System.out.println("This is a O");
    }

    @Override
    public void erase() {
        System.out.println("Erase the O shape");        
    }
}
