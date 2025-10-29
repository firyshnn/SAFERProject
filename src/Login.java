import java.util.Scanner;

public class Login {
    public static void main (String [] args){
        Scanner sc = new Scanner (System.in);
        String username;
        String password;

        System.out.print("Enter username: ");
        username = sc.nextLine();
        System.out.print("Enter password: ");
        password = sc.nextLine();

        if (username.contains("Admin") && password.contains("Admin")){
            System.out.println("You are an Admin!");
        } // input admin home page module
        else {
            System.out.println("You are a student");
            // input student filing report module
        }

        // input error handling here (pagiisipan pa)

        /* while (!username.equals("SAFERuser") || !password.equals("SAFERuser01")){
            System.out.println("Incorrect username or password, please try again");
            System.out.print("Enter username: ");
            username = sc.nextLine();
            System.out.print("Enter password: ");
            password = sc.nextLine();
        } */
    }
}
