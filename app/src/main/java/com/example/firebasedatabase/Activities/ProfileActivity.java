package com.example.firebasedatabase.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.firebasedatabase.Adapter.RecycleAdapter;
import com.example.firebasedatabase.ModelClass.Student;
import com.example.firebasedatabase.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecycleAdapter adapter;
    DatabaseReference databaseReference;
    public ArrayList<Student>arrayList; //student list

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        recyclerView = findViewById(R.id.idRecycleView);
        databaseReference = FirebaseDatabase.getInstance().getReference("students");
        arrayList = new ArrayList<Student>();
        adapter = new RecycleAdapter(ProfileActivity.this,arrayList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot1 : snapshot.getChildren()){

                    Student student = dataSnapshot1.getValue(Student.class);
                    arrayList.add(student);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}