package com.example.androidaplikacija;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class EmailsActivity extends AppCompatActivity implements
                                            NavigationView.OnNavigationItemSelectedListener{

    private Button BtnMove1;
    private Button BtnMove2;
    private Button BtnMove3;
    private Button BtnMove4;
    private Button BtnMove5;
    private Button BtnMove6;
    private Button BtnMove7;
    private Button BtnMove8;
    private Button BtnMove9;
    private Button BtnMove10;

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

        BtnMove1 = findViewById(R.id.btnContact);
        BtnMove2 = findViewById(R.id.btnContacts);
        BtnMove3 = findViewById(R.id.btnCreateFolder);
        BtnMove4 = findViewById(R.id.btnSettings);
        BtnMove5 = findViewById(R.id.btnFolders);
        BtnMove6 = findViewById(R.id.btnCreateContact);
        BtnMove7 = findViewById(R.id.btnCreateEmail);
        BtnMove8 = findViewById(R.id.btnEmail);
        BtnMove9 = findViewById(R.id.btnFolder);
        BtnMove10 = findViewById(R.id.btnProfile);

        BtnMove1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToContactActivity();
            }
        });

        BtnMove2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToContactsActivity();
            }
        });

        BtnMove3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToCreateFolderActivity();
            }
        });

        BtnMove4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToSettingsActivity();
            }
        });

        BtnMove5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToFoldersActivity();
            }
        });

        BtnMove6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MoveToCreateContactActivity();
            }
        }) ;

        BtnMove7.setOnClickListener(new  View.OnClickListener(){
            public  void onClick(View v){
                MoveToCreateEmailActivity();
            }
        });

        BtnMove8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                MoveToEmailActivity();
            }
        });

        BtnMove9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToFolderActivity();
            }
        });

        BtnMove10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToProfileActivity();
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id =item.getItemId();

        if(id == R.id.nav_home) {
            Intent intent = new Intent(this, EmailsActivity.class);
            startActivity(intent);
        } else if(id == R.id.nav_mails){
            Intent intent = new Intent(this,EmailsActivity.class);
            startActivity(intent);

        } else if(id == R.id.nav_contacts){
            Intent intent = new Intent(this, ContactsActivity.class);
            startActivity(intent);

        }else if(id == R.id.nav_folder){
            Intent intent = new Intent(this, FoldersActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_settings){


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

        return super.onOptionsItemSelected(item);
    }



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
