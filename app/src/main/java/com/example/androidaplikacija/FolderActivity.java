package com.example.androidaplikacija;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import klase.Contact;
import klase.Folder;
import klase.Message;

public class FolderActivity extends AppCompatActivity {
    Contact kontakt1 = new Contact("1","Marko","Markovic","1","1","1");
    Contact kontakt2 = new Contact("2","Pera","Peric","1","1","1");
    ArrayList<Message> poruke = new ArrayList<Message>();
    Message poruka1 = new Message("a","aa", Calendar.getInstance().getTime(),kontakt1,kontakt2);
    Message poruka2 = new Message("b","bb", Calendar.getInstance().getTime(),kontakt1,kontakt2);
    Message poruka3 = new Message("v","vv", Calendar.getInstance().getTime(),kontakt1,kontakt2);
    Message poruka4 = new Message("g","gg", Calendar.getInstance().getTime(),kontakt1,kontakt2);
    Message poruka5 = new Message("d","dd", Calendar.getInstance().getTime(),kontakt1,kontakt2);


    Folder folder1 = new Folder("1","moj prvi folder","");

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

        poruke.add(poruka1);
        poruke.add(poruka2);
        poruke.add(poruka3);
        poruke.add(poruka4);
        poruke.add(poruka5);

        TextView folderName = (TextView)findViewById(R.id.folderId);
        folderName.setText(folder1.getName());

        ListView lw = (ListView)findViewById(R.id.listViewEmails);
        ArrayAdapter<Message> arrayAdapter = new ArrayAdapter<Message>(this,android.R.layout.simple_list_item_1,poruke);
        lw.setAdapter(arrayAdapter);

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
