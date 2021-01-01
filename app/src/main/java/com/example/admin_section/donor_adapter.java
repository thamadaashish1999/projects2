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
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

public class donor_adapter  extends FirebaseRecyclerAdapter <model_donor,donor_adapter.myviewholder> {

    public donor_adapter(@NonNull FirebaseRecyclerOptions<model_donor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull donor_adapter.myviewholder holder, final int position, @NonNull model_donor model) {

        holder.donor_name.setText(model.getDonor_name());
        holder.profession.setText(model.getProfession());
        holder.email.setText(model.getEmail());

        //edit operation for donor section

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  final DialogPlus dialogPlus = DialogPlus.newDialog(holder.donor_name.getContext())
                          .setContentHolder(new ViewHolder(R.layout.edit_dialog_context))
                          .setExpanded(true,2100)
                          .create();
                  View myview = dialogPlus.getHolderView();

                EditText Purl =  myview.findViewById(R.id.imgURL);
                EditText name =  myview.findViewById(R.id.Name);
                EditText email =  myview.findViewById(R.id.email);
                EditText password =  myview.findViewById(R.id.password);

                EditText phone =  myview.findViewById(R.id.phone);
                EditText Profession =  myview.findViewById(R.id.profession);
                EditText status =  myview.findViewById(R.id.status);
                EditText thumburl =  myview.findViewById(R.id.thumburl);

                Button update = myview.findViewById(R.id.update);

                ////you left here (you want to add a getter and setter of all edit fields and write here)

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

        TextView donor_name,profession,email;
        ImageView delete,edit;

        public myviewholder(@NonNull View itemView){

            super(itemView);
            donor_name=(TextView)itemView.findViewById(R.id.NGOs_Lists_txt);
            profession=(TextView)itemView.findViewById(R.id.profession);
            email = (TextView)itemView.findViewById(R.id.Email);

            edit = (ImageView) itemView.findViewById(R.id.edit_donor);
            delete = (ImageView) itemView.findViewById(R.id.delete_donor);
        }



    }
}
