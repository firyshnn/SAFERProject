import java.util.ArrayList;
import java.util.Scanner;

public class RegistrationModule {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<User> users;


    public RegistrationModule(ArrayList<User> users) {
        this.users = users;
    }

    public void startRegistration() {
        System.out.println("\n--- BSU SAFER Registration Form ---");

        String firstname = inputFirstname();
        String lastname = inputLastname();
        String department = inputDepartment();
        String block = inputBlock();
        String email = inputEmail();
        String studentCode = inputStudentCode();
        String password = inputPassword();

        if (!firstname.isEmpty() && !lastname.isEmpty() && !department.isEmpty() &&
                !block.isEmpty() && !email.isEmpty() && !studentCode.isEmpty() && !password.isEmpty()) {

            User newUser = new User(firstname, lastname, department, block, email, studentCode, password);
            users.add(newUser);

            System.out.println("\n Registration successful!");
            System.out.println("Welcome, " + firstname + " " + lastname + "!");
        } else {
            System.out.println("\n Registration failed! All fields are required. Please try again.\n");
            startRegistration();
        }
    }

    // Inputs
    private String inputFirstname() {
        System.out.print("\nEnter your first name: ");
        return sc.nextLine();
    }

    private String inputLastname() {
        System.out.print("Enter your last name: ");
        return sc.nextLine();
    }

    private String inputDepartment() {
        System.out.print("Enter your department: ");
        return sc.nextLine();
    }

    private String inputBlock() {
        System.out.print("Enter your block: ");
        return sc.nextLine();
    }

    private String inputEmail() {
        System.out.print("Enter your email: ");
        return sc.nextLine();
    }

    private String inputStudentCode() {
        System.out.print("Enter your SR-CODE: ");
        return sc.nextLine();
    }

    private String inputPassword() {
        System.out.print("Enter your password: ");
        return sc.nextLine();
    }
}
