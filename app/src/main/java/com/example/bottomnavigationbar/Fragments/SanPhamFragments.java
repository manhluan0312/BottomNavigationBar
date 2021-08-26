package com.example.bottomnavigationbar.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavigationbar.Adapter.UserAdapter;
import com.example.bottomnavigationbar.MainActivity;
import com.example.bottomnavigationbar.Model.User;
import com.example.bottomnavigationbar.R;

import java.util.ArrayList;
import java.util.List;

public class SanPhamFragments extends Fragment {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    MainActivity mainActivity;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view =inflater.inflate(R.layout.frament_sanpham,container,false);
         mainActivity=(MainActivity)getActivity();//ep kieu

        recyclerView = view.findViewById(R.id.rcv_user);
        userAdapter = new UserAdapter(mainActivity);

        //set giao dien
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(mainActivity, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        userAdapter.SetData(getListUser());

        recyclerView.setAdapter(userAdapter);
        return view;
    }

    private List<User> getListUser()
    {
        List<User> list =new ArrayList<>();

        list.add(new User(R.drawable.anh1,"Hà anh1"));
        list.add(new User(R.drawable.anh2,"Hà anh2"));
        list.add(new User(R.drawable.anh3,"Hà anh3"));
        list.add(new User(R.drawable.anh4,"Hà anh4"));

        list.add(new User(R.drawable.anh1,"Hà anh5"));
        list.add(new User(R.drawable.anh3,"Hà anh6"));
        list.add(new User(R.drawable.anh2,"Hà anh7"));
        list.add(new User(R.drawable.anh4,"Hà anh8"));

        list.add(new User(R.drawable.anh1,"Hà anh9"));
        list.add(new User(R.drawable.anh4,"Hà anh10"));
        list.add(new User(R.drawable.anh3,"Hà anh11"));
        list.add(new User(R.drawable.anh2,"Hà anh12"));


        list.add(new User(R.drawable.anh4,"Hà anh13"));
        list.add(new User(R.drawable.anh2,"Hà anh14"));
        list.add(new User(R.drawable.anh3,"Hà anh15"));
        list.add(new User(R.drawable.anh1,"Hà anh16"));

        list.add(new User(R.drawable.anh4,"Hà anh17"));
        list.add(new User(R.drawable.anh2,"Hà anh18"));
        list.add(new User(R.drawable.anh3,"Hà anh19"));
        list.add(new User(R.drawable.anh1,"Hà anh20"));


        list.add(new User(R.drawable.anh4,"Hà anh21"));
        list.add(new User(R.drawable.anh2,"Hà anh22"));
        list.add(new User(R.drawable.anh3,"Hà anh23"));
        list.add(new User(R.drawable.anh1,"Hà anh24"));


        list.add(new User(R.drawable.anh4,"Hà anh25"));
        list.add(new User(R.drawable.anh2,"Hà anh26"));
        list.add(new User(R.drawable.anh3,"Hà anh27"));
        list.add(new User(R.drawable.anh1,"Hà anh28"));

        list.add(new User(R.drawable.anh4,"Hà anh29"));
        list.add(new User(R.drawable.anh2,"Hà anh30"));
        list.add(new User(R.drawable.anh3,"Hà anh31"));
        list.add(new User(R.drawable.anh1,"Hà anh32"));

        list.add(new User(R.drawable.anh4,"Hà anh33"));
        list.add(new User(R.drawable.anh2,"Hà anh34"));
        list.add(new User(R.drawable.anh3,"Hà anh35"));
        list.add(new User(R.drawable.anh1,"Hà anh36"));

        list.add(new User(R.drawable.anh4,"Hà anh37"));
        list.add(new User(R.drawable.anh2,"Hà anh38"));
        list.add(new User(R.drawable.anh3,"Hà anh39"));
        list.add(new User(R.drawable.anh1,"Hà anh40"));
        list.add(new User(R.drawable.anh3,"Hà anh41"));
        list.add(new User(R.drawable.anh1,"Hà anh42"));

        return list;
    }

}
