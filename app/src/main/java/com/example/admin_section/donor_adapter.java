package com.example.admin_section;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class donor_adapter  extends FirebaseRecyclerAdapter <model_donor,donor_adapter.myviewholder> {

    public donor_adapter(@NonNull FirebaseRecyclerOptions<model_donor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull donor_adapter.myviewholder holder, int position, @NonNull model_donor model) {

        holder.donor_name.setText(model.getDonor_name());
        holder.profession.setText(model.getProfession());
        holder.email.setText(model.getEmail());
    }




    @NonNull
    @Override
    public donor_adapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_donor,parent,false);
        return new donor_adapter.myviewholder(view);
    }



    class myviewholder extends RecyclerView.ViewHolder{

        TextView donor_name,profession,email;
        public myviewholder(@NonNull View itemView){

            super(itemView);
            donor_name=(TextView)itemView.findViewById(R.id.NGOs_Lists_txt);
            profession=(TextView)itemView.findViewById(R.id.profession);
            email = (TextView)itemView.findViewById(R.id.Email);
        }



    }
}
