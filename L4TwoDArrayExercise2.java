import java.util.Scanner;

public class L4TwoDArrayExercise2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[]args){

        System.out.println("How many students are there?");
        int numStudents = sc.nextInt();
        System.out.println("How many marks are there?");
        int numMarks = sc.nextInt();

        String[] names = new String[numStudents];
        int[][]marks = new int[numStudents][numMarks];

        for(int i = 0; i < numStudents; i++){
            System.out.println("What is student " + (i + 1) + "'s name?");
            names[i] = sc.next();
            for(int j = 0; j < numMarks; j++){
                System.out.println("What is mark #" + (j+1) + ": ");
                marks[i][j] = sc.nextInt();
            }
        }

        System.out.print("|\t|");

        for(int i = 0; i < numMarks; i++){
            System.out.print("test #" + (i+1) + "|");
        }

        System.out.print("Average|");

        System.out.print("\n|-------+");

        for(int i = 0; i < numMarks; i++){
            System.out.print("-------+");
        }

        System.out.print("-------|");

        for(int i = 0; i < numStudents; i++){
            System.out.print("\n|" + names[i] + "\t|");
            double avg = 0;
            for(int j = 0; j < numMarks; j++){
                System.out.print(marks[i][j] + "\t|");
                avg += marks[i][j];
            }
            System.out.print((double)avg/numMarks + "\t|");
        }

        System.out.print("\n|Average|");

        for(int i = 0; i < numMarks; i++){
            int testAvg = 0;
            for(int j = 0; j < numStudents; j++){
                testAvg+=marks[j][i];
            }

            double average = (double)(Math.round(testAvg * 100/numStudents))/100;
            System.out.print(average + "\t|");

        }

        System.out.print("-------|");

    }

}
