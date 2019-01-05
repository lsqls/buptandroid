package com.zhihuiye.playgame;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private ProgressBar pb1;
    private ProgressBar pb2;
    private ProgressBar pb3;
    private ProgressBar pb4;
    private TextView tv_main_life;
    private TextView tv_main_atk;
    private TextView tv_main_speed;
    private TextView tv_main_level;
    private TextView main_tv_1;
    private ImageView iv;
    private int i=0;
    private TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //显示 username
        Intent intent1=getIntent();
        Bundle bundle=intent1.getExtras();//.getExtras()得到 intent 所附带的额外数据
        String str=bundle.getString("username");//getString()返回指定 key 的值
        main_tv_1=(TextView) findViewById(R.id.main_tv_1);//用 TextView 显示值
        main_tv_1.setText(str+"的乔巴酱");
        //(1)找到我们关心的控件
        pb1 = (ProgressBar) findViewById(R.id.progressBar1);
        pb2 = (ProgressBar) findViewById(R.id.progressBar2);
        pb3 = (ProgressBar) findViewById(R.id.progressBar3);
        pb4 = (ProgressBar) findViewById(R.id.progressBar4);
        tv_main_life = (TextView) findViewById(R.id.tv_main_life);
        tv_main_atk = (TextView) findViewById(R.id.tv_main_atk);
        tv_main_speed = (TextView) findViewById(R.id.tv_main_speed);
        tv_main_level = (TextView) findViewById(R.id.tv_main_level);
        iv=(ImageView) findViewById(R.id.main_iv_1);
        info=(TextView) findViewById(R.id.main_people_1) ;
        //(2)初始化进度条的最大值
        pb1.setMax(1000);
        pb2.setMax(1000);
        pb3.setMax(1000);
        pb4.setMax(10);
        pb4.setProgress(1);
        tv_main_level.setText("lv"+pb4.getProgress());
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i) {
                    case 0:{
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.baby2));
                        i+=1;
                        main_tv_1.setText("吃草小老弟");
                        info.setText("米娜桑，快给吃草小老弟买装备吧！");
                        break;
                    }
                    case 1: {
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.baby3));
                        i+=1;
                        main_tv_1.setText("可达鸭");
                        info.setText("米娜桑，快给可达鸭买装备吧！");
                        break;
                    }
                    case 2:{
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.baby));
                        i=0;
                        main_tv_1.setText("乔巴酱");
                        info.setText("米娜桑，快给乔巴酱购买装备吧！");
                        break;
                    }
                }
            }
        });
    }
    public void click(View v) {
        Intent intent = new Intent(this, ShoppingActivity.class);
        startActivityForResult(intent, 1);
    }
    //当我们开启的 Activity 关闭的时候调用这个方法
    protected void onActivityResult(int requestCode, int resultCode, Intent
            data) {
        super.onActivityResult(requestCode, resultCode, data);
        //(1)代表数据来源于 shoppingActivity 取数据
        ItemInfo info = (ItemInfo) data.getExtras().get("info");
        //（2）更新一下 UI
        updateProgressBar(info);
    }
    //更新当前控件的 UI
    private void updateProgressBar(ItemInfo info) {
        //(1)获取当前 progressbar 的进展
        int progress1 = pb1.getProgress();
        int progress2 = pb2.getProgress();
        int progress3 = pb3.getProgress();
        //(2)更新一下 progressbar 的进展
        pb1.setProgress(progress1 + info.getLife());
        pb2.setProgress(progress2 + info.getAcctack());
        pb3.setProgress(progress3 + info.getSpeed());
        //更新一下 textview 的值
        tv_main_life.setText(pb1.getProgress() + "");
        tv_main_atk.setText(pb2.getProgress() + "");
        tv_main_speed.setText(pb3.getProgress() + "");
        if (pb1.getProgress()>=pb1.getMax()&&pb2.getProgress()>=pb2.getMax()&&pb3.getProgress()>=pb3.getMax())
        {
            int progress4 = pb4.getProgress();
            pb4.setProgress(progress4 + 1);
            tv_main_level.setText("lv"+pb4.getProgress());
            pb1.setMax(pb1.getMax()*2);
            pb2.setMax(pb2.getMax()*2);
            pb3.setMax(pb3.getMax()*2);
            pb1.setProgress(0);
            pb2.setProgress(0);
            pb3.setProgress(0);
            tv_main_life.setText(pb1.getProgress() + "");
            tv_main_atk.setText(pb2.getProgress() + "");
            tv_main_speed.setText(pb3.getProgress() + "");
        }
    }
}
