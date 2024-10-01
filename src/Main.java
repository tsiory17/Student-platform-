import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Student student = new Student("Dara","handsome");
        // Authenticate the student
        boolean isAuthenticated = student.authenticateStudent();



        int i = 3;
        while (!isAuthenticated && i >0){
            System.out.flush();
            System.out.println("Your password or username is wrong please try again.\n  YOU HAVE  "+i+" ATTEMPT LEFT");
            isAuthenticated = student.authenticateStudent();

            i--;
        }
        if (isAuthenticated){
        MainMenu mainmenu = new  MainMenu(scanner ,student);
        mainmenu.displayMainMenu();}
        else {
            System.out.println("Authentication failed. you cannot access omnivox");
        }
    }
}