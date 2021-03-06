package com.example.androidaplikacija;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import arrayAdapter.ContactArrayAdapter;
import klase.Contact;
import klase.Folder;
import klase.Message;
import placeholder.ContactPlaceHolder;
import placeholder.MessagePlaceHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsActivity extends AppCompatActivity
                        implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    ArrayList<Contact> contacts = new ArrayList<Contact>();
    //ArrayList<Contact> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawerLayout);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navMenu);
        navigationView.setNavigationItemSelectedListener(this);

        View mHeadView = navigationView.getHeaderView(0);
        ImageView imgProfile = mHeadView.findViewById(R.id.nav_profile);
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToProfileActivity();

            }
        });


        FloatingActionButton contacts_fab = findViewById(R.id.fab_contacts);
        contacts_fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(ContactsActivity.this,
                        "New contact", Toast.LENGTH_SHORT).show();
                MoveToCreateContactActivity();
            }
        });

        //Button contact_btn = findViewById(R.id.btn_);
        /*contact_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MoveToContactActivity();
            }
        });*/


        //contacts.add(new Contact("0","Milan","Julinac","display1","milanjulinac996@gmail.com","123","slika1"));
       // contacts.add(new Contact("1","Dude","Hasg","display2","DudeHASG@gmail.com","123","slika1"));
       // contacts.add(new Contact("2","Guy","Joqwe","display4","GUYGUY99@gmail.com","123","slika1"));
       // contacts.add(new Contact("3","Man","Cann","display5","MANCANN@gmail.com","123","slika1"));
        //contacts.add(new Contact("0","Idjit","Profl","display6","IDJIT96@gmail.com","123","slika1"));
        //contacts.add(new Contact("0","Someone","Poet","display7","SOMEONPO@gmail.com","123","slika1"));
       // contacts.add(new Contact("0","Me","Igrow","display8","IGROWME@gmail.com","123","slika1"));
       // contacts.add(new Contact("0","You","Huehue","display9","HUEHUEHUE@gmail.com","123","slika1"));




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contacts_menu, menu);
        return true;
    }

    private  void MoveToProfileActivity(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    private  void MoveToContactActivity(){
        Intent intent = new Intent(this, ContactActivity.class);
        startActivity(intent);
    }

    private void MoveToCreateContactActivity(){
        Intent intent = new Intent(this, CreateContactActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id =item.getItemId();

       if(id == R.id.nav_mails){
            Intent intent = new Intent(this,EmailsActivity.class);
            startActivity(intent);

        } else if(id == R.id.nav_contacts){
            Intent intent = new Intent(this, ContactsActivity.class);
            startActivity(intent);

        }else if(id == R.id.nav_folder){
            Intent intent = new Intent(this, FoldersActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_settings){
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_logout){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();
            Intent intent = new Intent (this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
      }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        switch (item.getItemId()) {
            case  R.id.new_contact:
                Intent intent = new Intent(this, CreateContactActivity.class);
                startActivity(intent);

            default:
        return super.onOptionsItemSelected(item);
    }}



    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.47:8080/RestService/contactservice/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactPlaceHolder contactPlaceHolder = retrofit.create(ContactPlaceHolder.class);

        Call<ArrayList<Contact>> call = contactPlaceHolder.getContacts();
        call.enqueue(new Callback<ArrayList<Contact>>() {
            @Override
            public void onResponse(Call<ArrayList<Contact>> call, Response<ArrayList<Contact>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                contacts = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<Contact>> call, Throwable t) {
                return;
            }
        });


        ContactArrayAdapter contactAdapter = new ContactArrayAdapter(this, contacts);

        ListView listView = (ListView) findViewById(R.id.listContacts);
        listView.setAdapter(contactAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact kontakt = (Contact) parent.getItemAtPosition(position);
                Intent intent  = new Intent(ContactsActivity.this, ContactActivity.class);
                intent.putExtra("contact",kontakt.getId());
                startActivity(intent);

            }
        });



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
