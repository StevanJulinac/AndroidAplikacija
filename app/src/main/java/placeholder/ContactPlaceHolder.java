package placeholder;

import java.util.ArrayList;

import klase.Contact;
import klase.Folder;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ContactPlaceHolder {

    @GET("contacts")
    Call<ArrayList<Contact>> getContacts();

    @GET("contacts/{contactId}")
    Call<Contact> getContact(@Path("contactId") String id);
}
