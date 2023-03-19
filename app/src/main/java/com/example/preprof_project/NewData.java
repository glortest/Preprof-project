package com.example.preprof_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_activity);
        EditText e1 = findViewById(R.id.newsh);
        EditText e2= findViewById(R.id.newlength);
        //pointActual s = e1 c = e2
        Button b2 = findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(NewData.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}