package com.example.bottomnavigationbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
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
import java.util.Set;

public class LoginActivity extends AppCompatActivity {

    private LinearLayout dangki;
    private EditText edit_email,edit_pass;
    private Button btn_login;
    private CheckBox cb_nhomatkhau;
    private ProgressDialog progressDialog;

    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences =getSharedPreferences("datalogin",MODE_PRIVATE);
        AnhXa();
        //lay gia tri sharepre
        edit_email.setText(sharedPreferences.getString("taikhoan",""));
        edit_pass.setText(sharedPreferences.getString("matkhau",""));
        cb_nhomatkhau.setChecked(sharedPreferences.getBoolean("check",false));
         ChuyenManhinhDangKi();
         btn_login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v)
             {
                 DangNhap();
             }
         });
    }

    private void ChuyenManhinhDangKi()
    {
        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        dangki =findViewById(R.id.bancodangki);
        edit_email=findViewById(R.id.edt_loginemail);
        edit_pass=findViewById(R.id.edt_loginpass);
        btn_login=findViewById(R.id.btn_dangnhap);
        cb_nhomatkhau=findViewById(R.id.nhomatkhau);
    }
    private void DangNhap()
    {
        progressDialog =new ProgressDialog(this);
        progressDialog.setMessage("Vui l??ng ch???...");

        final String email=edit_email.getText().toString().trim();
        final String pass=edit_pass.getText().toString().trim();

        if(email.isEmpty()||pass.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Vui l??ng nh???p ?????y ????? th??ng tin",Toast.LENGTH_SHORT).show();
        }
        else
        {
            progressDialog.show();
            StringRequest StringRequest = new StringRequest(Request.Method.POST, Server.URL_LOGIN, new Response.Listener<String>() {
                @Override
                public void onResponse(String response)
                {
                    try {
                        JSONObject jsonObject =new JSONObject(response);
                        String suscess=jsonObject.getString("success");
                        if(suscess.equals("1")){
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"????ng nh???p th??nh c??ng",Toast.LENGTH_SHORT).show();
                            //kiem tra nguoi dung an nut nho tt tin dang nhap
                            if(cb_nhomatkhau.isChecked()){
                                SharedPreferences.Editor editor =sharedPreferences.edit();
                                editor.putString("taikhoan",email);
                                editor.putString("matkhau",pass);
                                editor.putBoolean("check",true);
                                editor.commit();
                            } else
                            {
                                SharedPreferences.Editor editor =sharedPreferences.edit();
                                editor.putString("taikhoan","");
                                editor.putString("matkhau","");
                                editor.putBoolean("check",false);
                                editor.commit();
                            }
                            Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        if(suscess.equals("0")){
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(),"Sai t??n t??i kho???n ho???c m???t kh???u,vui l??ng nh???p l???i",Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(getApplicationContext(),"????ng nh???p th???t b???i ",Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> param =new HashMap<>();
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