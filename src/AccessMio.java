import java.util.Scanner;

public class AccessMio {
    private Scanner scanner;

    public AccessMio(Scanner scanner) {
        this.scanner = scanner;
    }

    public void accessMio() {
        System.out.println("Write your Mio:");
        String message = scanner.nextLine();

        System.out.println("Please choose a recipient :");
        System.out.println("1-Teacher:\n2-Student:");
        int recip = ValidateIntInput(1,2);

        switch (recip){

            case 1:
                System.out.println("1-Dara Aghamirkarimi\n2-Ramiro Affonso\n3-Andrea Mercier\n4-Nguyen");
                System.out.println("Enter the number associated with the recipient you would like to send the message");

                int t_choice = ValidateIntInput(1,4);
                break;
            case 2:
                System.out.println("1-Tsiory Rakotoarimanana\n2-Danilo Roman\n3-Thiago Neto\n4-Yasin Muhammad");
                System.out.println("Enter the number associated with the recipient you would like to send the message");
                int st_choice = ValidateIntInput(1,4);

                break;

        }

        System.out.println("Do you want to send the Mio? (Y/N)");
        String sendOption = scanner.nextLine();

        if (sendOption.equalsIgnoreCase("Y")) {
            System.out.println("Mio sent successfully!");
        } else {
            System.out.println("Mio canceled.");
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
