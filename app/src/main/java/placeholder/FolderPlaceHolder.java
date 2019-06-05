package placeholder;

import java.util.ArrayList;
import java.util.List;

import klase.Folder;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FolderPlaceHolder {

    @GET("folders")
    Call<ArrayList<Folder>> getFolders();
}
