package Lessons;
public class MainToy {
    static Toy toy1 = new Toy("Ball", 2, 5);
    static Toy toy2 = new Toy("Doll", 4, 8);
    static Toy toy3 = new Toy("Car", 3, 6);

    public static void main(String[]args){
        System.out.println(toy1.getName() + ": $" + toy1.getCost());
        System.out.println(toy2.getName() + ": $" + toy2.getCost());
        System.out.println(toy3.getName() + ": $" + toy3.getCost());

        Toy[] toys = new Toy[3];
    
        toys[0] = toy1;
        toys[1] = toy2;
        toys[2] = toy3;

        boolean swapped = true;

        for (int i = toys.length - 1; i > 0; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (toys[j].getCost() > toys[j + 1].getCost()) {
                    Toy temp = toys[j];
                    toys[j] = toys[j+1];
                    toys[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }

        for(Toy t : toys){
            System.out.println(t.getName() + ": $" + t.getCost());
        }
        
    }


}
