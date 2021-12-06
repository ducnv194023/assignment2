package com.chuyennt.test_app_bar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DataAdapter extends BaseAdapter {

    private ArrayList<DataPeople> listData;

    public DataAdapter(ArrayList<DataPeople> listData) {
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int i) {
        return listData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.people_view, null);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.textView3);
            holder.description = (TextView) view.findViewById(R.id.textView4);
            holder.time = (TextView) view.findViewById(R.id.textView5);
            holder.fname = (TextView) view.findViewById(R.id.textView2);
            holder.iconFavorite = (ImageButton) view.findViewById(R.id.imageButton);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        DataPeople data = this.listData.get(i);

        String dataName = data.faker.name.name();
        SimpleDateFormat outputFormat = new SimpleDateFormat("h:mm a");

        holder.name.setText(dataName);
        holder.description.setText(data.faker.university.name());
        holder.time.setText(outputFormat.format(data.faker.time.backward(1)));
        holder.fname.setText(String.valueOf(dataName.charAt(0)));

        holder.iconFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.favorite) {
                    holder.iconFavorite.setImageResource(R.drawable.ic_star_outline);
                    data.favorite = false;
                } else {
                    holder.iconFavorite.setImageResource(R.drawable.ic_gold_star_24);
                    data.favorite = true;
                }
                notifyDataSetChanged();
            }
        });

        return view;
    }

    private class ViewHolder {
        TextView name;
        TextView description;
        TextView time;
        TextView fname;
        ImageButton iconFavorite;
    }
}
