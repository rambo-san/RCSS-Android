package com.example.db_first;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import  android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText e1,e2,e3;
private DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.course);
        e3=findViewById(R.id.semester);
        dbHandler=new DBHandler(MainActivity.this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
    public void addStudent(View v) {
//get values from editText
        String name=e1.getText().toString();
        String course=e2.getText().toString();
        int semester=Integer.parseInt(e3.getText().toString());
        dbHandler.addNewStudent(name,course,semester);
        Toast.makeText(MainActivity.this,"Student Added successfully",Toast.LENGTH_LONG).show();
        e1.setText("");
        e2.setText("");
        e3.setText("");

    }
    public void findStudent(View v){
        String name=e1.getText().toString();
        Student student=dbHandler.searchStudent(name);
        if(student!=null){
            e2.setText(String.valueOf(student.getCourse()));
            e3.setText((String.valueOf(student.getSemester())));
        }
        else{
            Toast.makeText(MainActivity.this,"Student not found!",Toast.LENGTH_LONG).show();
        }
    }
    public void deleteStudent(View v){
        String name=e1.getText().toString();
        if(dbHandler.deleteStudenT(name)){
            Toast.makeText(MainActivity.this,"Student Deleted",Toast.LENGTH_LONG).show();
            e1.setText("");
            e2.setText("");
            e3.setText("");

        }
        else{
            Toast.makeText(MainActivity.this,"Student not found!",Toast.LENGTH_LONG).show();
            e1.setText("");
            e2.setText("");
            e3.setText("");
        }
    }
    public void updateStudent(View v){
        String name=e1.getText().toString();
        String course=e2.getText().toString();
        int semester=Integer.parseInt(e3.getText().toString());
        if(dbHandler.updateStudent(name,course,semester)){
            Toast.makeText(MainActivity.this,"Student Updated successfully",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this,"Student not found!",Toast.LENGTH_LONG).show();

        }
        e1.setText("");
        e2.setText("");
        e3.setText("");
    }
}