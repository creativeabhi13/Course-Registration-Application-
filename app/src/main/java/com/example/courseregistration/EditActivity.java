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

public class EditActivity extends AppCompatActivity {
    Button btn_delete, btn_edit,btn_back;
    EditText id,name1, course1,email1, fee1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        btn_delete = findViewById(R.id.btn_delete);
        btn_edit = findViewById(R.id.btn_edit);
        btn_back = findViewById(R.id.btn_back);

        id = findViewById(R.id.id);
        name1 = findViewById(R.id.name1);
        email1 = findViewById(R.id.email1);
        course1 = findViewById(R.id.course1);
        fee1 = findViewById(R.id.fee1);

        Intent i = getIntent();


            String t1=i.getStringExtra("id").toString();
            String t2 =i.getStringExtra("name").toString();
            String t3 = i.getStringExtra("email").toString();
            String t4 = i.getStringExtra("course").toString();
            String t5 = i.getStringExtra("fee").toString();
            id.setText(t1);
            name1.setText(t2);
            email1.setText(t3);
            course1.setText(t4);
            fee1.setText(t5);



        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Delete();
                }
                catch (DeleteException e){

                }
            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),viewActivity.class);
                startActivity(i);

            }
        });




        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Edit();
                }
                catch (EditException e){
                    
                }
            }
        });
    }

    // delete the data

    public void Delete() throws DeleteException
    {
        try
        {
            String id1 = id.getText().toString();
// creating databases
            SQLiteDatabase db = openOrCreateDatabase("CourseDb", Context.MODE_PRIVATE,null);


            String sql = "delete from records where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1,id1);
            statement.execute();
            Toast.makeText(this,"Record Deleted",Toast.LENGTH_LONG).show();


            name1.setText("");
            email1.setText("");
            course1.setText("");
            fee1.setText("");
            name1.requestFocus();


        }
        catch (Exception e)
        {
            Toast.makeText(this,"Record Fail",Toast.LENGTH_LONG).show();
        }
    }

    public void Edit() throws EditException
    {
        try
        {
            String n= name1.getText().toString();
            String e=email1.getText().toString();
            String c=course1.getText().toString();
            String f=fee1.getText().toString();
            String i=id.getText().toString();
            SQLiteDatabase db = openOrCreateDatabase("CourseDb",Context.MODE_PRIVATE,null);


            String sql = "update records set name = ?,email = ?,course=?,fee=? where id= ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,n);
            statement.bindString(2,e);
            statement.bindString(3,c);
            statement.bindString(4,f);
            statement.bindString(5,i);
            statement.execute();
            Toast.makeText(this,"Record Updated Successfully ",Toast.LENGTH_LONG).show();


            name1.setText("");
            email1.setText("");
            course1.setText("");
            fee1.setText("");
            name1.requestFocus();


        }
        catch (Exception e)
        {
            Toast.makeText(this,"Record Fail",Toast.LENGTH_LONG).show();
        }

    }

}