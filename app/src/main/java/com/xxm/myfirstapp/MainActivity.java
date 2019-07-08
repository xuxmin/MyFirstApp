package com.xxm.myfirstapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static Pattern p =
            Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_save = findViewById(R.id.btn_save);


        final EditText et_name = findViewById(R.id.edit_name);
        final EditText et_birth = findViewById(R.id.edit_brith);
        final EditText et_email = findViewById(R.id.edit_email);
        final EditText et_phone = findViewById(R.id.edit_phone);

        final RadioGroup rd_gender = findViewById(R.id.radio_gender);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_name = et_name.getText().toString();
                String str_birth = et_birth.getText().toString();
                String str_email = et_email.getText().toString();
                String str_phone = et_phone.getText().toString();

                Log.d("MainActivity name",str_name);
                Log.d("MainActivity birth", str_birth);
                Log.d("MainActivity email", str_email);
                Log.d("MainActivity phone", str_phone);

                if ( str_name.equals("") ){

                    Toast.makeText(MainActivity.this, "请输入用户名", Toast.LENGTH_LONG).show();
                    Log.d("MainActivity", "Empty name");

                }else if ( str_birth.equals("") ){

                    Toast.makeText(MainActivity.this, "请选择生日", Toast.LENGTH_LONG).show();
                    Log.d("MainActivity", "Empty birth");

                }else if ( str_email.equals("") ) {

                    Toast.makeText(MainActivity.this, "请输入邮箱", Toast.LENGTH_LONG).show();
                    Log.d("MainActivity", "Empty email");

                }else if ( str_phone.equals("") ){

                    Toast.makeText(MainActivity.this, "请输入手机号", Toast.LENGTH_LONG).show();
                    Log.d("MainActivity", "Empty phone");

                }else if ( !isEmail(str_email) ){

                    Toast.makeText(MainActivity.this, "错误的邮箱", Toast.LENGTH_LONG).show();
                    Log.d("MainActivity", "Invalid email");

                }else if ( !isMobile(str_phone) ){

                    Toast.makeText(MainActivity.this, "错误的手机号", Toast.LENGTH_LONG).show();
                    Log.d("MainActivity", "Invalid phone");

                }else{
                    Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_LONG).show();
                    Log.d("MainActivity", "Save success");

                }
            }
        });
    }

    public static boolean isEmail(String email){
        if (null==email || "".equals(email)) return false;
        Matcher m = p.matcher(email);
        return m.matches();
    }


    public static boolean isMobile(String number) {
        String num = "[1][358]\\d{9}";
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            return number.matches(num);
        }
    }

}
