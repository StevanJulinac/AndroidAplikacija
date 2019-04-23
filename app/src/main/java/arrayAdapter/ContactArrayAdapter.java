package arrayAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidaplikacija.ContactActivity;
import com.example.androidaplikacija.ContactsActivity;
import com.example.androidaplikacija.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import klase.Contact;

public class ContactArrayAdapter extends ArrayAdapter<Contact> {

    private Context mcon;
    private LayoutInflater mInflater;

    public ContactArrayAdapter(Context context,ArrayList<Contact> contacts){
        super(context,0,contacts);
        mcon = context;
        mInflater = LayoutInflater.from(context);

    }



   /* @Override
    public void onClick(View v){
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        Contact contact =(Contact)object;

        mcon.startActivity(new Intent(mcon, ContactActivity.class));
        // Intent intent  = new Intent(activity, ContactActivity.class);
        //intent.putExtra("contact",contact);
        // activity.startActivity(intent);
    }*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Contact contact = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contact_arrayadapter, parent, false);
        }
        TextView aaFirstName = (TextView) convertView.findViewById(R.id.aaFirstName);
        TextView aaLastName = (TextView) convertView.findViewById(R.id.aaLastName);
        TextView aaEmail = (TextView) convertView.findViewById(R.id.aaEmail);
        TextView aaDisplay = (TextView) convertView.findViewById(R.id.aaDisplay);

        aaFirstName.setText(contact.getFirstName());
        aaLastName.setText(contact.getLastName());
        aaDisplay.setText(contact.getDisplay());
        aaEmail.setText(contact.getEmail());



        return convertView;
    }


    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contact kontakt = (Contact) parent.getItemAtPosition(position);
        mcon.startActivity(new Intent(mcon, ContactActivity.class));
       // position=(Integer) view.getTag();
        //Object object= getItem(position);
       // Contact contact =(Contact)object;
    }*/
}
