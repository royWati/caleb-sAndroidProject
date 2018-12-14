package com.zalego2018dec.exercise.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zalego2018dec.exercise.R;
import com.zalego2018dec.exercise.objects.DashboardItem;

import java.util.List;

/**
 * Created by folio on 12/13/2018.
 */

public class DashboardGridViewAdapter extends BaseAdapter {

    Context context;
    List<DashboardItem> data;
    LayoutInflater inflater;
    public DashboardGridViewAdapter(Context context, List<DashboardItem> data) {
        this.context = context;
        this.data = data;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.single_gridview_item,null);
        ImageView imageView = view.findViewById(R.id.grid_item_image);
        TextView textView =view.findViewById(R.id.grid_item_text);

        //passing data from the list to our view

        imageView.setImageResource(data.get(i).getIcon());
        textView.setText(data.get(i).getText());

        return view;
    }
}
