import java.io.*;

public class L1MethodsDemo {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[]args) throws IOException{
        L1MethodsDemo md = new L1MethodsDemo();
        double f, c;

        System.out.println("Enter degrees F: ");
        f = Double.parseDouble(br.readLine());
        c = md.convertFtoC(f);

        System.out.println("Degrees C: ");
        System.out.println(c);
    }

    /*
     * Method: convert F to C used to convert a farenheit value to a celcius value
     * @param: double farenheit --> the temperature in farenheit
     * @return: double celcius --> the temperature in celcius
     */
    public double convertFtoC(double farenheit){
        double celcius;
        celcius = (farenheit - 32) * 5/9;
        return celcius;
    }
}
