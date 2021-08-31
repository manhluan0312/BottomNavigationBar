package com.example.bottomnavigationbar.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bottomnavigationbar.API.Server;
import com.example.bottomnavigationbar.Adapter.SinhVienAdapter;
import com.example.bottomnavigationbar.MainActivity;
import com.example.bottomnavigationbar.Model.SinhVien;
import com.example.bottomnavigationbar.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class DanhMucSanPhamFragment extends Fragment {


    private RecyclerView recyclerView;
    private SinhVienAdapter sinhVienAdapter;
    MainActivity mainActivity;
    private List<SinhVien> sinhVienList;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_danh_muc_san_pham,container,false);
        mainActivity=(MainActivity)getActivity();//ep kie



        recyclerView = view.findViewById(R.id.rcv_sinhvien);


        //set giao dien
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(mainActivity, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        getListSinhVien();

        return view;
    }
    private void getListSinhVien()
    {
        sinhVienList =new ArrayList<>();

        StringRequest StringRequest = new StringRequest(Request.Method.GET, Server.URL_GETDATA_SV, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try {
                    JSONArray sinhvien =new JSONArray(response);

                    for (int i=0;i<sinhvien.length();i++)
                    {
                        JSONObject sinhvienObject=sinhvien.getJSONObject(i);
                        int id =sinhvienObject.getInt("id");
                        String anh =sinhvienObject.getString("anh");
                        String hotenSV  =sinhvienObject.getString("hotenSV");
                        int namsinhSV =sinhvienObject.getInt("namsinhSV");
                        String diachiSV =sinhvienObject.getString("diachiSV");

                        SinhVien sinhVien =new SinhVien(id,anh,hotenSV,namsinhSV,diachiSV);
                        sinhVienList.add(sinhVien);
                    }
                    sinhVienAdapter = new SinhVienAdapter(mainActivity,sinhVienList);
                    recyclerView.setAdapter(sinhVienAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mainActivity,"load dulieu  thất bại ",Toast.LENGTH_SHORT).show();
            }

        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(StringRequest);

    }

}