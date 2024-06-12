package com.example.gridlayoutwithimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private GridView grid;
int[] flags={R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,R.drawable.image6};
String[] girlnme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid=(GridView) findViewById(R.id.gridView);
        girlnme=getResources().getStringArray(R.array.girlName);
        CustomAdapter adapter=new CustomAdapter(this,girlnme,flags);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new  AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String value=girlnme[position];
             int val=flags[position];
                Intent i=new Intent(MainActivity.this,SecondActivity.class);
                i.putExtra("Key1",girlnme[position]);
                i.putExtra("Key2",flags[position]);
                startActivity(i);

            }
        });
    }
}