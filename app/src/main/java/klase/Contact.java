package klase;

public class Contact {

    private String id;
    private String firstName;
    private String lastName;
    private String display;
    private String email;
    private String format;
    private Photo slika;


    public Contact(){
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        this.display = "";
        this.email = "";
        this.format = "";
    }

    public Contact( String firstName, String lastName, String display, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.display = display;
        this.email = email;
    }

    public Contact(String id, String firstName, String lastName, String display, String email, String format) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.display = display;
        this.email = email;
        this.format = format;
    }

    public Contact(String id, String firstName, String lastName, String display, String email, String format, Photo slika) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.display = display;
        this.email = email;
        this.format = format;
        this.slika = slika;
    }

    public Photo getSlika() {
        return slika;
    }

    public void setSlika(Photo slika) {
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
}
