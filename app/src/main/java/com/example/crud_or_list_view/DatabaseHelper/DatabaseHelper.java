package com.example.crud_or_list_view.DatabaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.crud_or_list_view.Model.UserLogin;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name="Student.db";
    public static final String Table_Name="Login";
    public static final String C1="Email";
    public static final String C2="UserName";
    public static final String C3="Password";
    public static final String C4="Number";
    public DatabaseHelper(@Nullable Context context)
    {
        super(context,Database_Name,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String cratetable="CREATE TABLE "+Table_Name+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,Email,UserName,Password,Number)";
        db.execSQL(cratetable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }
    public boolean addData(String email,String username,String password,String num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(C1,email);
        contentValues.put(C2,username);
        contentValues.put(C3,password);
        contentValues.put(C4,num);
        long result=db.insert(Table_Name,null,contentValues);
        if(result==-1)
        {
            return false;
        }else
        {
            return true;
        }
    }
    public boolean updateDate(String id,String email,String username,String password,String num)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(C1,email);
        contentValues.put(C2,username);
        contentValues.put(C3,password);
        contentValues.put(C4,num);
        db.update(Table_Name,contentValues,"ID=?",new String[]{id});
        return true;
    }
    public Integer deleteDate(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete(Table_Name,"ID=?",new String[]{id});
    }
    public ArrayList<UserLogin>getDate()
    {
        int count=0;
        SQLiteDatabase db=this.getWritableDatabase();
        ArrayList<UserLogin>user=new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT *FROM "+Table_Name,null);
        if(cursor!=null)
        {
            while(cursor.moveToNext())
            {
                count++;
                UserLogin u=new UserLogin(cursor.getInt(0),count,cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
                user.add(u);
            }
            cursor.close();
            db.close();
        }
        return user;
    }
}
