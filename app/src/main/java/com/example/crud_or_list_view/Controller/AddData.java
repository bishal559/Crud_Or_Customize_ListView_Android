package com.example.crud_or_list_view.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.crud_or_list_view.DatabaseHelper.DatabaseHelper;
import com.example.crud_or_list_view.R;

public class AddData extends AppCompatActivity {
    EditText email,username,password,number;
    Button addBtn;
    DatabaseHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddata);
        db=new DatabaseHelper(getApplicationContext());
        email=findViewById(R.id.email);
        username=findViewById(R.id.name);
        password=findViewById(R.id.password);
        number=findViewById(R.id.phone);
        addBtn=findViewById(R.id.saveData);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.addData(email.getText().toString(),username.getText().toString(),password.getText().toString(),number.getText().toString())==true)
                {
                    Toast.makeText(getApplicationContext(),"Data Save",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}
