package com.example.radiobuttonn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radioGroup;
    TextView text1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btn=(Button)findViewById(R.id.buttonid) ;
       btn.setOnClickListener(this);
        radioGroup=(RadioGroup) findViewById(R.id.groupid);
       radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(RadioGroup radioGroup, int i) {
               RadioButton button=(RadioButton) findViewById(R.id.item1);
               if(button.isChecked())
               {
                   Toast.makeText(MainActivity.this, "Option 1 clicked", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(MainActivity.this, "Option 2 clicked", Toast.LENGTH_SHORT).show();
               }

           }
       });
    }

    @Override
    public void onClick(View view) {
        RadioButton button=(RadioButton) findViewById(R.id.item1);
        text1=(TextView) findViewById(R.id.textid);
        text1.setText("You Have Selected "+button.getText().toString());
    }
}