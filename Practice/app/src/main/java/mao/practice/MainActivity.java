package mao.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public void onClick(View v){
        TextView tv = (TextView) findViewById(R.id.aa);
       // Log.d(TAG,"I am outside!!!!" );

       // Log.d(TAG,tv.getText().toString() );
        if(tv.getText().toString().equals("Liwei Mao")){
           // Log.d(TAG,"I am inside!!!!" );
            tv.setText("Elisa Mao");
        }else if(tv.getText().toString().equals("Elisa Mao")){
            tv.setText("Liwei Mao");
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
