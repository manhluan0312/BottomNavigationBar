package com.example.bottomnavigationbar.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bottomnavigationbar.MainActivity;
import com.example.bottomnavigationbar.Model.SinhVien;
import com.example.bottomnavigationbar.R;

import java.util.List;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder>

{

    private MainActivity mainActivity;
    private List<SinhVien> sinhVienList;

    public SinhVienAdapter( MainActivity mainActivity,List<SinhVien> sinhVienList) {
        this.mainActivity = mainActivity;
        this.sinhVienList=sinhVienList;
    }

    @Override
    public SinhVienAdapter.SinhVienViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sinhvien, parent, false);
        return new SinhVienViewHolder(view);
    }


    @Override
    public void onBindViewHolder( SinhVienAdapter.SinhVienViewHolder holder, int position) {

        SinhVien sinhvien = sinhVienList.get(position);
        if (sinhvien == null) {
            return;
        }
        holder.tv_ten.setText(sinhvien.getHoten());
        holder.tv_namsinh.setText(""+sinhvien.getNamsinh());
        holder.tv_diachi.setText(sinhvien.getDiachi());

        Glide.with(mainActivity)
                .load(sinhvien.getAnh())
                .into(holder.img_anh);
    }

    @Override
    public int getItemCount() {
        if (sinhVienList != null) {
            return sinhVienList.size();
        }
        return 0;
    }

    public class SinhVienViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_anh;
        private TextView tv_ten,tv_namsinh,tv_diachi;

        public SinhVienViewHolder(View itemView) {

            super(itemView);

            img_anh=itemView.findViewById(R.id.img_sinhvien);
            tv_ten=itemView.findViewById(R.id.tv_name);
            tv_namsinh=itemView.findViewById(R.id.tv_namsinh);
            tv_diachi=itemView.findViewById(R.id.tv_diachi);

        }
    }
}
