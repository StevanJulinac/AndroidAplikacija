package klase;

import java.io.Serializable;

public class Photo implements Serializable {
    private String id;
    private String path;

    public Photo(String id, String path) {
        this.id = id;
        this.path = path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
