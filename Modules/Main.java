import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to SAFER!");

        ArrayList<User> users = StorageModule.loadUsers();

        LoginModule login = new LoginModule(users);
        login.startLogin();

        StorageModule.saveUsers(users);

        System.out.println("\nSystem closed. Goodbye!");
    }
}