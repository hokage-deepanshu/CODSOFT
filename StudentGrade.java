import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Subjects: ");
        int subject = sc.nextInt();

        double[] marks = new double[subject];
        double totalMarks = 0;

        for (int i = 0; i < subject; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextDouble();
            totalMarks += marks[i];
        }


        double averagePercentage = totalMarks / subject;

        String grade;
        if (averagePercentage >= 90) {
            grade = "A++";
        } else if (averagePercentage >= 80) {
            grade = "B+";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }


        System.out.println("Total Marks Obtained: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("The grade is " + grade);

    }
}
