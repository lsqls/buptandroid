package com.zhihuiye.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LoginActivity extends AppCompatActivity {
    private Button reg;
    private Button login;
    private EditText count;
    private EditText pwd;
    private TextView state;
    private List<User> userList;
    private List<User> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        reg = (Button) findViewById(R.id.regin);
        login = (Button) findViewById(R.id.login);
        count = (EditText) findViewById(R.id.et1);
        pwd = (EditText) findViewById(R.id.et2);
        state = (TextView) findViewById(R.id.state);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = count.getText().toString().trim();
                String pass = pwd.getText().toString().trim();

                User user = new User();
                user.setUsername(name);
                user.setUserpwd(pass);

                int result = SqliteDB.getInstance(getApplicationContext()).saveUser(user);
                if (result == 1) {
                    state.setText("注册成功！");
                } else if (result == -1) {
                    state.setText("用户名已经存在！");
                } else {
                    state.setText("！");
                }

            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = count.getText().toString().trim();
                String pass = pwd.getText().toString().trim();
                //userList=SqliteDB.getInstance(getApplicationContext()).loadUser();
                int result = SqliteDB.getInstance(getApplicationContext()).Quer(pass, name);
                if (result == 1) {
                    state.setText("登录成功！");
                } else if (result == 0) {
                    state.setText("用户名不存在！");

                } else if (result == -1) {
                    state.setText("密码错误！");
                }
/*                for (User user : userList) {

                    if (user.getUsername().equals(name))
                    {
                        if (user.getUserpwd().equals(pass))
                        {
                            state.setText("登录成功！");

                        }else {
                            state.setText("密码错误！");

                        }
                    }
                    else {
                        state.setText("用户名不存在！");

                    }

                }*/

            }
        });
    }
}