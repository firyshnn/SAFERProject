import java.util.Scanner;

public class LoginModule {
    Scanner sc = new Scanner(System.in);

    public void startLogin() {
        String username = inputUsername();
        String password = inputPassword();

        checkUserType(username, password);
        validateLogin(username, password);
    }

    private String inputUsername() {
        System.out.print("Enter username: ");
        return sc.nextLine();
    }

    private String inputPassword() {
        System.out.print("Enter password: ");
        return sc.nextLine();
    }

    private void checkUserType(String username, String password) {
        if (username.contains("Admin") && password.contains("Admin")) {
            System.out.println("You are an Admin!");
            AdminModule admin = new AdminModule();
            admin.adminHomePage();
        } else {
            System.out.println("You are a Student.");
            StudentModule student = new StudentModule();
            student.studentReportPage();
        }
    }

    private void validateLogin(String username, String password) {
        while (!username.equals("SAFERuser") || !password.equals("SAFERuser01")) {
            System.out.println("Incorrect username or password, please try again.");

            username = inputUsername();
            password = inputPassword();
        }
        System.out.println("Login successful!");
    }
}

