package mao.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PhoneBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_book);

        TextView name_textView = (TextView) findViewById(R.id.name);
        TextView num_textView = (TextView) findViewById(R.id.number);

        Intent intent = getIntent();

        String name = intent.getStringExtra(MainActivity.EXTRA_name);
        String num = intent.getStringExtra(MainActivity.EXTRA_num);

        name_textView.setText(name);
        num_textView.setText(num);

    }
}
