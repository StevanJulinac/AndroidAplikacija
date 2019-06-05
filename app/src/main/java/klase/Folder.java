package klase;


import java.io.Serializable;

public class Folder implements Serializable {

    private String id;
    private String name;
    private String parent;


    public Folder(){
        this.id = "";
        this.name = "";
        this.parent = "";
    }

    public Folder(String id, String name,String parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

    public String getParent(){
        return parent;
    }
    public  void setParent(){
        this.parent = parent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Folder{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }
}
