package com.zhihuiye.name;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
public class MainActivity extends AppCompatActivity {
    private EditText nametext;
    private TextView showtext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show();
        nametext=(EditText)  findViewById(R.id.name) ;
        showtext=(TextView) findViewById(R.id.show) ;
        Button saveData = (Button) findViewById(R.id.save_data);
        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                String name = nametext.getText().toString();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                Date date = new Date(System.currentTimeMillis());
                String time=simpleDateFormat.format(date);
                if( name.length()>0){
                editor.putString("name", name);
                editor.putString("time",time);
                editor.apply();
                showtext.setText("输入信息是\n"+name);

                }
                else {
                    Toast.makeText(MainActivity.this,"输入内容不能为空",Toast.LENGTH_SHORT).show();
                    showtext.setText("输入内容不能为空");
                }

            }
        });
    }
    public void show() {
        SharedPreferences pref = getSharedPreferences("data", MODE_PRIVATE);
        String name = pref.getString("name", "");
        String  time=pref.getString("time","");
        showtext=(TextView) findViewById(R.id.show) ;
        showtext.setText("最后一次输入的信息是\n"+name+"\n"+time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        TextView  time1=findViewById(R.id.tv_time1);
        time1.setText("启动时间:"+simpleDateFormat.format(date));
    }
}