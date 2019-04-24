package arrayAdapter;


import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidaplikacija.R;

import java.util.ArrayList;


import klase.Message;

public class EmailArrayAdapter extends ArrayAdapter<Message> {

    private Context mcon;
    private LayoutInflater mInflater;

    public EmailArrayAdapter(Context context, ArrayList<Message> emails) {
        super(context, 0, emails);
        mcon = context;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Message message = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.email_arrayadapter, parent, false);
        }
        TextView aaFrom = (TextView) convertView.findViewById(R.id.aaFrom);
        TextView aaTo = (TextView) convertView.findViewById(R.id.aaTo);
        TextView aaSubject = (TextView) convertView.findViewById(R.id.aaSubject);

        aaFrom.setText(message.getFrom().getFirstName());
        aaTo.setText(message.getTo().getFirstName());
        aaSubject.setText(message.getSubject());



        return convertView;
    }
}