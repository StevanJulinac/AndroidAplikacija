package com.example.androidaplikacija;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmailsActivity extends AppCompatActivity {

    private Button BtnMove1;
    private Button BtnMove2;
    private Button BtnMove3;
    private Button BtnMove4;
    private Button BtnMove5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails);

        BtnMove1 = findViewById(R.id.btnContact);
        BtnMove2 = findViewById(R.id.btnContacts);
        BtnMove3 = findViewById(R.id.btnCreateFolder);
        BtnMove4 = findViewById(R.id.btnSettings);
        BtnMove5 = findViewById(R.id.btnFolders);

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
                MoveToCreateFolderAcitivity();
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

    }

    private void MoveToContactActivity(){
        Intent intent = new Intent(EmailsActivity.this, ContactActivity.class);
        startActivity(intent);
    }

    private void MoveToContactsActivity(){
        Intent intent = new Intent(EmailsActivity.this, ContactsActivity.class);
        startActivity(intent);
    }

    private void MoveToCreateFolderAcitivity(){
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
