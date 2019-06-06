package placeholder;

import java.util.ArrayList;
import java.util.List;

import klase.Folder;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface FolderPlaceHolder {

    @GET("folders")
    Call<ArrayList<Folder>> getFolders();

    @GET("folders/{folderId}")
    Call<Folder> getFolder(@Path("folderId")String id);

    @POST("folder")
    Call<Folder>createFolder(@Body Folder folder);
}
