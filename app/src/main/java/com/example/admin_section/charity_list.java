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

public class charity_list extends AppCompatActivity {

    private Toolbar toolbar; //variable for Toolbar
    private RecyclerView recview_charity; //variable for recycler view
    private DatabaseReference mUsersDatabase; // firebase variable

    charity_adapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charity_list);

        /*-------------------Hooks and other stuff for back button--------------------------------*/
        toolbar = findViewById(R.id.toolbar_charity);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /*---------------------Hooks and other stuff for back button------------------------------*/
        recview_charity = (RecyclerView)findViewById(R.id.recview_charity);
        recview_charity.setLayoutManager(new LinearLayoutManager(this));
        /*----------------------------------------------------------------------------------------*/

        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child("Charity");



        FirebaseRecyclerOptions<model_charity> options =
                new FirebaseRecyclerOptions.Builder<model_charity>()
                        .setQuery(mUsersDatabase,model_charity.class)
                        .setLifecycleOwner(this)
                        .build();

        Adapter = new charity_adapter(options);
        recview_charity.setAdapter(Adapter);

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
    /*------------------------------------------------------------------*/


}
