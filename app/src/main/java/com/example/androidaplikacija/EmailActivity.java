package com.example.androidaplikacija;

import java.text.DateFormat;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

import klase.Contact;
import klase.Message;
import placeholder.MessagePlaceHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresApi(api = Build.VERSION_CODES.O)
public class EmailActivity extends AppCompatActivity {

    Message poruka = new Message();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.email_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.reply:
                Toast.makeText(EmailActivity.this,
                        "Replied", Toast.LENGTH_SHORT).show();
                return true;

            case  R.id.delete:
                Intent intent = new Intent(this, EmailsActivity.class);
                startActivity(intent);
                return true;

            case R.id.reply_to_all:
                Toast.makeText(EmailActivity.this,
                        "Replied to all", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.forward:
                Toast.makeText(EmailActivity.this,
                        "Forwarded", Toast.LENGTH_SHORT).show();
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
        Intent intent = getIntent();
        String id = intent.getStringExtra("message");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.47:8080/RestService/messageservice/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MessagePlaceHolder messagePlaceHolder = retrofit.create(MessagePlaceHolder.class);

        Call<Message> call = messagePlaceHolder.getMessage(id);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if(!response.isSuccessful()){
                    return;
                }
                poruka = response.body();
                Toast.makeText(EmailActivity.this,poruka.toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {

            }
        });

        //Toast.makeText(EmailActivity.this,poruka.getFrom().toString(),Toast.LENGTH_SHORT).show();
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");


        TextView txtContent = (TextView)findViewById(R.id.txtView_emailContent);
        txtContent.setText(poruka.getContent());

        TextView txtTitle = (TextView)findViewById(R.id.txtView_emailTitleID);
        txtTitle.setText(poruka.getSubject());

        TextView txtSender = (TextView)findViewById(R.id.txtView_emailSenderID);
        //txtTitle.setText(poruka.getTo().getFirstName());

        TextView txtReceiver = (TextView)findViewById(R.id.txtView_emailReceiver);
        //txtReceiver.setText(poruka.getFrom().getFirstName());

        TextView txtDateTime = (TextView)findViewById(R.id.txtView_dateTImeID);
        //String strDate = dateFormat.format(poruka.getDatumVreme());
        //txtDateTime.setText(strDate);

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
