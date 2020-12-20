package com.example.admin_section;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class home extends AppCompatActivity {

    /*-------------button variable--------------*/
    private Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /*------just for opening donor activity from button ------*/
        button2 = (Button) findViewById(R.id.donor_list);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });


        /*------just for opening charity activity from button ------*/
        button1 = (Button) findViewById(R.id.charity_list);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });



    }

    /*---------------Function to open donor activity-----------------------------*/
    public void openActivity1() {
        Intent intent = new Intent(this, donor_list.class);
        startActivity(intent);
    }

    /*---------------Function to open charity activity-----------------------------*/
    public void openActivity2() {
        Intent intent = new Intent(this,charity_list.class);
        startActivity(intent);
    }
}