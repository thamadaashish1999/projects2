package com.example.admin_section;

import android.app.AlertDialog;
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

public class donor_adapter  extends FirebaseRecyclerAdapter <model_donor,donor_adapter.myviewholder> {

    public donor_adapter(@NonNull FirebaseRecyclerOptions<model_donor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull donor_adapter.myviewholder holder, int position, @NonNull model_donor model) {

        holder.donor_name.setText(model.getDonor_name());
        holder.profession.setText(model.getProfession());
        holder.email.setText(model.getEmail());

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
        ImageView delete;

        public myviewholder(@NonNull View itemView){

            super(itemView);
            donor_name=(TextView)itemView.findViewById(R.id.NGOs_Lists_txt);
            profession=(TextView)itemView.findViewById(R.id.profession);
            email = (TextView)itemView.findViewById(R.id.Email);

            delete = (ImageView) itemView.findViewById(R.id.delete_donor);
        }



    }
}
