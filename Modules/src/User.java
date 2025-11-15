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
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.block = block;
        this.email = email;
        this.studentCode = studentCode;
        this.password = password;
    }

    // Getters
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getDepartment() {
        return department;
    }
    public String getBlock() {
        return block;
    }
    public String getEmail() {
        return email;
    }
    public String getStudentCode() {
        return studentCode;
    }
    public String getPassword() {
        return password;
    }
}
