import java.util.Scanner;

public class MainMenu {
    private Scanner scanner;
    private Student student;


    public MainMenu(Scanner scanner,Student student) {

        this.scanner = scanner;
        this.student=student;
    }

    public void displayMainMenu() {
        MenuOptions menuOptions = new MenuOptions(scanner,student);
        while (true) {
            System.out.println("\nMain Menu");
            menuOptions.showOptions();

            int choice = ValidateIntInput(0,6);

            menuOptions.processChoice(choice);
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
}
