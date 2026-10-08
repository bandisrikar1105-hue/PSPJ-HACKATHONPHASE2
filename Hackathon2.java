import java.util.Scanner;

class Student {
    private String studentName;
    private int rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    private static final double FEE_PER_CREDIT = 1500;

    public Student(String studentName, int rollNumber, double marks,
                   String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public double calculateFee() {
        return courseCredits * FEE_PER_CREDIT;
    }

    public boolean checkEligibility() {
        return marks >= 50;
    }

    public double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85) {
            return fee * 0.20;
        } else if (marks >= 70) {
            return fee * 0.10;
        } else {
            return 0;
        }
    }

    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    public void displayDetails() {
        System.out.println("\n===== REGISTRATION DETAILS =====");
        System.out.println("Student Name   : " + studentName);
        System.out.println("Roll Number    : " + rollNumber);
        System.out.println("Marks          : " + marks);
        System.out.println("Course Name    : " + courseName);
        System.out.println("Course Credits : " + courseCredits);
        System.out.println("Eligibility    : " + (checkEligibility() ? "Eligible" : "Not Eligible"));
        System.out.println("Total Fee      : Rs. " + calculateFee());
        System.out.println("Scholarship    : Rs. " + calculateScholarship());
        System.out.println("Final Fee      : Rs. " + calculateFinalFee());
        System.out.println("================================");
    }
}

public class Hackathon2 {
    

    static Student readStudentDetails(Scanner sc) {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();
        sc.nextLine(); // consume leftover newline

        System.out.print("Enter course name: ");
        String course = sc.nextLine();

        System.out.print("Enter course credits: ");
        int credits = sc.nextInt();

        return new Student(name, roll, marks, course, credits);
    }

    static void processRegistration(Student student) {
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("Student is not eligible for registration (marks below 50).");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student student = readStudentDetails(sc);
        processRegistration(student);
        sc.close();
    }
}
