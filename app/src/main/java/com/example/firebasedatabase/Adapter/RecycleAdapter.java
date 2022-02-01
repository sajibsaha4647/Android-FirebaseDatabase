package com.example.firebasedatabase.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebasedatabase.ModelClass.Student;
import com.example.firebasedatabase.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.Myviewholder> {

    Context context;
    ArrayList<Student>StudentArrayList;
    DatabaseReference databaseReference;

    public RecycleAdapter(Context context, ArrayList<Student> studentArrayList, DatabaseReference databaseReference) {
        this.context = context;
        StudentArrayList = studentArrayList;
        this.databaseReference = databaseReference;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater layoutInflater  = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.sample_layout,viewGroup,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {

        Student student = StudentArrayList.get(position);
         holder.textname.setText(student.getName());
         holder.textemail.setText(student.getEmail());



        holder.textname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase.getInstance().getReference().child("students").child(databaseReference.getRef(position).getKey).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(context,"Data save successful",Toast.LENGTH_LONG).show();
                        }else{

                        }
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return StudentArrayList.size();
    }

    public class Myviewholder extends RecyclerView.ViewHolder  {
        TextView textname,textemail;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            textname = itemView.findViewById(R.id.titleID);
            textemail = itemView.findViewById(R.id.descId);

        }


    }






}
