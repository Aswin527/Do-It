package com.example.mydoes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class DoitAdapter extends RecyclerView.Adapter<DoitAdapter.MyViewHolder> {
    Context context;
    ArrayList<DatabaseClass> data;

    public DoitAdapter(Context c,ArrayList<DatabaseClass> p){
        context = c;
        data = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.tidoitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.titleHome.setText(data.get(position).getTitleHome());
        holder.desHome.setText(data.get(position).getDesHome());
        holder.dateHome.setText(data.get(position).getDateHome());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
            TextView titleHome,desHome,dateHome;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleHome = (TextView)itemView.findViewById(R.id.titleHome);
            desHome = (TextView)itemView.findViewById(R.id.desHome);
            dateHome = (TextView)itemView.findViewById(R.id.dateHome);
        }
    }
}
