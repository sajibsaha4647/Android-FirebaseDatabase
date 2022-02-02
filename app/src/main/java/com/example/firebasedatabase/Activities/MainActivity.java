package com.example.firebasedatabase.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firebasedatabase.ModelClass.Student;
import com.example.firebasedatabase.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nametext,emailtext;
    private Button savebtn;


    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference = FirebaseDatabase.getInstance().getReference("students");

        nametext = findViewById(R.id.idname);
        emailtext = findViewById(R.id.idemail);
        savebtn = findViewById(R.id.idSave);

//        savebtn.getLayoutParams().width = (int) (getResources().getDisplayMetrics().widthPixels * 0.09);
        savebtn.getLayoutParams().height = (int) (getResources().getDisplayMetrics().heightPixels * 0.1);

        savebtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
            saveData();
    }

    public void saveData(){
        String name = nametext.getText().toString();
        String email = emailtext.getText().toString();

        if(name.equals("") || email.equals("")){
            Toast.makeText(getApplicationContext(),"All field are required !",Toast.LENGTH_LONG).show();
        }else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(getApplicationContext(),"Invalid email address !",Toast.LENGTH_LONG).show();
        } else{
            String key = databaseReference.push().getKey();
            Student student = new Student(name,email);
            databaseReference.child("userid1").setValue(student);
            Toast.makeText(getApplicationContext(),"Data save successful",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(),ProfileActivity.class);
            startActivity(intent);
            nametext.setText("");
            emailtext.setText("");
        }



    }
}













