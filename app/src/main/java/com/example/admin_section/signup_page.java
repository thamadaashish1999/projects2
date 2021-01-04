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
    TextInputLayout first_namee,last_namee,phonne,emaiil,usernname,passwword;


    FirebaseDatabase rootnode_admin;
    DatabaseReference reference;


    Button signin_admin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);


        //Hooks for variables
        first_namee=findViewById(R.id.firstname);
        last_namee=findViewById(R.id.lastname);
        phonne=findViewById(R.id.phoneee);
        emaiil=findViewById(R.id.emailll);
        usernname=findViewById(R.id.usernameee);
        passwword=findViewById(R.id.passworddd);



        //Save data in Firebase on button click
        signin_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootnode_admin=FirebaseDatabase.getInstance();
                reference=rootnode_admin.getReference().child("Users").child("Admin") ;

                //get all details from signup page

                String admin_firstname=first_namee.getEditText().getText().toString();
                String admin_lastname=last_namee.getEditText().getText().toString();
                String admin_phone=phonne.getEditText().getText().toString();
                String admin_email=emaiil.getEditText().getText().toString();
                String admin_username=usernname.getEditText().getText().toString();
                String admin_password=passwword.getEditText().getText().toString();

                signup_save_data_in_fire Signup_save_data_in_fire = new signup_save_data_in_fire(admin_firstname,admin_lastname,admin_phone,admin_email,admin_username,admin_password);
                reference.child(admin_username).setValue(Signup_save_data_in_fire);

                Toast.makeText(signup_page.this,"DONE !!",Toast.LENGTH_LONG);

            }
        });

    }
}