package com.example.mrliu.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PhoneCodeActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_code);

        mTextView= (TextView) findViewById(R.id.tv_timer);


        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                mTextView.setText(millisUntilFinished / 1000+"s");
                mTextView.setClickable(false);
            }
            public void onFinish() {
                mTextView.setClickable(true);
                mTextView.setText("重获验证码");
                mTextView.setOnClickListener(PhoneCodeActivity.this);
            }
        }.start();
        //输入框有内容时，登陆按钮变颜色，点击事件生效
        changeYzmBtn();
    }
    private  EditText editText_yzm;
    private Button nextyzm;

    private void changeYzmBtn() {
        editText_yzm= (EditText) findViewById(R.id.et_yzm);

        nextyzm= (Button) findViewById(R.id.btn_next);

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
        editText_yzm.addTextChangedListener(textphone);
    }
    /**
     * 检查手验证码6位数
     */
    private void checkPhoneAndpwd() {
        if (editText_yzm.getText().toString().length()==6){
            nextyzm.setBackgroundResource(R.drawable.shape_blue);
            nextyzm.setOnClickListener(PhoneCodeActivity.this);
        }else {
            nextyzm.setBackgroundResource(R.drawable.shape_cd);
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_timer:
                new CountDownTimer(60000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        mTextView.setClickable(false);
                        mTextView.setText(millisUntilFinished / 1000+"s");
                    }
                    public void onFinish() {
                        mTextView.setText("重获验证码");
                    }
                }.start();
                break;
            case R.id.btn_next:
                Intent intent=new Intent();
                intent.setClass(this,SetPwdActivity.class);
                startActivity(intent);
                break;
        }
    }
}
