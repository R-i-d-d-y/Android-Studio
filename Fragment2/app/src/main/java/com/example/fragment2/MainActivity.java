package com.example.fragment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        DisplayMetrics matrics=this.getResources().getDisplayMetrics();
        int width=matrics.widthPixels;
        int height=matrics.heightPixels;
        if(width>height)
        {
            Fragment1 fragment1=new Fragment1();
            FragmentTransaction replace;
            replace = fragmentTransaction.replace(android.R.id.content,fragment1);
        }
        else
        {
            Fragment3 fragment3 = new Fragment3();
            FragmentTransaction replace = fragmentTransaction.replace(
                    android.R.id.content, fragment3);
        }
        fragmentTransaction.commit();


    }
}