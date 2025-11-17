import java.util.ArrayList;

public class AdminModule {
    private ArrayList<User> users;

    public AdminModule(ArrayList<User> users) {
        this.users = users;
    }

    public void adminHomePage() {
        System.out.println("Welcome Admin!");

        System.out.println("\n--- Registered Students ---");
        if (users.isEmpty()) {
            System.out.println("No registered users yet.");
        } else {
            for (User u : users) {
                System.out.println(u);
            }
        }
    }
}