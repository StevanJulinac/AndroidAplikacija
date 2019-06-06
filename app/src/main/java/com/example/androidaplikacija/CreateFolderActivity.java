package com.example.androidaplikacija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import klase.Folder;
import placeholder.FolderPlaceHolder;
import placeholder.MessagePlaceHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CreateFolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_folder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create_folder_menu, menu);
        return true;
    }


    public void CreateFolder(){

        TextView folderName = (TextView)findViewById(R.id.txt_view_FolderName);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.47:8080/RestService/folderservice/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FolderPlaceHolder folderPlaceHolder = retrofit.create(FolderPlaceHolder.class);
        Folder folder = new Folder("4","321","1");
        folder.setName((String) folderName.getText());

        Call<Folder> call = folderPlaceHolder.createFolder(folder);
        call.enqueue(new Callback<Folder>() {
            @Override
            public void onResponse(Call<Folder> call, Response<Folder> response) {
                if(!response.isSuccessful()){
                    return;
                }
                Folder  folderResponse = response.body();
            }

            @Override
            public void onFailure(Call<Folder> call, Throwable t) {

            }
        });


    }



    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.save_folder:
                CreateFolder();
                Toast.makeText(CreateFolderActivity.this,
                        "Folder saved", Toast.LENGTH_SHORT).show();
                return true;

            case  R.id.cancel_folder:
                Toast.makeText(CreateFolderActivity.this,
                        "Folder canceled", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.back:
                Intent intent = new Intent(this, FoldersActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }}

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
