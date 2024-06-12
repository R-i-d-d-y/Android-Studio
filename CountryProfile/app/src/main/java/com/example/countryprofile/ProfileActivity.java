package com.example.countryprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
public class ProfileActivity extends AppCompatActivity {
ImageView image;
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        image=(ImageView) findViewById(R.id.imageid1);
        text=(TextView) findViewById(R.id.textid1);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String country=bundle.getString("Key1");
            showDetails(country);
        }
    }

    private void showDetails(String countryNAME) {
        if(countryNAME.equals("bangladesh"))
        {
            image.setImageResource(R.drawable.bangladeshimage);
            text.setText(R.string.bangladesh);
        }
        if(countryNAME.equals("india"))
        {
            image.setImageResource(R.drawable.indiaimage);
            text.setText(R.string.india);
        }
        if(countryNAME.equals("pakistan"))
        {
            image.setImageResource(R.drawable.pakistanimage);
            text.setText(R.string.pakistan);
        }
    }
}