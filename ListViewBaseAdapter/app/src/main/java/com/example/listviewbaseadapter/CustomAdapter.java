package com.example.listviewbaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

public class CustomAdapter extends BaseAdapter {
    int[] flags;
    String[] countryNames;
    Context context;
    LayoutInflater inflater;
    public CustomAdapter(Context context, String[] countryNames, int[] flags) {
        this.context=context;
        this.countryNames=countryNames;
        this.flags=flags;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
         convertView=inflater.inflate(R.layout.sample_view,parent,false);
        }
       ImageView imageView=(ImageView) convertView.findViewById(R.id.imageId1);
        TextView textView=(TextView) convertView.findViewById(R.id.countryNameId);
        imageView.setImageResource(flags[position]);
        textView.setText(countryNames[position]);

        return null;
    }
}
