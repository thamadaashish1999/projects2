package com.example.admin_section;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;


public class charity_adapter extends FirebaseRecyclerAdapter <model_charity,charity_adapter.myviewholder> {

    public charity_adapter(@NonNull FirebaseRecyclerOptions<model_charity> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull final  myviewholder holder,final  int position, @NonNull final model_charity model) {

            holder.charity_name.setText(model.getCharity_name());
            holder.charityReg.setText(model.getCharityReg());
            holder.email.setText(model.getEmail());
            holder.charity_address.setText(model.getCharity_address());
            holder.description.setText(model.getDescription());
            holder.image.setText(model.getImage());
            holder.password.setText(model.getEmail());
            holder.phone.setText(model.getPhone());
            holder.requirements.setText(model.getRequirements());
            holder.status.setText(model.getStatus());
            holder.post_description.setText(model.getPost_description());
            holder.post_image.setText(model.getPost_image());
            holder.thumb_image.setText(model.getPost_image());


            //edit operation for charity section
        holder.edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.charity_name.getContext())
                        .setContentHolder(new ViewHolder(R.layout.edit_dialog_context_charity))
                        .setExpanded(true,2100)
                        .create();
                View myview = dialogPlus.getHolderView();

                EditText image =  myview.findViewById(R.id.imgURL);
                EditText charity_name =  myview.findViewById(R.id.Name);
                EditText email =  myview.findViewById(R.id.email);
                EditText password =  myview.findViewById(R.id.password);

                EditText phone =  myview.findViewById(R.id.phone);
                EditText description =  myview.findViewById(R.id.description);
                EditText status =  myview.findViewById(R.id.status);
                EditText thumb_image =  myview.findViewById(R.id.thumburl);
                EditText charity_address =  myview.findViewById(R.id.address);
                EditText requirement =  myview.findViewById(R.id.requirement);
                EditText post_image =  myview.findViewById(R.id.post_image);
                EditText post_description =  myview.findViewById(R.id.post_description);



                image.setText(model.getImage());
                charity_name.setText(model.getCharity_name());
                email.setText(model.getEmail());
                password.setText(model.getPassword());
                phone.setText(model.getPhone());
                description.setText(model.getDescription());
                status.setText(model.getStatus());
                thumb_image.setText(model.getThumb_image());
                charity_address.setText(model.getCharity_address());
                requirement.setText(model.getRequirements());
                post_image.setText(model.getPost_image());
                post_description.setText(model.getPost_description());



                dialogPlus.show();

                Button update = myview.findViewById(R.id.update);

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("image",image.getText().toString());
                        map.put("charity_name",charity_name.getText().toString());
                        map.put("email",email.getText().toString());
                        map.put("password",password.getText().toString());
                        map.put("phone",phone.getText().toString());
                        map.put("description",description.getText().toString());
                        map.put("status",status.getText().toString());
                        map.put("charity_address",charity_address.getText().toString());
                        map.put("requirement",requirement.getText().toString());
                        map.put("post_image",post_image.getText().toString());
                        map.put("post_description",post_description.getText().toString());
                        map.put("thumb_image",thumb_image.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Users").child("Charity").child(getRef(position).getKey()).
                                updateChildren(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                dialogPlus.dismiss();
                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });

            }
        });





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

