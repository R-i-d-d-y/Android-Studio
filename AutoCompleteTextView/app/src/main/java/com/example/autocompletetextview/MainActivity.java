package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] name={"Sadia","Reme","Riddy","Nusrat","Jahan","Nousin","Tabassum"};
    AutoCompleteTextView edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       edit=(AutoCompleteTextView) findViewById(R.id.editid);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,name);
        edit.setThreshold(2);
        edit.setAdapter(adapter);


    }
    public void onClick(View view)
    {
        String s=edit.getText().toString();
        Toast.makeText(this, "You Selected "+s, Toast.LENGTH_SHORT).show();
    }
}