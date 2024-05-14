package Lessons;

public class TestAnimal {
    static Animal myAnimal = new Animal("Jeff", "shark", 200);

    public static void main (String[] args){
        System.out.println(myAnimal.getName());

        myAnimal.setName("tom");
        System.out.println(myAnimal.getName());

        System.out.println(myAnimal.getOffspring());
        myAnimal.setOffspring(2);
        System.out.println(myAnimal.getOffspring());
        myAnimal.giveBirth(3);
        System.out.println(myAnimal.getOffspring());

        myAnimal.setAction("running");

    }
}
