package com.example.admin_section;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class donor_list extends AppCompatActivity {

    Toolbar toolbar_donor; //variable for Toolbar
    RecyclerView recview_donor; //variable for recycler view
    private DatabaseReference mUsersDatabase; //firebase variable


    donor_adapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_list);

        /*-------------------Hooks and other stuff for back button--------------------------------*/
        toolbar_donor = findViewById(R.id.toolbar_donor);

        setSupportActionBar(toolbar_donor);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /*---------------------Hooks and other stuff for back button------------------------------*/
        recview_donor = (RecyclerView)findViewById(R.id.recview_donor);
        recview_donor.setLayoutManager(new LinearLayoutManager(this));
        /*----------------------------------------------------------------------------------------*/

        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("Donor");

        FirebaseRecyclerOptions<model_donor> options =
                new FirebaseRecyclerOptions.Builder<model_donor>()
                        .setQuery(mUsersDatabase,model_donor.class)
                        .setLifecycleOwner(this)
                        .build();

          Adapter = new donor_adapter(options);
            recview_donor.setAdapter(Adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Adapter.stopListening();
    }

    /*------------------back button in appbar--------------------------*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}