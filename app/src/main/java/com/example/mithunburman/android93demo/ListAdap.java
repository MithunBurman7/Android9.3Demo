package com.example.mithunburman.android93demo;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mithunburman.android93demo.ListAdap;


class MyListAdapter extends BaseAdapter {

    //declaring variables
    private final Activity context;
    private final String[] name;
    private final String[] number;

    /**
     * creating constructor of MyListAdapter class and passing requirements values as arguments
     * @param context
     * @param name
     * @param number
     */

    public MyListAdapter(Activity context, String[] name, String[] number) {
        super();
        // initializing the values
        this.context = context;
        this.name = name;
        this.number = number;
    }

    //Implement method
    //getCount() its check how many items are in the data set represented by this Adapter.
    @Override
    public int getCount()
    {
        return name.length;
    }

    //getItem() Get the data item associated with the specified position in the data set.
    @Override
    public Object getItem(int i)
    {
        return null;
    }
    //getItemId() Get the row id associated with the specified position in the list.
    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    private class ViewHolder {
        //Declaration of set of views
        TextView nameView;
        TextView numberView;
    }


    /**
     * getView()-Get a View that displays the data at the specified position in the data set..
     *
     * @param position-The position of the item within the adapter's data set of the item whose view we want.
     * @param view-A View corresponding to the data at the specified position.
     * @param parent- The parent that this view will eventually be attached to
     * @return-
     */
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent)
    {
        ViewHolder holder;
        // using LayoutInflater to fill layouts
        LayoutInflater inflater = context.getLayoutInflater();
        if (view == null) {

            view = inflater.inflate(R.layout.contact, null);
            holder = new ViewHolder();
            holder.nameView = (TextView) view.findViewById(R.id.textView_name);
            holder.numberView = (TextView) view.findViewById(R.id.textView_number);

            view.setTag(holder);
        }else
        {

            holder = (ViewHolder) view.getTag();
        }
        //setting name
        holder.nameView.setText(name[position]);
        //setting number
        holder.numberView.setText(number[position]);
        //return view
        return view;

    }
}
public class ListAdap {
}
