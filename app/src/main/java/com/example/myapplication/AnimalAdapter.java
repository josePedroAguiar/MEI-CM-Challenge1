package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends BaseAdapter {
    private Context context;
    private List<AnimalItem> items;

    public AnimalAdapter(Context context, List<AnimalItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.dropdown_item, null);
        ImageView imageView = view.findViewById(R.id.img);
        TextView textView = view.findViewById(R.id.text);

        AnimalItem item = items.get(position);
        imageView.setImageResource(item.getImageResource());
        textView.setText(item.getText());

        return view;
    }
}
