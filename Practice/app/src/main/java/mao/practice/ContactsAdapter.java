package mao.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by c_lmao on 6/1/2016.
 */
public class ContactsAdapter extends ArrayAdapter<Contacts> {

    private static class ViewHolder{
        TextView contact_name;
    }

    public ContactsAdapter(Context context, ArrayList<Contacts> contacts){
        super(context,0,contacts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Contacts contact = getItem(position);
        ViewHolder viewHolder;

        if(convertView == null) {
           // convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_contact, parent, false);
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_contact,parent,false);
            viewHolder.contact_name = (TextView) convertView.findViewById(R.id.contact_name);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.contact_name.setText(contact.name);

        //TextView contact_name = (TextView) convertView.findViewById(R.id.contact_name);
        //contact_name.setText(contact.name);

        return convertView;
    }
}
