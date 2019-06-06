package com.example.androidaplikacija;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import klase.Contact;
import placeholder.ContactPlaceHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactActivity extends AppCompatActivity {

    Contact kontakt = new Contact();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contact_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.save:
                    Toast.makeText(ContactActivity.this,
                            "Successfully saved", Toast.LENGTH_SHORT).show();
                    return true;

            case  R.id.back:
            Intent intent = new Intent(this, ContactsActivity.class);
            startActivity(intent);

            default:
            return super.onOptionsItemSelected(item);
    }}


    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();
        String id = intent.getStringExtra("contact");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.47:8080/RestService/contactservice/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ContactPlaceHolder contactPlaceHolder = retrofit.create(ContactPlaceHolder.class);

        Call<Contact> call = contactPlaceHolder.getContact(id);
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                if(!response.isSuccessful()){
                    return;
                }
                kontakt = response.body();
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                return;
            }
        });

        EditText txtContact = (EditText) findViewById(R.id.insert_ContactID);
        txtContact.setText(kontakt.getDisplay());

        EditText txtFirstName = (EditText) findViewById(R.id.insert_firstName);
        txtFirstName.setText(kontakt.getFirstName());

        EditText txtLastName = (EditText) findViewById(R.id.insert_lastName);
        txtLastName.setText(kontakt.getLastName());

        EditText txtEmail = (EditText) findViewById(R.id.insert_email);
        txtEmail.setText(kontakt.getEmail());

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
