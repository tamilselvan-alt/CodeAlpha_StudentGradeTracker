import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double score;

    Student(String name, double score) {
        this.name = name;
        this.score = score;
    }
}

public class StudentGradeTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("      STUDENT GRADE TRACKER");
        System.out.println("=================================");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Input student details
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter score (0-100): ");
            double score = sc.nextDouble();
            sc.nextLine();

            // Validate score
            if (score < 0 || score > 100) {
                System.out.println("Invalid score! Please enter between 0 and 100.");
                i--;
                continue;
            }

            students.add(new Student(name, score));
        }

        // Calculate total, highest and lowest
        double total = 0;
        double highest = students.get(0).score;
        double lowest = students.get(0).score;

        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        for (Student student : students) {

            total += student.score;

            if (student.score > highest) {
                highest = student.score;
                highestStudent = student.name;
            }

            if (student.score < lowest) {
                lowest = student.score;
                lowestStudent = student.name;
            }
        }

        double average = total / students.size();

        // Display Summary Report
        System.out.println("\n\n=================================");
        System.out.println("        SUMMARY REPORT");
        System.out.println("=================================");

        System.out.printf("%-20s %-10s%n", "Student Name", "Score");
        System.out.println("---------------------------------");

        for (Student student : students) {
            System.out.printf("%-20s %.2f%n",
                    student.name, student.score);
        }

        System.out.println("---------------------------------");
        System.out.printf("Average Score : %.2f%n", average);
        System.out.printf("Highest Score : %.2f (%s)%n",
                highest, highestStudent);
        System.out.printf("Lowest Score  : %.2f (%s)%n",
                lowest, lowestStudent);

        System.out.println("=================================");
        System.out.println("       Report Generated!");
        System.out.println("=================================");

        sc.close();
    }
}