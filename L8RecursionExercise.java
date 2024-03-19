import java.util.Scanner;

public class L8RecursionExercise {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repeat = true;

        while(repeat){
            System.out.println("Welcome to the recursion program! What would you like to do?\n1. Factorial\n2. GCF\n3. Exponents\n4. Fibbonaci sequence\n5. Sum Digits\n6. Exit");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("What number would you like to find the factorial of?");
                    int num = sc.nextInt();
                    System.out.println(factorial(num));
                    break;
                case 2:
                    System.out.println("Which two number would you like to find the GCF of?");
                    int num1 = sc.nextInt();
                    int num2 = sc.nextInt();
                    System.out.println(gcf(num1, num2));
                    break;
                case 3:
                    System.out.println("Enter a base and exponent (exponent can be a positive or negative integer):");
                    int base = sc.nextInt();
                    int exponent = sc.nextInt();
                    System.out.println(pow(base, exponent));
                    break;
                case 4:
                    System.out.println("Which number in the fibbonaci sequence would you like to find?");
                    int fib = sc.nextInt();
                    System.out.println(fibbonaci(fib));
                    break;
                case 5:
                    System.out.println("Enter a number to sum the digits of:");
                    int digSum = sc.nextInt();
                    System.out.println(sumDigits(digSum));
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    repeat = false;
                    break;
                default:   
                    System.out.println("Please enter a valid option");
                    break;
            }

        }
        
    }

    public static int factorial(int num){
        if(num == 1){
            return 1;
        }
        return factorial(num - 1) * num;
    }

    public static int gcf(int a, int b){
        if(a < b){
            return gcf(b, a);
        }else if(a > b){
            return gcf(b, a-b);
        }else{
            return a;
        }
    }

    public static double pow(int base, int exp){
        if(exp > 0){
            return pow(base, exp-1) * base;
        }else if(exp < 0){
            return pow(base, exp+1) / base;
        }else{
            return 1;
        }
    }

    /*
     * Extra problems:
     * - fibbonaci sequence
     * - sum of digits of a number
     */

    public static int fibbonaci(int n){
        if(n == 1 || n == 2){
            return 1;
        }else{
            return fibbonaci(n-1) + fibbonaci(n-2);
        }
    }

    public static int sumDigits(int a){
        if(a < 10){
            return a;
        }else{
            return a%10 + sumDigits(a/10);
        }
    }
    
}
