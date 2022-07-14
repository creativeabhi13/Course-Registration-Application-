package com.example.courseregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    Button btn_add, btn_view;
    EditText name, course,email, fee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btn_view = findViewById(R.id.btn_view);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        course=findViewById(R.id.course);
        fee=findViewById(R.id.fee);

        btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(),viewActivity.class);
                startActivity(i);
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });

    }


    public void onClick(View v) {

        insert();
        if (v.equals(btn_add)) {
            Intent it = new Intent(this, viewActivity.class);
            startActivity(it);
        }
        if (v.equals(btn_view)) {
            Intent it = new Intent(this, viewActivity.class);

            startActivity(it);
        }

    }

    // insert operation of data

    public void insert(){
         try {
             String n= name.getText().toString();
             String e=email.getText().toString();
             String c=course.getText().toString();
             String f=fee.getText().toString();

             // creating database
             SQLiteDatabase db= openOrCreateDatabase("CourseDb", Context.MODE_PRIVATE,null);
             db.execSQL("CREATE TABLE IF NOT EXISTS records(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,email VARCHAR,course VARCHAR,fee VARCHAR)");

             String sql = "insert into records(name,email,course,fee)values(?,?,?,?)";
             SQLiteStatement statement = db.compileStatement(sql);
             statement.bindString(1,n);
             statement.bindString(2,e);
             statement.bindString(3,c);
             statement.bindString(4,f);
             statement.execute();
             Toast.makeText(this,"Record Added Successfully",Toast.LENGTH_LONG).show();

             name.setText("");
             email.setText("");
             course.setText("");
             fee.setText("");
             name.requestFocus();

         }catch (Exception e ){

        }
    }
}