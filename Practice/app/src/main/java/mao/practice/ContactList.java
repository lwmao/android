package mao.practice;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContactList extends AppCompatActivity {
    DatabaseHelper myDb;
    Contacts contact;
    ArrayList<Contacts> contacts;
    ContactsAdapter adapter;

    private static final String TAG = "DEBUG";
    public final static String Extra_id = "id";
    public final static String Extra_name = "name";
    public final static String Extra_num = "num";
    public final static String Extra_email = "email";

   // public void itemOnClick(View view){
     //   showMessage("hello","you're awesome!");
    //}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        myDb = new DatabaseHelper(this);
        contacts = new ArrayList<Contacts>();
        adapter = new ContactsAdapter(this, contacts);

        createContacts();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        final Intent intent = new Intent(this,ContactDetail.class);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("position: " + position," .");
                contact = contacts.get(position);

                intent.putExtra(Extra_id,contact.ID);
                intent.putExtra(Extra_name,contact.name);
                intent.putExtra(Extra_email,contact.email);
                intent.putExtra(Extra_num,contact.number);
                startActivity(intent);
                //showMessage(contact.name,contact.email);
            }

        });


    }

    public void createContacts(){
        Cursor res = myDb.getAllData();

        if(res.getCount() == 0){
            showMessage("Error", "Nothing found");
            return;
        }

        //StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            contact = new Contacts(res.getString(0),res.getString(1),res.getString(2),res.getString(3));
            contacts.add(contact);
            Log.v(TAG, contact.get_ID());
        }
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
