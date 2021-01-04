package com.example.admin_section;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup_page extends AppCompatActivity {

    //Variables
    TextInputLayout first_name,last_name,phone,email,username,password;


    FirebaseDatabase rootnode;
    DatabaseReference reference;


    Button signin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);


        //Hooks for variables
        first_name=findViewById(R.id.firstname);
        last_name=findViewById(R.id.lastname);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);



        //Save data in Firebase on button click
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootnode=FirebaseDatabase.getInstance();
                reference=rootnode.getReference().child("Users").child("Admin");

                //get all details from signup page

                String admin_firstname=first_name.getEditText().getText().toString();
                String admin_lastname=last_name.getEditText().getText().toString();
                String admin_phone=phone.getEditText().getText().toString();
                String admin_email=email.getEditText().getText().toString();
                String admin_username=username.getEditText().getText().toString();
                String admin_password=password.getEditText().getText().toString();

                signup_save_data_in_fire signup_save_data_in_fire = new signup_save_data_in_fire(admin_firstname,admin_lastname,admin_phone,admin_email,admin_username,admin_password);
                reference.child(admin_username).setValue(signup_save_data_in_fire);

            }
        });

    }
}