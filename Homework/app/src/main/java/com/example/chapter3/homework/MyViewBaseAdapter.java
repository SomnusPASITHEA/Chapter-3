package com.example.chapter3.homework;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyViewBaseAdapter extends BaseAdapter {
    private int[] args =
            new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,35,36,38,39,44,49,58,59};

    private  String[] nameList =
            new String[]{"路人1","路人2","路人3","路人4","路人5","路人6","路人7","路人8","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A"};

    private  String[] contentList =
            new String[]{"路人1","路人2","路人3","路人4","路人5","路人6","路人7","路人8","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A","路人A"};

    private Context mContext;

    public MyViewBaseAdapter(Context context) {
        mContext = context;
    }

    @Override public int getCount() {
        return args.length;
    }

    @Override public Object getItem(int i) {
        return null;
    }

    @Override public long getItemId(int i) {
        return 0;
    }
    @Override public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(R.layout.friend_list_item,null);
            Log.d("CreateNewView", "position"+position);
        }
        else view= (View) convertView;
        TextView textViewName = view.findViewById(R.id.item_title);
        TextView textViewContent = view.findViewById(R.id.item_description);
        TextView textViewTime = view.findViewById(R.id.item_time);
        textViewName.setText(nameList[position]);
        textViewContent.setText(contentList[position]);
        textViewTime.setText(args[position]+"分钟前");
        return view;
    }
}
