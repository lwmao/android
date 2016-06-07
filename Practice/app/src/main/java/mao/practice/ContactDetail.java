package mao.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ContactDetail extends AppCompatActivity {

    TextView tName,tNum,tEmail;
    DatabaseHelper myDb;
    String id,name,number,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        Intent intent = getIntent();
        id = intent.getStringExtra(ContactList.Extra_id);
        name = intent.getStringExtra(ContactList.Extra_name);
        number = intent.getStringExtra(ContactList.Extra_num);
        email = intent.getStringExtra(ContactList.Extra_email);

        tName = (EditText)findViewById(R.id.name);
        tNum = (EditText)findViewById(R.id.num);
        tEmail = (EditText)findViewById(R.id.email);

        tName.setText(name);
        tNum.setText(number);
        tEmail.setText(email);
    }

    public void updateOnClick(View view){
        myDb = new DatabaseHelper(this);
        boolean isInserted = myDb.updateData(id,tName.getText().toString(),tNum.getText().toString(),tEmail.getText().toString());

        if (isInserted == true)
            Toast.makeText(ContactDetail.this, "Data Updated", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(ContactDetail.this, "Data not Updated", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,ContactList.class);
        startActivity(intent);
    }

    public void deleteOnClick(View view){
        myDb = new DatabaseHelper(this);
        Integer deletedRows = myDb.deleteData(id);

        if (deletedRows > 0 )
            Toast.makeText(ContactDetail.this, "Data Deleted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(ContactDetail.this, "Data not Deleted", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this,ContactList.class);
        startActivity(intent);
    }

}

