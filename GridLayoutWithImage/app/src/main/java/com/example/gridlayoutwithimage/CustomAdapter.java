package com.example.gridlayoutwithimage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int[] flags;
    String[] girlnme;

    private LayoutInflater inflater;

     CustomAdapter(Context context, String[] girlnme, int[] flags) {
        this.context=context;
        this.girlnme=girlnme;
        this.flags=flags;
    }

    @Override
    public int getCount() {
        return girlnme.length;
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
        ImageView imageView=(ImageView) convertView.findViewById(R.id.imageView1);
        TextView textView=(TextView)  convertView.findViewById(R.id.textViewid);
        imageView.setImageResource(flags[position]);
        textView.setText(girlnme[position]);
        return convertView;
    }
}
