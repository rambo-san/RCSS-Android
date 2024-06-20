package com.example.finallyjava;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView tv1 = (TextView)findViewById(R.id.t1);
        TextView tv2 = (TextView)findViewById(R.id.t2);
        TextView tv3 = (TextView)findViewById(R.id.t3);
        TextView tv4 = (TextView)findViewById(R.id.t4);
        TextView tv5 = (TextView)findViewById(R.id.t5);
        TextView tv6 = (TextView)findViewById(R.id.t6);
        TextView tv7 = (TextView)findViewById(R.id.t7);
        TextView tv8 = (TextView)findViewById(R.id.t8);
        TextView tv9 = (TextView)findViewById(R.id.t9);
        TextView tv10 = (TextView)findViewById(R.id.t10);

        Calendar c= Calendar.getInstance();
        SimpleDateFormat s=new SimpleDateFormat("dd.mm.yyyy");
        String time= s.format(c.getTime());
        tv1.setText(time.toString());
        s=new SimpleDateFormat("dd.mm.yyyy HH:mm:ss");
        time= s.format(c.getTime());
        tv2.setText(time.toString());
        s=new SimpleDateFormat("EEEE");
        time= s.format(c.getTime());
        tv3.setText(time.toString());
        s=new SimpleDateFormat("E");
        time= s.format(c.getTime());
        tv4.setText(time.toString());
        tv5.setText(time.toString());
        tv6.setText(time.toString());
        tv7.setText(time.toString());
        tv8.setText(time.toString());
        tv9.setText(time.toString());
        tv10.setText(time.toString());
        Toast.makeText(MainActivity.this, "Hello Bro", Toast.LENGTH_LONG).show();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}