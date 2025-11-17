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


        // check for empty spaces
        if (!firstname.isEmpty() && !lastname.isEmpty() && !department.isEmpty() &&
                !block.isEmpty() && !email.isEmpty() && !studentCode.isEmpty() && !password.isEmpty()) {

            // Check if user already exists
            if (isUserExists(studentCode, email)) {
                System.out.println("\nRegistration failed! SR-CODE or email already exists. Please log in or use different details.");
                System.out.print("Register again? 'Yes/No': ");
                String choice = sc.nextLine().trim();
                if (choice.equalsIgnoreCase("Yes")) {
                    startRegistration();
                } else if (choice.equalsIgnoreCase("No")) {
                    System.out.println("Returning to login...");
                    return;  // Exit
                } else {
                    startRegistration();
                }
            } else {
                // if unique/successful it will be a new user
                User newUser = new User(firstname, lastname, department, block, email, studentCode, password);
                users.add(newUser);
                // if successful maadd sa storage
                StorageModule.saveUsers(users);
                System.out.println("\nRegistration successful!");
                System.out.println("Welcome, " + firstname + " " + lastname + "!");
            }
        } else {
            System.out.println("\nRegistration failed! All fields are required. Please try again.\n");
            startRegistration();
        }
    }
    // check if user exists na
    private boolean isUserExists(String studentCode, String email) {
        for (User u : users) {
            if (u.getStudentCode().equalsIgnoreCase(studentCode) || u.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
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
