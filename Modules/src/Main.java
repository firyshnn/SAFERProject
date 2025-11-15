import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to SAFER!");

        ArrayList<User> users = new ArrayList<>();
        LoginModule login = new LoginModule(users);
        login.startLogin();
    }
}
