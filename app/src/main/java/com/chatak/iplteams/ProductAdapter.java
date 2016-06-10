package com.chatak.iplteams;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<String> {

    private static class ViewHolder {
        public TextView tvTitle;
    }

    public ProductAdapter(Context context, ArrayList<String> products) {
        super(context, 0, products);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String product = getItem(position);
        
        ViewHolder viewHolder;
        
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_product, parent, false);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        viewHolder.tvTitle.setText(product);

        return convertView;
    }
}