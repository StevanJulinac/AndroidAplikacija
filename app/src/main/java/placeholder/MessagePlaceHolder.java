package placeholder;

import java.util.ArrayList;

import klase.Contact;
import klase.Message;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MessagePlaceHolder {

    @GET("messages")
    Call<ArrayList<Message>> getMessages();

    @GET("messages/{messageId}")
    Call<Message> getMessage(@Path("messageId")String id);
}
