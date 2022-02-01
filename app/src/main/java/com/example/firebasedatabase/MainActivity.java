package com.example.firebasedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nametext,emailtext;
    private Button savebtn;


//    int width = (int) (getResources().getDisplayMetrics().widthPixels * 0.85);
//    int height = (int) (getResources().getDisplayMetrics().heightPixels * 0.85);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


    }
}













