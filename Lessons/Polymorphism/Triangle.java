package Lessons.Polymorphism;

public abstract class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("This is a /\\");
    }

    @Override
    public void erase() {
        System.out.println("Erase the /\\ shape");
    }
}
