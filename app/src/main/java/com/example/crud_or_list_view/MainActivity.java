package com.example.crud_or_list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.crud_or_list_view.Adapter.UserListAdapter;
import com.example.crud_or_list_view.Controller.AddData;
import com.example.crud_or_list_view.Controller.UpdateData;
import com.example.crud_or_list_view.DatabaseHelper.DatabaseHelper;
import com.example.crud_or_list_view.Model.UserLogin;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listview;
    FloatingActionButton addBtn;
    UserListAdapter userlistAdapter;
    ArrayList<UserLogin>userLogins;
    DatabaseHelper databaseHelper;
    public static String idpass;
    public static String emailpass;
    public static String namepass;
    public static String passwordpass;
    public static String phonepass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=findViewById(R.id.listview);
        addBtn=findViewById(R.id.addBtn);
        databaseHelper=new DatabaseHelper(getApplicationContext());
        userLogins=databaseHelper.getDate();
        userlistAdapter=new UserListAdapter(getApplicationContext(),userLogins);
        listview.setAdapter(userlistAdapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNew(AddData.class);
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                idpass=""+userLogins.get(position).getId();
                namepass=userLogins.get(position).getUsername();
                emailpass=userLogins.get(position).getEmail();
                passwordpass=userLogins.get(position).getPassword();
                phonepass=userLogins.get(position).getNumber();
                showPopup(view,userLogins.get(position).getId(),userLogins.get(position).getUsername());
                return false;
            }
        });
    }
    private void openNew(Class c)
    {
        Intent intent=new Intent(getApplicationContext(),c);
        startActivity(intent);
    }
    private void showPopup(View view, final int id, final String name)
    {
        final PopupMenu popup=new PopupMenu(getApplicationContext(),view, Gravity.RIGHT);
        popup.getMenuInflater().inflate(R.menu.deleteorupdatemenu,popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.delete_menu:
                        int result=databaseHelper.deleteDate(""+id);
                        if(result>0)
                        {
                            Toast.makeText(getApplicationContext(),"Delete "+name,Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.update_menu:
                        openNew(UpdateData.class);
                }
                return false;
            }
        });
        popup.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        userLogins=databaseHelper.getDate();
        userlistAdapter=new UserListAdapter(getApplicationContext(),userLogins);
        listview.setAdapter(userlistAdapter);
    }
}
