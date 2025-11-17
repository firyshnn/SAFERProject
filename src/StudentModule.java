import java.util.Scanner;

public class StudentModule {
    private Scanner sc = new Scanner(System.in);

    public void studentReportPage(User student) {
        System.out.println("\nWelcome, " + student.getFirstname() + " " + student.getLastname() + "!");

        while (true) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("[1] View Profile");
            System.out.println("[2] Logout");
            System.out.print("Choose option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    showProfile(student);
                    break;
                case "2":
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void showProfile(User s) {
        System.out.println("\n--- Your Profile ---");
        System.out.println("Name: " + s.getFirstname() + " " + s.getLastname());
        System.out.println("Department: " + s.getDepartment());
        System.out.println("Block: " + s.getBlock());
        System.out.println("Email: " + s.getEmail());
        System.out.println("SR-CODE: " + s.getStudentCode());
    }
}