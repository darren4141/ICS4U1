import java.util.HashMap;
public class L6HashMapsDemo {

    public static void main(String[] args){
        HashMap<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");
        System.out.println(capitalCities); 

        for(String v : capitalCities.keySet()){
            System.out.println(v);
        }

        for(String v : capitalCities.values()){
            System.out.println(v);
        }

        for(String v : capitalCities.keySet()){
            System.out.println(v + " : " + capitalCities.get(v));
        }

        HashMap<String, Integer> people = new HashMap<String, Integer>();
        people.put("John", 32);
        people.put("Steve", 30);
        people.put("Angie", 33);

        for(String v : people.keySet()){
            System.out.println(v + " : " + people.get(v));
        }
    
    }

    public static String getName(HashMap<String, Integer> list, int size, int age){
        for(String v : list.keySet()){
            if(list.get(v) == age){
                return v;
            }
        }
        return null;
    }

}
