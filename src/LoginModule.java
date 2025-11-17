import java.util.ArrayList;
import java.util.Scanner;

public class LoginModule {
    private Scanner sc = new Scanner(System.in);
    private ArrayList<User> users;

    public LoginModule(ArrayList<User> users) {
        this.users = users;
    }

    public void startLogin() {
        while (true) {
            System.out.print("\nEnter your SR-CODE: ");
            String username = sc.nextLine().trim();

            System.out.print("Enter password: ");
            String password = sc.nextLine().trim();

            if (isAdmin(username, password)) {
                AdminModule admin = new AdminModule(users);
                admin.adminHomePage();
                break;
            }

            User student = findStudent(username, password);
            if (student != null) {
                System.out.println("\nLogin successful!");
                StudentModule sm = new StudentModule();
                sm.studentReportPage(student);
                break;
            }

            System.out.println("\nAccount not found!");
            System.out.print("Don't have an account? Type 'Yes' to create an account: ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("Yes")) {
                RegistrationModule reg = new RegistrationModule(users);
                reg.startRegistration();
            } else
                startLogin();
        }
    }

    private boolean isAdmin(String user, String pass) {
        return user.equalsIgnoreCase("Admin") && pass.equals("Admin");
    }

    private User findStudent(String user, String pass) {
        for (User u : users) {
            if (u.getStudentCode().equalsIgnoreCase(user)
                    && u.getPassword().equals(pass)) {
                return u;
            }
        }
        return null;
    }
}