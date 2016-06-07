package mao.practice;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Path;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    TextView name,num,email;


    private static final String TAG = MainActivity.class.getSimpleName();
    public final static String EXTRA_name = "";
    public final static String EXTRA_num = "";


    public void view_list_OnClick(View v){
        Intent intent = new Intent(this, ContactList.class);
        startActivity(intent);
    }
    public void view_raw_OnClick(View v){
        //for now just hard code the database
        Cursor res = myDb.getAllData();
        if(res.getCount() ==0){
            //show message
            showMessage("Error", "Nothing found");
            return;
        }
        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){
            buffer.append("ID : "+res.getString(0)+"\n");
            buffer.append("Name : "+res.getString(1)+"\n");
            buffer.append("Number : "+res.getString(2)+"\n");
            buffer.append("Email : "+res.getString(3)+"\n");

        }
        Intent intent = new Intent(this, PhoneBook.class);
        intent.putExtra(EXTRA_name, buffer.toString());
        startActivity(intent);

    }
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
    //What happens whtn Save is clicked
    public void saveOnClick(View v){
        final String enterName = name.getText().toString();
        final String enterNum = num.getText().toString();
        final String enterEmail= email.getText().toString();


        if(enterName.isEmpty()){
            name.setError("Enter username");
            return;
        }
        if(enterNum.isEmpty()){
            num.setError("Enter phone number");
            return;
        }
        if(enterEmail.isEmpty()){
            email.setError("Enter email");
            return;
        }


        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Save the contact?")
                .setMessage("You are about to save the contact")

                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        boolean isInserted = myDb.insertData(enterName,enterNum,enterEmail);

                        if (isInserted = true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create().show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        name = (TextView) findViewById(R.id.name);
        num = (TextView) findViewById(R.id.number);
        email = (TextView) findViewById(R.id.email);

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        android.os.Debug.stopMethodTracing();

    }

}
