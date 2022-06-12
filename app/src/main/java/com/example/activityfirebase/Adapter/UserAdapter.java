package com.example.activityfirebase.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.activityfirebase.R;
import com.example.activityfirebase.model.User;

import java.util.List;

import javax.annotation.Nonnull;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {


    private Context context;
    private List<User> list;
    private Dialog dialog;
    public interface Dialog {
        void onClick (int pos);
    }
    public void setDialog(Dialog dialog){
        this.dialog = dialog;
    }
    public UserAdapter(Context context, List<User> list){
        this.context = context;
        this.list = list;
    }

    @Nonnull
    @Override
    public MyViewHolder onCreateViewHolder(@Nonnull ViewGroup parent,int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user,parent,false);
        return new MyViewHolder(itemView);
    }
    public void onBindViewHolder(@Nonnull MyViewHolder holder,int position){
        holder.name.setText(list.get(position).getName());
        holder.email.setText(list.get(position).getEmail());

    }
    @Override
    public int getItemCount(){
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, email;

        public  MyViewHolder(@Nonnull View itemview){
            super(itemview);
            name=itemview.findViewById(R.id.name);
            email=itemview.findViewById(R.id.email);
            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}
