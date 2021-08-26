package com.example.bottomnavigationbar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationbar.Model.User;
import com.example.bottomnavigationbar.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>
{
    private Context context;
    private List<User> userList;

    public UserAdapter(Context context) {
        this.context = context;
    }

    public void SetData(List<User> list)
    {
        this.userList=list;
        notifyDataSetChanged();
    }



    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.UserViewHolder holder, int position)
    {
        User user =userList.get(position);
        if(user==null){
            return;
        }
        holder.img.setImageResource(user.getRe_image());
        holder.tv_ten.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if(userList!=null)
        {
            return userList.size();
        }
        return 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView tv_ten;

        public UserViewHolder(View itemView) {

            super(itemView);
            img = itemView.findViewById(R.id.img_user);
            tv_ten = itemView.findViewById(R.id.tv_name);
        }
    }
}
