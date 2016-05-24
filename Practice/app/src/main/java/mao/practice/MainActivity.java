package mao.practice;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    public final static String EXTRA_name = "";
    public final static String EXTRA_num = "";

    public void viewOnClick(View v){
        //for now just hard code the database
        Intent intent = new Intent(this, PhoneBook.class);

        TextView name = (TextView) findViewById(R.id.name);
        TextView num = (TextView) findViewById(R.id.number);

        String nameToSave = name.getText().toString();
        String numToSave = num.getText().toString();

        intent.putExtra(EXTRA_name, nameToSave);
        intent.putExtra(EXTRA_num,numToSave);

        startActivity(intent);
    }
    public void saveOnClick(View v){
        //AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
