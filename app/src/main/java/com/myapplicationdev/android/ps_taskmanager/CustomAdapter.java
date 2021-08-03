package com.myapplicationdev.android.ps_taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Task> {
    private Context context;
    private ArrayList<Task> tasks;
    TextView tvTitle,tvDesc;
    private int resourceLayout;

    public CustomAdapter(Context context, int resource,ArrayList<Task> objects) {
        super(context, resource, objects);
        tasks = objects;
        this.context = context;
        this.resourceLayout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row,parent,false);
        tvTitle = rowView.findViewById(R.id.tvTitle);
        tvDesc = rowView.findViewById(R.id.tvDesc);
        Task task = tasks.get(position);
        tvTitle.setText(task.getId() + ". " + task.getTitle());
        tvDesc.setText(task.getDescription());

        return rowView;
    }
}
