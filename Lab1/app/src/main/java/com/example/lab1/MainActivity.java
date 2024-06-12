package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
Button insert,show;
EditText e1,e2,e3,e4;
    DBAdapter db;
    TextView text;
    String s1,s2,s3,s4;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBAdapter(MainActivity.this);
        e1=(EditText)findViewById(R.id.editid1) ;
        e2=(EditText)findViewById(R.id.editid2) ;
        e3=(EditText)findViewById(R.id.editid3) ;
        e4=(EditText)findViewById(R.id.editid4) ;
        text=(TextView)findViewById(R.id.textid) ;
        insert=(Button) findViewById(R.id.insertbuttonid);
        show=(Button)findViewById(R.id.Showbuttonid);
        insert.setOnClickListener(this);
        show.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.insertbuttonid) {
            s1 = e1.getText().toString();
            s2 = e2.getText().toString();
            s3 = e3.getText().toString();
            s4 = e4.getText().toString();
            db = new DBAdapter(MainActivity.this);
            db.open();
            long id = db.insertContact(Integer.parseInt(s4),s1, Integer.parseInt(s2), Integer.parseInt(s3));
            db.close();
            Toast.makeText(this, "Data inserted.......", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == R.id.Showbuttonid) {
            db.open();
            db = new DBAdapter(MainActivity.this);
            c=db.getAllContacts();
            if(c.moveToFirst())
            {
                do{
                    text.setText("id: "+c.getString(0)+"Name: "+c.getString(1)+"Session: "+c.getString(2)+"Mobile"+c.getString(3));
                }while(c.moveToNext());
            }
            db.close();

        }
    }
}