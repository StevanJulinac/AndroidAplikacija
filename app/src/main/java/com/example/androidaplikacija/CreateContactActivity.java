package com.example.androidaplikacija;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.androidaplikacija.CreateEmailActivity.isValidEmail;

public class CreateContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create_contact_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.save:

                if (contactValidation()){
                    Toast.makeText(CreateContactActivity.this,
                            "Successfully saved", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, ContactsActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(CreateContactActivity.this,
                            "Invalid entry", Toast.LENGTH_SHORT).show();
                }

                return true;

            case  R.id.cancel_contact:
                Intent intent = new Intent(this, ContactsActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }}

    public boolean contactValidation(){
        String email;
        String contact;

        EditText email_txt = findViewById(R.id.insert_email);
        EditText contact_txt = findViewById(R.id.insert_ContactID);

        contact = contact_txt.getText().toString();
        email = email_txt.getText().toString();

        if (isValidEmail(email) && !TextUtils.isEmpty(contact)){

            return true;

        }else {

            return false;
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
