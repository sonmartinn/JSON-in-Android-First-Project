package com.trungson.jsonarrayobject_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListItemAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Item> listItem;

    public ListItemAdapter(Context context, int layout, List<Item> listItem) {
        this.context = context;
        this.layout = layout;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView txtTen,txtUrl;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(layout,null);

            holder = new ViewHolder();

            //ansh xa
            holder.txtTen=convertView.findViewById(R.id.Name);
            holder.txtUrl=convertView.findViewById(R.id.Email);

            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        Item item=listItem.get(position);
        holder.txtTen.setText(item.getTen());
        holder.txtUrl.setText(item.getUrl());
        return convertView;
    }
}
