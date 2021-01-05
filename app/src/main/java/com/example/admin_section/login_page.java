package com.example.admin_section;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class login_page extends AppCompatActivity {

    private Button SignUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        SignUP=(Button)findViewById(R.id.signUP);

        SignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
                Toast.makeText(login_page.this,"DONE !!",Toast.LENGTH_SHORT);
            }
        });
    }
    public void openActivity2(){
        Intent intent = new Intent(this, signup_page.class);
        startActivity(intent);
    }
    }
