package com.example.preprof_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt1 = (Button) findViewById(R.id.button1);
        TextView t1 = findViewById(R.id.textView2);
        t1.setText("1");
        TextView t2 = findViewById(R.id.textView4);
        t2.setText("1");
        TextView t3 = findViewById(R.id.textView6);
        t3.setText("1");
        TextView t4 = findViewById(R.id.textView8);
        t4.setText("1");
        TextView t5 = findViewById(R.id.textView10);
        t5.setText("1");
        TextView t6 = findViewById(R.id.textView12);
        t6.setText("1");
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, NewData.class);
                startActivity(intent);
            }
        });

    }
}