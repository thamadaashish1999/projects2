package com.example.admin_section;

import android.app.AlertDialog;
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

public class donor_adapter  extends FirebaseRecyclerAdapter <model_donor,donor_adapter.myviewholder> {

    public donor_adapter(@NonNull FirebaseRecyclerOptions<model_donor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull donor_adapter.myviewholder holder, final int position, @NonNull model_donor model) {

        holder.donor_name.setText(model.getDonor_name());
        holder.profession.setText(model.getProfession());
        holder.email.setText(model.getEmail());
        holder.image.setText(model.getImage());
        holder.password.setText(model.getPassword());
        holder.phone.setText(model.getPhone());
        holder.status.setText(model.getStatus());
        holder.thumb_image.setText(model.getThumb_image());


        //edit operation for donor section

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  final DialogPlus dialogPlus = DialogPlus.newDialog(holder.donor_name.getContext())
                          .setContentHolder(new ViewHolder(R.layout.edit_dialog_context))
                          .setExpanded(true,2100)
                          .create();
                  View myview = dialogPlus.getHolderView();

                EditText image =  myview.findViewById(R.id.imgURL);
                EditText donor_name =  myview.findViewById(R.id.Name);
                EditText email =  myview.findViewById(R.id.email);
                EditText password =  myview.findViewById(R.id.password);

                EditText phone =  myview.findViewById(R.id.phone);
                EditText profession =  myview.findViewById(R.id.profession);
                EditText status =  myview.findViewById(R.id.status);
                EditText thumb_image =  myview.findViewById(R.id.thumburl);


                image.setText(model.getImage());
                donor_name.setText(model.getDonor_name());
                email.setText(model.getEmail());
                password.setText(model.getPassword());
                phone.setText(model.getPhone());
                profession.setText(model.getProfession());
                status.setText(model.getStatus());
                thumb_image.setText(model.getThumb_image());

                dialogPlus.show();

                Button update = myview.findViewById(R.id.update);

                        update.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Map<String,Object> map = new HashMap<>();
                                map.put("image",image.getText().toString());
                                map.put("donor_name",donor_name.getText().toString());
                                map.put("email",email.getText().toString());
                                map.put("password",password.getText().toString());
                                map.put("phone",phone.getText().toString());
                                map.put("profession",profession.getText().toString());
                                map.put("status",status.getText().toString());
                                map.put("thumb_image",thumb_image.getText().toString());

                                FirebaseDatabase.getInstance().getReference().child("Users").child("Donor").child(getRef(position).getKey()).
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



        //delete operation for donor section

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.donor_name.getContext());
                builder.setTitle("Delete Donor");
                builder.setMessage("Are you sure ?");

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("Users").child("Donor").child(getRef(position).getKey()).removeValue();
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
    public donor_adapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_donor,parent,false);
        return new donor_adapter.myviewholder(view);
    }


    //operation  in recyclicView (deleting, fetching, edit)

    class myviewholder extends RecyclerView.ViewHolder{

        TextView donor_name,profession,email,image,password,phone,status,thumb_image;
        ImageView delete,edit;

        public myviewholder(@NonNull View itemView){

            super(itemView);
            donor_name=(TextView)itemView.findViewById(R.id.NGOs_Lists_txt);
            profession=(TextView)itemView.findViewById(R.id.profession);
            email = (TextView)itemView.findViewById(R.id.Email);
            image = (TextView)itemView.findViewById(R.id.imagee);
            password = (TextView)itemView.findViewById(R.id.passwordd);
            phone = (TextView)itemView.findViewById(R.id.phonee);
            status = (TextView)itemView.findViewById(R.id.statuss);
            thumb_image = (TextView)itemView.findViewById(R.id.thumb_imagee);




            edit = (ImageView) itemView.findViewById(R.id.edit_donor);
            delete = (ImageView) itemView.findViewById(R.id.delete_donor);
        }



    }
}
