package Models.People;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * This class defines the user object. Every user of the system is either a User, or an extension thereof.
 * User objects have limited access to the system, and can only view published schedules.
 * User Objects hold information about the specific user including first and last name, email address, and username.
 * Guest users are also classified as User objects, but have default values set to their instance variables.
 *
 * @author Kris Campos
 * @version 1 - initial version. 1/31/2017
 */
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(unique = true)
    private String userName;

    private String email;
    private String firstName;
    private String lastName;

    /**
     * This is the default constructor for the User class.
     * This constructor does not set any instance variables.
     * This constructor should only be used when a guest users access the system? Guys? any input here? or is this never used?
     *
     * @return      a default User Object
     */
    protected User(/*if we use this constructor for guests, we should null all instance variables*/) {}

    /**
     * This is the constructor for a User, which will be used during normal system interaction.
     *
     * @param  userName   a string representing the unique username of the user.
     * @param  email      a string representing the email address of the user
     * @param  firstName  a string representing the users first name.
     * @param  lastName   a string representing the users last name.
     * @return            a Faculty Object with all instance variable set, preferences set to default.
     */
    public User(String userName, String email, String firstName, String lastName) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * A getter-function which returns the User ID.
     *
     * @return  a String representing the UserID.
     */
    public String getUserID() {
        return id;
    }

    /**
     * A getter-function which returns the Username.
     *
     * @return  a String representing the Username.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * A getter-function which returns the User ID.
     *
     * @return  a String representing the UserID.
     */
    public String getEmail() {
        return email;
    }

    /**
     * A getter-function which returns the User's first name.
     *
     * @return  a String representing the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * A getter-function which returns the User's last name.
     *
     * @return  a String representing the User's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * A getter-function which returns the User's full name.
     *
     * @return  a String representing the User first name, appended to their last name.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * A setter-function which sets the the User's email address.
     *
     * @param  email a String representing the User's new email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * A setter-function which sets the the User's first name.
     *
     * @param  firstName a String representing the User's new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
        setFullName(this.firstName, this.lastName);
    }

    /**
     * A setter-function which sets the the User's last name.
     *
     * @param  lastName String representing the User's new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
        setFullName(this.firstName, this.lastName);
    }

    /**
     * A setter-function which sets the the User's full name.
     *
     * @param  firstName a String representing the User's new first name.
     * @param  lastName  String representing the User's new last name.
     */
    public void setFullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}