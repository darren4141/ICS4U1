public class MainToy {
    static Toy toy1 = new Toy("Ball", 2, 5);
    static Toy toy2 = new Toy("Car", 3, 6);
    static Toy toy3 = new Toy("Doll", 4, 8);

    public static void main(String[]args){
        System.out.println(toy1.getName() + ": $" + toy1.getCost());
        System.out.println(toy2.getName() + ": $" + toy2.getCost());
        System.out.println(toy3.getName() + ": $" + toy3.getCost());
    }

}
