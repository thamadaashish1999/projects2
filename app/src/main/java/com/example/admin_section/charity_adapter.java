package com.example.admin_section;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.ViewHolder;


public class charity_adapter extends FirebaseRecyclerAdapter <model_charity,charity_adapter.myviewholder> {

    public charity_adapter(@NonNull FirebaseRecyclerOptions<model_charity> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final  myviewholder holder,final  int position, @NonNull final model_charity model) {

            holder.charity_name.setText(model.getCharity_name());
            holder.charityReg.setText(model.getCharityReg());
            holder.email.setText(model.getEmail());


            //edit operation for charity section





            //delete operation for charity section

        holder.delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.charity_name.getContext());
                builder.setTitle("Delete charity");
                builder.setMessage("Are you sure ?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Users").child("Charity").child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_charity,parent,false);
        return new myviewholder(view);
    }



    class myviewholder extends RecyclerView.ViewHolder{

        TextView charityReg,charity_name,email,charity_address,description,image,password,phone,post_description,post_image,requirements,status,thumb_image;
        ImageView delete1,edit1;
        public myviewholder(@NonNull View itemView){

            super(itemView);
            charityReg=(TextView)itemView.findViewById(R.id.register_number);
            charity_name=(TextView)itemView.findViewById(R.id.NGOs_Lists_txt);
            email = (TextView)itemView.findViewById(R.id.Email);
            charity_address = (TextView)itemView.findViewById(R.id.addresss);
            description = (TextView)itemView.findViewById(R.id.descriptionn);
            image = (TextView)itemView.findViewById(R.id.imagee);
            password = (TextView)itemView.findViewById(R.id.passwordd);
            phone = (TextView)itemView.findViewById(R.id.phonee);
            post_description = (TextView)itemView.findViewById(R.id.post_descriptionn);
            post_image = (TextView)itemView.findViewById(R.id.post_imagee);
            requirements = (TextView)itemView.findViewById(R.id.requirementt);
            status = (TextView)itemView.findViewById(R.id.statuss);
            thumb_image = (TextView)itemView.findViewById(R.id.thumb_imagee);



            delete1=(ImageView)itemView.findViewById(R.id.delete_charity);
            edit1=(ImageView)itemView.findViewById(R.id.edit_charity);
        }



        }
    }

