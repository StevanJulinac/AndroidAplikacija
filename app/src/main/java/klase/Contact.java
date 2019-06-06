package klase;

import java.io.Serializable;

public class Contact  implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private String display;
    private String email;
    private String format;
    private String slika;


    public Contact(){
    }

    public Contact(String id, String firstName, String lastName, String display, String email, String format, String slika) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.display = display;
        this.email = email;
        this.format = format;
        this.slika = slika;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", display='" + display + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
