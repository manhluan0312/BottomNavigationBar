package com.example.bottomnavigationbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.bottomnavigationbar.API.Server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistrationActivity extends AppCompatActivity {

    EditText ed_name,ed_email,ed_pass;
    Button btn_dangky;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
         AnhXa();
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Regist();
            }
        });
    }

    private void AnhXa()
    {
        ed_name=findViewById(R.id.edt_name);
        ed_email=findViewById(R.id.edt_email);
        ed_pass=findViewById(R.id.edt_pass);
        btn_dangky=findViewById(R.id.btn_register);
    }

    private void Regist()
    {
        progressDialog =new ProgressDialog(this);
        progressDialog.setMessage("Vui lòng chờ...");
        final String name=ed_name.getText().toString().trim();
        final String email=ed_email.getText().toString().trim();
        final String pass=ed_pass.getText().toString().trim();

        if(name.isEmpty()||email.isEmpty()||pass.isEmpty())
        {
            Toast.makeText(this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_SHORT).show();
        }

        else
            {
                StringRequest StringRequest = new StringRequest(Request.Method.POST, Server.URL_REGISI, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        try {
                            JSONObject jsonObject =new JSONObject(response);
                            String suscess=jsonObject.getString("success");
                            if(suscess.equals("1")){
                                progressDialog.dismiss();
                                Toast.makeText(RegistrationActivity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                                Intent intent =new Intent(RegistrationActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        progressDialog.dismiss();
                        Toast.makeText(RegistrationActivity.this,"Đăng ký thất bại ",Toast.LENGTH_SHORT).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param =new HashMap<>();
                        param.put("username",name);
                        param.put("password",pass);
                        param.put("email",email);
                        return param ;
                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(this);
                requestQueue.add(StringRequest);

            }
}

}