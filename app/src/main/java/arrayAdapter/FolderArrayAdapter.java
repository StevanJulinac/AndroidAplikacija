package arrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidaplikacija.R;

import java.util.ArrayList;

import klase.Folder;
import klase.Message;


public class FolderArrayAdapter extends ArrayAdapter<Folder> {

    private Context mcon;
    private LayoutInflater mInflater;

    public FolderArrayAdapter(Context context, ArrayList<Folder> folders) {
        super(context, 0, folders);
        mcon = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Folder folder = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.folder_arrayadapter, parent, false);
        }
        TextView aaID = (TextView) convertView.findViewById(R.id.aaID);
        TextView aaIme = (TextView) convertView.findViewById(R.id.aaIme);

        aaID.setText(folder.getId());
        aaIme.setText(folder.getName());



        return convertView;
    }

}
