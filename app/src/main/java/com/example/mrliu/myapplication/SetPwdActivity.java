package com.example.mrliu.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetPwdActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_pwd);
    }
    private EditText et_pwd;
    private Button over;
    private void changeYzmBtn() {
        et_pwd= (EditText) findViewById(R.id.et_pwd);

        over= (Button) findViewById(R.id.btn_over);

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
        et_pwd.addTextChangedListener(textphone);
    }
    /**
     * 检查密码6位数
     */
    private void checkPhoneAndpwd() {
        if (et_pwd.getText().toString().length()>=6){
            et_pwd.setBackgroundResource(R.drawable.shape_blue);
            over.setOnClickListener(SetPwdActivity.this);
        }else {
            et_pwd.setBackgroundResource(R.drawable.shape_cd);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        case R.id.btn_next:
        Intent intent=new Intent();
        intent.setClass(this,SetPwdActivity.class);//,,,,,,,
        startActivity(intent);
        break;
    }
    }
}
