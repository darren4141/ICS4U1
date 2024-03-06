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
    }

}
