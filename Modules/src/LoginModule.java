import java.util.ArrayList;
import java.util.Scanner;

public class LoginModule {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<User> studentAccounts;

    public LoginModule(ArrayList<User> studentAccounts) {
        this.studentAccounts = studentAccounts;
    }

    public void startLogin() {
        while (true) {
            System.out.print("\nEnter your SR-CODE: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if (checkUserType(username, password)) {
                break;
            }

            if (validateStudent(username, password)) {
                break;
            }
        }
    }

    private boolean checkUserType(String username, String password) {
        if (username.equalsIgnoreCase("Admin") && password.equals("Admin")) {
            System.out.println("You are an Admin!");
            AdminModule admin = new AdminModule();
            admin.adminHomePage();
            return true;
        } else {
            validateStudent(username, password);
            return false;
        }
    }

    private boolean validateStudent(String username, String password) {
        User student = findStudent(username, password);

        if (student != null) {
            System.out.println("Login successful!");
            StudentModule studentModule = new StudentModule();
            studentModule.studentReportPage();
            return true;
        } else {
            System.out.println("\nAccount not found!");
            System.out.print("Don't have an account? Yes or No (press Enter to try login again): ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("Yes")) {
                RegistrationModule register = new RegistrationModule(studentAccounts);
                register.startRegistration();
                System.out.println("Registration complete. Please try logging in again.");
            }
            return false;
        }
    }

    private User findStudent(String username, String password) {
        for (User u : studentAccounts) {
            if (u.getStudentCode().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
