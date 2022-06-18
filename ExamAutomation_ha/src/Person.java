
public class Person {

    // --------------- Attributes ---------------
    private String firstName;
    private String lastName;
    private String field;
    private String password;


    // --------------- Methods ---------------
    // ...


    // --------------- Constructor ---------------
    public Person(String firstName, String lastName, String field, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.field = field;
        this.password = password;
    }


    // --------------- Getter_Setter ---------------
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setField(String field) {
        this.field = field;
    }
    public String getField() {
        return field;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
