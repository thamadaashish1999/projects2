package com.example.admin_section;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.dialog.plus.ui.DialogPlus;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.orhanobut.dialogplus.ViewHolder;


public class charity_adapter extends FirebaseRecyclerAdapter <model_charity,charity_adapter.myviewholder> {

    public charity_adapter(@NonNull FirebaseRecyclerOptions<model_charity> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder,final  int position, @NonNull model_charity model) {

            holder.charity_name.setText(model.getCharity_name());
            holder.charityReg.setText(model.getCharityReg());
            holder.email.setText(model.getEmail());

            

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_charity,parent,false);
        return new myviewholder(view);
    }



    class myviewholder extends RecyclerView.ViewHolder{

        TextView charityReg,charity_name,email;
        ImageView edit,delete;
        public myviewholder(@NonNull View itemView){

            super(itemView);
            charityReg=(TextView)itemView.findViewById(R.id.register_number);
            charity_name=(TextView)itemView.findViewById(R.id.NGOs_Lists_txt);
            email = (TextView)itemView.findViewById(R.id.Email);


            edit=(ImageView)itemView.findViewById(R.id.edit_donor);
            delete=(ImageView)itemView.findViewById(R.id.delete_donor);
        }



        }
    }

