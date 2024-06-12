package com.example.atry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private TextView text1,text2;
private EditText edit1,edit2;
private Button button;
int request_Code=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(TextView) findViewById(R.id.textid1);
        text2=(TextView) findViewById(R.id.textid2);
        edit1=(EditText) findViewById(R.id.edittext1);
        edit2=(EditText) findViewById(R.id.edittext2);
        button=(Button) findViewById(R.id.buttonid1);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i=new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra("Key1",edit1.getText().toString());
        i.putExtra("Key2", Integer.parseInt(edit2.getText().toString()));
        //using bundle..pass data
        Bundle bundle=new Bundle();
        bundle.putString("Key5","Through bundle");
        bundle.putInt("Key6",Integer.parseInt(edit2.getText().toString()));
        i.putExtras(bundle);

        startActivityForResult(i,request_Code);
    }
    public void onActivityResult(int requestcode,int resultcode,Intent data) {

        super.onActivityResult(requestcode, resultcode, data);

        if(requestcode==request_Code)
        {
            if(resultcode==RESULT_OK)
            {

                Toast.makeText(MainActivity.this,data.getData().toString(),Toast.LENGTH_SHORT).show();
                Toast.makeText(this, Integer.toString(data.getIntExtra("Key4", 0)), Toast.LENGTH_SHORT).show();
            //jokhon 2nd activity te pathacchi tokhon 2nd e getIntent diye catch korte hobe
                //jokhon 2nd theke first e pathacchi tokhon getIntent lage na   data. diye access korbo


                //jehetu 2nd theke getextras diye pathaisi tai ekhan theke intent er object diye seta age catch korbo
                Bundle bundle=data.getExtras();
                Toast.makeText(this, bundle.getString("Key7"), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, Integer.toString(bundle.getInt("Key8",0)), Toast.LENGTH_SHORT).show();

            }
        }
    }
}