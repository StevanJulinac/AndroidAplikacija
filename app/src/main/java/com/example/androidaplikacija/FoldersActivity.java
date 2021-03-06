package com.example.androidaplikacija;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import arrayAdapter.FolderArrayAdapter;
import klase.Folder;
import placeholder.FolderPlaceHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoldersActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    ArrayList<Folder> folders = new ArrayList<Folder>();
    Folder folder1 = new Folder("1","moj prvi folder","");
    Folder folder2 = new Folder("2","moj drugi folder","");
    Folder folder3 = new Folder("3","moj treci folder","");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folders);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFolders);
        setSupportActionBar(toolbar);

        mDrawerLayout = findViewById(R.id.drawerLayoutFolders);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navMenuFolders);
        navigationView.setNavigationItemSelectedListener(this);

        View mHeadView = navigationView.getHeaderView(0);
        ImageView imgProfile = mHeadView.findViewById(R.id.nav_profile);
        imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToProfileActivity();

            }
        });



        FloatingActionButton folders_fab = findViewById(R.id.fab_folders);
        folders_fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(FoldersActivity.this,
                        "New folder", Toast.LENGTH_SHORT).show();
                MoveToCreateFolderActivity();
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.folders_menu, menu);
        return true;
    }

    private  void MoveToProfileActivity(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void MoveToCreateFolderActivity(){
        Intent intent = new Intent(this, CreateFolderActivity.class);
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

        }else if (id == R.id.nav_logout){
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();
            Intent intent = new Intent(this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayoutFolders);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()) {
            case  R.id.new_folder:
                Intent intent = new Intent(this, CreateFolderActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }



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
                .baseUrl("http://192.168.1.47:8080/RestService/folderservice/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FolderPlaceHolder folderPlaceHolder = retrofit.create(FolderPlaceHolder.class);

        Call<ArrayList<Folder>> call = folderPlaceHolder.getFolders();
        call.enqueue(new Callback<ArrayList<Folder>>() {
            @Override
            public void onResponse(Call<ArrayList<Folder>> call, Response<ArrayList<Folder>> response) {
                if(!response.isSuccessful()){
                    return;
                }
                folders = response.body();
                for(Folder f : folders){
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Folder>> call, Throwable t) {
                return;
            }
        });

        FolderArrayAdapter folderAdapter = new FolderArrayAdapter(this, folders);

        ListView listView = (ListView) findViewById(R.id.listViewFolders);
        listView.setAdapter(folderAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Folder folder = (Folder) parent.getItemAtPosition(position);
                Intent intent  = new Intent(FoldersActivity.this, FolderActivity.class);
                intent.putExtra("folder",folder.getId());
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
