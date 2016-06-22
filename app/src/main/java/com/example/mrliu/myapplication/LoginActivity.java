package com.example.mrliu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //输入框有内容时，登陆按钮变颜色，点击事件生效
        changeLoginBtn();
    }
    private EditText editText_phone;
    private Button getyzm;
    private void changeLoginBtn() {
        editText_phone= (EditText) findViewById(R.id.et_phone);

        getyzm= (Button) findViewById(R.id.btn_yzm);

        TextWatcher textphone=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                checkPhoneAndpwd();
            }
        };
        editText_phone.addTextChangedListener(textphone);
    }

    /**
     * 检查手机11位数
     */
    private void checkPhoneAndpwd() {
        if (editText_phone.getText().toString().length()==11){
            getyzm.setBackgroundResource(R.drawable.shape_blue);
            getyzm.setOnClickListener(LoginActivity.this);
        }else {
            getyzm.setBackgroundResource(R.drawable.shape_cd);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_yzm:
                Intent intent=new Intent(LoginActivity.this,PhoneCodeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
