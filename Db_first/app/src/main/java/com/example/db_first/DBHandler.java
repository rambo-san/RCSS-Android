package com.example.db_first;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class DBHandler extends SQLiteOpenHelper{
    private static final String DB_NAME="student_db", TABLE_NAME="student_details", ID="id",NAME="name",COURSE="course", SEMESTER="semester";
    private static final int DB_VERSION=1;
    //constructor
    public DBHandler(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
    String query="CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" TEXT, "+COURSE+" TEXT, "+SEMESTER+" INTEGER)";
    db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    onCreate(db);
    }
    public  void addNewStudent(String name, String course, int semester){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();

        values.put(NAME,name);
        values.put(COURSE,course);
        values.put(SEMESTER,semester);

        db.insert(TABLE_NAME,null,values);
        //db.close();
    }
}
