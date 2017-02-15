package Models.People;

/**
 * Representation of a User as a model.
 *
 * @author Kris Campos
 * @version 1 - initial version. 1/31/2017
 */
public class User {
    private int userID;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;

    public User() {}

    public User(int userID, String userName, String email, String firstName, String lastName) {
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}