package com.example.androidaplikacija;

import android.app.Activity;
import android.content.Intent;
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
import java.util.Date;

import arrayAdapter.ContactArrayAdapter;
import arrayAdapter.EmailArrayAdapter;
import klase.Contact;
import klase.Message;

public class EmailsActivity extends AppCompatActivity implements
                                            NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails);


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




        FloatingActionButton emails_fab = findViewById(R.id.fab_emails);
        emails_fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(EmailsActivity.this,
                        "New email", Toast.LENGTH_SHORT).show();
            }
        });

        final ArrayList<Message> emails = new ArrayList<Message>();
        Contact kontakt1 = new Contact("0","Milan","Julinac","displaty1","milanjulinac996@gmail.com","123","slika1");
        Contact kontakt2 = new Contact("0","Stevan","Julinac","displaty1","milanjulinac996@gmail.com","123","slika1");
        emails.add(new Message("012", kontakt1, kontakt2, new ArrayList<Contact>(), new ArrayList<Contact>(), new Date(), "Subject1", "content", null, null, null, null));
        emails.add(new Message("012", kontakt2, kontakt1, new ArrayList<Contact>(), new ArrayList<Contact>(), new Date(), "Subject2", "content", null, null, null, null));
        emails.add(new Message("012", kontakt1, kontakt2, new ArrayList<Contact>(), new ArrayList<Contact>(), new Date(), "Subject3", "content", null, null, null, null));

        EmailArrayAdapter emailAdapter = new EmailArrayAdapter(this, emails);

        ListView listView = (ListView) findViewById(R.id.listEmails);
        listView.setAdapter(emailAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Message poruka = (Message) parent.getItemAtPosition(position);

                Intent intent  = new Intent(EmailsActivity.this, EmailActivity.class);
                intent.putExtra("message",poruka);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.emails_menu, menu);
        return true;
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
            Intent intent = new Intent(this,SettingsActivity.class);
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

            case R.id.filter:
                Toast.makeText(EmailsActivity.this,
                        "Filter", Toast.LENGTH_SHORT).show();
                return true;

            case  R.id.new_email:
                Intent intent = new Intent(this, CreateEmailActivity.class);
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

    private  void MoveToProfileActivity(){
        Intent intent = new Intent(EmailsActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    private void MoveToFolderActivity(){
        Intent intent = new Intent(EmailsActivity.this, FolderActivity.class);
        startActivity(intent);
    }

    private  void MoveToEmailActivity(){
        Intent intent = new Intent(EmailsActivity.this, EmailActivity.class);
        startActivity(intent);
    }

    private  void MoveToCreateEmailActivity(){
        Intent intent = new Intent(EmailsActivity.this, CreateEmailActivity.class);
        startActivity(intent);
    }

    private void MoveToCreateContactActivity() {
        Intent intent = new Intent(EmailsActivity.this, CreateContactActivity.class);
        startActivity(intent);
    }

    private void MoveToContactActivity(){
        Intent intent = new Intent(EmailsActivity.this, ContactActivity.class);
        startActivity(intent);
    }

    private void MoveToContactsActivity(){
        Intent intent = new Intent(EmailsActivity.this, ContactsActivity.class);
        startActivity(intent);
    }

    private void MoveToCreateFolderActivity(){
        Intent intent = new Intent(EmailsActivity.this,CreateFolderActivity.class);
        startActivity(intent);
    }

    private void MoveToSettingsActivity(){
        Intent intent = new Intent(EmailsActivity.this,SettingsActivity.class);
        startActivity(intent);
    }

    private void MoveToFoldersActivity(){
        Intent intent = new Intent(EmailsActivity.this,FoldersActivity.class);
        startActivity(intent);
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
