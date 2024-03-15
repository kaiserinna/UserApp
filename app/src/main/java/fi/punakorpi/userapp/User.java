package fi.punakorpi.userapp;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;

    public User(String firstName, String lastName, String email, String degreeProgram) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
    }

    public java.lang.String getFirstName() {
        return firstName;
    }
    public java.lang.String getLastName() {
        return lastName;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public java.lang.String getDegreeProgram() {
        return degreeProgram;
    }
}
