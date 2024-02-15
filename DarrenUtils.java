public class DarrenUtils {
    
    public void printMenu(String[] options){
        System.out.println("What would you like to do?");

        for(int i = 0; i < options.length; i++){
            System.out.println((i+1) + ". " + options[i]);
        }

        System.out.println((options.length + 1) + ". Exit");
    }
}
