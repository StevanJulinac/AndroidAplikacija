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

public class CreateEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_email);

    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create_email_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {

         String email;
         EditText email_txt = findViewById(R.id.editTextTo);

        switch (item.getItemId()) {

            case R.id.send:
                email = email_txt.getText().toString();
                if (isValidEmail(email)) {
                    Toast.makeText(CreateEmailActivity.this,
                            "Successfully sent", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, EmailsActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(CreateEmailActivity.this,
                            "Invalid recipient address", Toast.LENGTH_SHORT).show();
                }
                return true;

            case  R.id.cancel:
                Intent intent = new Intent(this, EmailsActivity.class);
                startActivity(intent);
                finish();
                return true;

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
