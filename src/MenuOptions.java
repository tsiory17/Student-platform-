import java.util.Scanner;

public class MenuOptions {
    private Scanner scanner;

    private Student student;

    public MenuOptions(Scanner scanner , Student student)
    {
        this.scanner = scanner;
        this.student = student;
    }

    public void showOptions() {
        System.out.println("1. Access Mio");
        System.out.println("2. Access Lea");
        System.out.println("3. Check Schedule");
        System.out.println("4. Enroll Course");
        System.out.println("5. Cancel Course");
        System.out.println("6. Pay Fees");
        System.out.println("0. Exit");
    }

    public void processChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Thank you for trusting Omnivox , see you next time.");
                System.exit(0);
                break;
            case 1:

                AccessMio accessMio = new AccessMio(scanner);
                accessMio.accessMio();
                break;
            case 2:

                  this.student.accessLea(scanner);
                break;
            case 3:
                this.student.displayEnrolledCourses();
                break;
            case 4:
                System.out.println("Choose one of the course below to enroll: ");
                this.student.enrollCourse(scanner);

                break;

            case 5:
                this.student.CancelCourse(scanner);
                break;
            case 6:
//                System.out.println("Paying fees...");
                this.student.displaybalance();
                this.student.payfees(scanner);

                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }


}



