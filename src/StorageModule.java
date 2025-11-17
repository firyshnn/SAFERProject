import java.io.*;
import java.util.ArrayList;

public class StorageModule {

    private static final String FILE_NAME = "users.txt";

    public static void saveUsers(ArrayList<User> users) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (User u : users) {
                pw.println(u.getFirstname() + "," +
                        u.getLastname() + "," +
                        u.getDepartment() + "," +
                        u.getBlock() + "," +
                        u.getEmail() + "," +
                        u.getStudentCode() + "," +
                        u.getPassword());
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> list = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return list;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    User u = new User(data[0], data[1], data[2],
                            data[3], data[4], data[5], data[6]);
                    list.add(u);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }

        return list;
    }
}