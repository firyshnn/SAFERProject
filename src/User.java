
public class User {
    private String firstname;
    private String lastname;
    private String department;
    private String block;
    private String email;
    private String studentCode;
    private String password;

    public User(String firstname, String lastname, String department, String block,
                String email, String studentCode, String password) {

        this.firstname = firstname.trim();
        this.lastname = lastname.trim();
        this.department = department.trim();
        this.block = block.trim();
        this.email = email.trim();
        this.studentCode = studentCode.trim();
        this.password = password.trim();
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getDepartment() { return department; }
    public String getBlock() { return block; }
    public String getEmail() { return email; }
    public String getStudentCode() { return studentCode; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return firstname + " " + lastname + " | " +
                "Dept: " + department + " | Block: " + block +
                " | SR-CODE: " + studentCode + " | Email: " + email;
    }
}