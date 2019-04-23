package klase;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact  implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }
        public Contact[] newArray(int size) {
            return new Contact [size];
        }};

    private String id;
    private String firstName;
    private String lastName;
    private String display;
    private String email;
    private String format;
    private String slika;


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

    public Contact(Parcel in){
        this.id = in.readString();
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.display = in.readString();
        this.email = in.readString();
        this.format = in.readString();
        this.slika = in.readString();
    }

    @Override
    public int describeContents(){
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest,int flags){
        dest.writeString(this.id);
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeString(this.display);
        dest.writeString(this.email);
        dest.writeString(this.format);
        dest.writeString(this.slika);
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
