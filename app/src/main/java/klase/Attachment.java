package klase;

import android.util.Base64;

import java.io.Serializable;

public class Attachment implements Serializable {

    private String id;
    private Base64 base64;
    private String type;
    private String name;

    public Attachment(String id, Base64 base64, String type, String name) {
        this.id = id;
        this.base64 = base64;
        this.type = type;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Base64 getBase64() {
        return base64;
    }

    public void setBase64(Base64 base64) {
        this.base64 = base64;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
