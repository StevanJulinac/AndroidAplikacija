package com.example.androidaplikacija;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ContactsActivity extends AppCompatActivity
                        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
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
            }
        });

        Button contact_btn = findViewById(R.id.btn_contacts);
        contact_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MoveToContactActivity();
            }
        });

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
