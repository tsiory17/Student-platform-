import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String name;
    private String password;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    private List<Course> courses;
    private Scanner scanner;

    private int course_enrolled = 0 ;
    public Student(String name, String password) {
        this.name = name;
        this.password = password;
        this.courses = new ArrayList<>();
        this.balance=0;
        this.scanner = new Scanner(System.in);
    }



    public void displaybalance(){

        if (this.balance==0) {
            System.out.println("There is no payment due");
        }
        else{
                System.out.println("Payment due: "+this.getBalance()+" CAD");
            }
    }

    public void displayEnrolledCourses() {
        if (courses.size()==0){
            System.out.println("Please enroll in at least one course to get your schedule");
        }
        else {
            System.out.println(this.name + ", your schedule is as follow");
            for (Course course : courses) {
                course.DisplayCourse();
            }
        }
    }

    public List<Course> getCourses() {
        return courses;
    }




    public boolean authenticateStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t\t\t\t\tOMNIVOX BY TSIORY, THIAGO , YASIN , DANILO: \nLOGIN:");
        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        return authenticate(username, password);

    }

    public boolean authenticate (String username, String password) {
        return this.name.equals(username) && this.password.equals(password);
    }


    public void accessLea(Scanner scanner) {
        System.out.println("1. Check Grades");
        System.out.println("2. Check Assignments");
        System.out.println("3. Check Documents");
        System.out.println("4. Check Balance");
        System.out.println("5. Return to main menu");


        int leaChoice = ValidateIntInput(1,5);



        switch (leaChoice) {
            case 1:
                displayGrades();
               break;
            case 2:

                manageAssignments();
                break;
            case 3:

                downloadDocuments();
                break;

            case 4:
                displaybalance();
                break;

            case 5:
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    public void enrollCourse(Scanner scanner) {
        int courseChoice = 1;
        while (courseChoice != 0) {
        if (course_enrolled<4) {
            System.out.println("Enrolling in a course...");
            System.out.println("Available courses:");
            System.out.println("1. Multi Tier Application");
            System.out.println("2. Information System");
            System.out.println("3. DataBase");
            System.out.println("4. French");
            System.out.println("To return to main menu press : 0 ");

             courseChoice = ValidateIntInput(0,4);

            Course selectedCourse = null;

                switch (courseChoice) {

                    case 1:
                        MultitierCourse multitierCourse = new MultitierCourse();
                        CourseCreator multitierBuilder = new CourseCreator(multitierCourse);
                        multitierBuilder.CreateCourse();
                        selectedCourse = multitierBuilder.getCourse();
                        break;

                    case 2:
                        InfoSystemCourse infoSystemCourse = new InfoSystemCourse();
                        CourseCreator infoSystemCourseBuilder = new CourseCreator(infoSystemCourse);
                        infoSystemCourseBuilder.CreateCourse();
                        selectedCourse = infoSystemCourseBuilder.getCourse();
                        break;

                    case 3:
                        DataBaseCourse dataBaseCourse = new DataBaseCourse();
                        CourseCreator dataBaseBuilder = new CourseCreator(dataBaseCourse);
                        dataBaseBuilder.CreateCourse();
                        selectedCourse = dataBaseBuilder.getCourse();
                        break;

                    case 4:
                        FrenchCourse frenchCourse = new FrenchCourse();
                        CourseCreator frenchCourseBuilder = new CourseCreator(frenchCourse);
                        frenchCourseBuilder.CreateCourse();
                        selectedCourse = frenchCourseBuilder.getCourse();
                        break;

                    case 0:

                        break;

                    default:
                        System.out.println("Invalid choice. Choose option 1,2,3 or 4 . If you want to return to Main Menu , choose 0\n");

                }

                if (selectedCourse != null) {
                    boolean alreadyEnrolled = false;
                    for (Course enrolledCourse : courses) {
                        if (enrolledCourse.getName().equals(selectedCourse.getName())) {
                            alreadyEnrolled = true;
                            break;
                        }
                    }

                    if (alreadyEnrolled) {
                        System.out.println("You are already enrolled in this course: " + selectedCourse.getName() + " please select another course. ");
                    } else {
                        courses.add(selectedCourse);
                        System.out.println("Enrolled in course: " + selectedCourse.getName());
                        this.balance = this.balance + selectedCourse.getCost();

                        course_enrolled++;
                    }
                } else if (course_enrolled ==4){
                    System.out.println("No course available : You have enrolled in all the courses. ");
                }
                else if (courseChoice ==0){
                    System.out.println("Returning to Main Menu ... ");
                }
            }
        }
    }

    public void displayGrades(){
        System.out.println(this.name + ", These are your grades: ");
        for (Course course : courses) {
            course.DisplayGrades();
        }
    }

    public void manageAssignments() {

    }

    public void downloadDocuments() {

    }

    public void CancelCourse (Scanner scanner){
        if (course_enrolled==0){
            System.out.println("There is no course to cancel ");
        }else {
            System.out.println("Those are the list of your course please select which one to Cancel : ");
            int i = 1;
            for (Course course : courses) {
                System.out.print("- "+i+" : ");
                course.DisplayCourseToCancel();
                i++;
            }

            System.out.println("PLease enter the number of the course you would like to cancel : ");
            int courseChoice = ValidateIntInput(1,i-1);


            System.out.println("Are you sure about cancelling this course? (Y/N)");
            String sendOption = scanner.nextLine();

            if (sendOption.equalsIgnoreCase("Y")) {
                System.out.println(this.courses.get(courseChoice-1).getName()+" has been succesfully removed");
                this.balance = this.balance - this.courses.get(courseChoice-1).getCost();
                this.courses.remove(courseChoice-1);

            } else {
                System.out.println("Cancellation canceled.");
            }
        }
    }


    public void payfees(Scanner scanner){


        if (this.balance>0){
            System.out.println("Please enter the amount you would like to pay: ");
            double amount = ValidateDoubleinput();
            scanner.nextLine();
            if (amount > balance){
                System.out.println("Transaction is over the amount due please try again with correct amount or lower.");

            }else{
                this.balance = this.balance-amount;
                System.out.println("Thank you for your payment");
            }

        }else{
            System.out.println("All fees have been successfully paid . Thank you ");
        }
    }

    private int ValidateIntInput(int a , int b) {
        int input;
        while (true) {
            try {
                input = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading the integer
                break;
            } catch (Exception e) {
                scanner.nextLine(); // Consume the invalid input
                System.out.println("Please enter a valid number between "+a+" and "+b);
            }
        }
        while (input < a  || input > b ){
            System.out.println("Please enter a valid number between "+a+" and "+b);
            input = ValidateIntInput(a,b);
        }
        return input;
    }
    private double ValidateDoubleinput(){
        double input;
        while (true) {
            try {
                input = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character after reading the integer
                break;
            } catch (Exception e) {
                scanner.nextLine(); // Consume the invalid input
                System.out.println("Please enter a valid number :");

            }
        }
            while (input < 0){
                System.out.println("Negative value is not accepted. Please try again");
                input = ValidateDoubleinput();
            }
            return input;
    }

}
