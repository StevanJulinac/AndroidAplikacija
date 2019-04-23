package klase;

import android.os.Parcel;
import android.os.Parcelable;

public class Folder implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Folder createFromParcel(Parcel in) {
            return new Folder(in);
        }
        public Folder[] newArray(int size) {
            return new Folder [size];
        }};


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

    public Folder(Parcel in){
        this.id = in.readString();
        this.name = in.readString();

    }

    @Override
    public int describeContents(){
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest,int flags){
        dest.writeString(this.id);
        dest.writeString(this.name);

    }

}
