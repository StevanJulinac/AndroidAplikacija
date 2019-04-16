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

import klase.Contact;

public class ContactActivity extends AppCompatActivity {

    Contact kontakt1 = new Contact("1","Marko","Markovic","Blabalba","@markomarkovic@email.com","1");

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
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        EditText txtContact = (EditText) findViewById(R.id.insert_ContactID);
        txtContact.setText(kontakt1.getDisplay());

        EditText txtFirstName = (EditText) findViewById(R.id.insert_firstName);
        txtFirstName.setText(kontakt1.getFirstName());

        EditText txtLastName = (EditText) findViewById(R.id.insert_lastName);
        txtLastName.setText(kontakt1.getLastName());

        EditText txtEmail = (EditText) findViewById(R.id.insert_email);
        txtEmail.setText(kontakt1.getEmail());



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
