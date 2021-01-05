package com.example.admin_section;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup_page extends AppCompatActivity {

    //Variables
    TextInputLayout firstname,lastname,phone,email,username,password;


    FirebaseDatabase rootnode;
    DatabaseReference reference;


    Button signin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);


        //Hooks for variables
        firstname=findViewById(R.id.first_name);
        lastname=findViewById(R.id.last_name);
        phone=findViewById(R.id.Phone);
        email=findViewById(R.id.Email);
        username=findViewById(R.id.Username);
        password=findViewById(R.id.Password);

        signin=(Button)findViewById(R.id.SIGNIN);


        //Save data in Firebase on button click
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootnode=FirebaseDatabase.getInstance();
                reference=rootnode.getReference().child("Users").child("Admin") ;

                //get all details from signup page

                String admfirst=firstname.getEditText().getText().toString();
                String admlast=lastname.getEditText().getText().toString();
                String admphone=phone.getEditText().getText().toString();
                String admemail=email.getEditText().getText().toString();
                String admusername=username.getEditText().getText().toString();
                String admpassword=password.getEditText().getText().toString();

                firebase_store firebaseStore = new firebase_store(admfirst,admlast,admphone,admpassword,admusername,admemail);
                reference.child(admusername).setValue(firebaseStore);

                Toast.makeText(signup_page.this,"DONE !!",Toast.LENGTH_LONG);

            }
        });

    }
}