package com.example.androidaplikacija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import klase.Contact;
import klase.Folder;
import klase.Message;
import placeholder.FolderPlaceHolder;
import placeholder.MessagePlaceHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FolderActivity extends AppCompatActivity {
    //Contact kontakt1 = new Contact("1","Marko","Markovic","1","1","1");
    //Contact kontakt2 = new Contact("2","Pera","Peric","1","1","1");
    ArrayList<Message> poruke = new ArrayList<Message>();
    //Message poruka1 = new Message("a","aa", Calendar.getInstance().getTime(),kontakt2,kontakt1);
    //Message poruka2 = new Message("b","bb", Calendar.getInstance().getTime(),kontakt1,kontakt2);
    //Message poruka3 = new Message("v","vv", Calendar.getInstance().getTime(),kontakt2,kontakt1);
    //Message poruka4 = new Message("g","gg", Calendar.getInstance().getTime(),kontakt1,kontakt2);
   // Message poruka5 = new Message("d","dd", Calendar.getInstance().getTime(),kontakt2,kontakt1);

    Folder folder = new Folder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.folder_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.edit_folder:
                Toast.makeText(FolderActivity.this,
                        "Edit", Toast.LENGTH_SHORT).show();
                return true;

            case  R.id.back:
                Intent intent = new Intent(this, FoldersActivity.class);
                startActivity(intent);

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



        Intent intent = getIntent();
        String id = intent.getStringExtra("folder");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.47:8080/RestService/messageservice/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FolderPlaceHolder folderPlaceHolder= retrofit.create(FolderPlaceHolder.class);

        Call<Folder> call = folderPlaceHolder.getFolder(id);
        call.enqueue(new Callback<Folder>() {
            @Override
            public void onResponse(Call<Folder> call, Response<Folder> response) {
                if(!response.isSuccessful()){
                    return;
                }
                folder = response.body();

            }

            @Override
            public void onFailure(Call<Folder> call, Throwable t) {

            }
        });

        ListView lw = (ListView)findViewById(R.id.listViewEmails);

        TextView folderName = (TextView)findViewById(R.id.folderId);
        folderName.setText(folder.getName());

       /* poruke.add(poruka1);
        poruke.add(poruka2);
        poruke.add(poruka3);
        poruke.add(poruka4);
        poruke.add(poruka5);

        Folder folder = (Folder) getIntent().getParcelableExtra("folder");

        ListView lw = (ListView)findViewById(R.id.listViewEmails);
        ArrayAdapter<Message> arrayAdapter = new ArrayAdapter<Message>(this,android.R.layout.simple_list_item_1,poruke);
        lw.setAdapter(arrayAdapter);*/

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
