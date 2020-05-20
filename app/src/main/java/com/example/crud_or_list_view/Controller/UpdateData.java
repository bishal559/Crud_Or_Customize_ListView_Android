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

import static com.example.crud_or_list_view.MainActivity.emailpass;
import static com.example.crud_or_list_view.MainActivity.idpass;
import static com.example.crud_or_list_view.MainActivity.namepass;
import static com.example.crud_or_list_view.MainActivity.passwordpass;
import static com.example.crud_or_list_view.MainActivity.phonepass;

public class UpdateData extends AppCompatActivity {
    DatabaseHelper db;
    EditText email,username,password,number;
    Button updatebtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.udpatedata);
        email=findViewById(R.id.update_email);
        db=new DatabaseHelper(getApplicationContext());
        username=findViewById(R.id.update_name);
        password=findViewById(R.id.update_password);
        number=findViewById(R.id.update_phone);
        updatebtn=findViewById(R.id.updateData);
        email.setText(emailpass);
        username.setText(namepass);
        password.setText(passwordpass);
        number.setText(phonepass);
        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if( db.updateDate(idpass,email.getText().toString(),username.getText().toString(),password.getText().toString(),number.getText().toString())==true)
               {
                   Toast.makeText(getApplicationContext(),"Data Update",Toast.LENGTH_SHORT).show();
                   finish();
               }
            }
        });

    }
}
