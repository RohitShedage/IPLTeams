package com.chatak.iplteams;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {

    private static class ViewHolder {
        public TextView tvTitle;
        public TextView tvWeight;
        public TextView tvPrice;
    }

    public ProductAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    private String convertToString(double val) {
        return val + "";
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Product product = getItem(position);
        
        ViewHolder viewHolder;
        
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_product, parent, false);
            viewHolder.tvTitle = (TextView)convertView.findViewById(R.id.tvTitle);
            viewHolder.tvWeight = (TextView)convertView.findViewById(R.id.tvWeight);
            viewHolder.tvPrice = (TextView)convertView.findViewById(R.id.tvPrice);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        viewHolder.tvTitle.setText(product.getTitle());
        viewHolder.tvWeight.setText(product.getWeight());
        viewHolder.tvPrice.setText(convertToString(product.getPrice()));
        return convertView;
    }
}