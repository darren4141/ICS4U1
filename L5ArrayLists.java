import java.util.ArrayList;

public class L5ArrayLists {
    public static void main(String[] args){
        ArrayList<String> listTest = new ArrayList<String>();
    
        listTest.add("Item 1");
        listTest.add("Item 2");
        listTest.add("Item 3");

        for(String v : listTest){
            System.out.println(v);
        }

        for(int i = 0; i < listTest.size(); i++){
            System.out.println(listTest.get(i));
        }
    }
}
