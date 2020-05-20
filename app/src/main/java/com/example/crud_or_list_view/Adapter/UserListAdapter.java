package com.example.crud_or_list_view.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.crud_or_list_view.Model.UserLogin;
import com.example.crud_or_list_view.R;

import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<UserLogin>userLogins;

    public UserListAdapter(Context context, ArrayList<UserLogin> userLogins) {
        this.context = context;
        this.userLogins = userLogins;
    }

    @Override
    public int getCount() {
        return userLogins.size();
    }

    @Override
    public Object getItem(int position) {
        return userLogins.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=View.inflate(context, R.layout.listviewrow,null);
        TextView no,email,username,password,number;
        no=view.findViewById(R.id.no);
        email=view.findViewById(R.id.view_email);
        username=view.findViewById(R.id.view_name);
        password=view.findViewById(R.id.view_password);
        number=view.findViewById(R.id.view_number);
        no.setText(""+userLogins.get(position).getCount()+".");
        email.setText(userLogins.get(position).getEmail());
        username.setText(userLogins.get(position).getUsername());
        password.setText(userLogins.get(position).getPassword());
        number.setText(userLogins.get(position).getNumber());
        view.setTag(userLogins.get(position).getId());
        return view;
    }
}
