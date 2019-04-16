package com.example.androidaplikacija;

import java.text.DateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import klase.Contact;
import klase.Message;

@RequiresApi(api = Build.VERSION_CODES.O)
public class EmailActivity extends AppCompatActivity {

    Contact kontakt1 = new Contact("1","Marko","Markovic","1","1","1");
    Contact kontakt2 = new Contact("2","Pera","Peric","1","1","1");
    Message poruka = new Message("a","b", Calendar.getInstance().getTime(),kontakt1,kontakt2);

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

        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm");

        TextView txtContent = (TextView)findViewById(R.id.txtView_emailContent);
        txtContent.setText(poruka.getContent());

        TextView txtTitle = (TextView)findViewById(R.id.txtView_emailTitleID);
        txtTitle.setText(poruka.getSubject());

        TextView txtSender = (TextView)findViewById(R.id.txtView_emailSenderID);
        txtTitle.setText(poruka.getTo().getFirstName());

        TextView txtReceiver = (TextView)findViewById(R.id.txtView_emailReceiver);
        txtReceiver.setText(poruka.getFrom().getFirstName());

        TextView txtDateTime = (TextView)findViewById(R.id.txtView_dateTImeID);
        String strDate = dateFormat.format(poruka.getDatumVreme());
        txtDateTime.setText(strDate);

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
