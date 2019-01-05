package com.zhihuiye.playgame;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class ShoppingActivity extends Activity {
    ItemInfo info1;
    ItemInfo info2;
    ItemInfo info3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //(1)初始化显示到界面的数据
        info1 = new ItemInfo("金剑", 20, 100, 200);
        info2 = new ItemInfo("盔甲", 35, 200, 40);
        info3 = new ItemInfo("AK47", 200, 10, 10);
        //(2)找到控件 显示数据
        TextView tv_name1 = (TextView) findViewById(R.id.tv_name1);
        TextView tv_life1 = (TextView) findViewById(R.id.tv_life1);
        TextView tv_atk1 = (TextView) findViewById(R.id.tv_atk1);
        TextView tv_speed1 = (TextView) findViewById(R.id.tv_speed1);
        TextView tv_name2 = (TextView) findViewById(R.id.tv_name2);
        TextView tv_life2 = (TextView) findViewById(R.id.tv_life2);
        TextView tv_atk2 = (TextView) findViewById(R.id.tv_atk2);
        TextView tv_speed2 = (TextView) findViewById(R.id.tv_speed2);
        TextView tv_name3 = (TextView) findViewById(R.id.tv_name3);
        TextView tv_life3 = (TextView) findViewById(R.id.tv_life3);
        TextView tv_atk3= (TextView) findViewById(R.id.tv_atk3);
        TextView tv_speed3 = (TextView) findViewById(R.id.tv_speed3);
        //(3)初始化数据 展示到控件上
        tv_name1.setText(info1.getName());
        tv_atk1.setText("攻击力：" + info1.getAcctack());
        tv_life1.setText("生命力：" + info1.getLife());
        tv_speed1.setText("敏捷度：" + info1.getSpeed());
        tv_name2.setText(info2.getName());
        tv_atk2.setText("攻击力：" + info2.getAcctack());
        tv_life2.setText("生命力：" + info2.getLife());
        tv_speed2.setText("敏捷度：" + info2.getSpeed());
        tv_name3.setText(info3.getName());
        tv_atk3.setText("攻击力：" + info3.getAcctack());
        tv_life3.setText("生命力：" + info3.getLife());
        tv_speed3.setText("敏捷度：" + info3.getSpeed());
    }
    public void click_1(View v) {
        //(1)获取当前的数据
        Intent intent1 = new Intent();
        intent1.putExtra("info", info1);
        //(2)把结果返回给调用者(mainActivity) 通过 onActivityResult 方法返回
        setResult(10, intent1);
        finish();
    }
    public void click_2(View v) {
        //(1)获取当前的数据
        Intent intent1 = new Intent();
        intent1.putExtra("info", info2);
        //(2)把结果返回给调用者(mainActivity) 通过 onActivityResult 方法返回
        setResult(10, intent1);
        finish();
    }
    public void click_3(View v) {
        //(1)获取当前的数据
        Intent intent1 = new Intent();
        intent1.putExtra("info", info3);
        //(2)把结果返回给调用者(mainActivity) 通过 onActivityResult 方法返回
        setResult(10, intent1);
        finish();
    }
}