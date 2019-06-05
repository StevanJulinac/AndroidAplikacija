package com.example.androidaplikacija;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import klase.Tag;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    
    private Button BtnMove;

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        final EditText username = (EditText) findViewById(R.id.edit_text_userName);
        final EditText password = (EditText) findViewById(R.id.edit_text_password);

        BtnMove = findViewById(R.id.btnStartEmailsActivity);

        BtnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equals("123") &&
                password.getText().toString().equals("1234")) {
                    moveToEmailsActivity();

                    mEditor.putString("UsernameBRO", username.getText().toString());
                    mEditor.commit();

                    String user = mPreferences.getString("UsernameBRO", "default");
                    Log.d(TAG, "onCreate: name: " + user);
                    finish();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Wrong password or username", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkSharedPreferences(EditText username, EditText password){
        String user = mPreferences.getString(username.getText().toString(), "");
        String pass = mPreferences.getString(password.getText().toString(), "");

    }

    private void moveToEmailsActivity(){
        Intent intent = new Intent(LoginActivity.this, EmailsActivity.class);
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
