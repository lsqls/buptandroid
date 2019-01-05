package com.zhihuiye.inovationcourse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ComicDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_detail);
        // 从 Intent 获取数据
        int imageId = getIntent().getIntExtra("teacher_image", 0);
        String desc = getIntent().getStringExtra("teacher_desc");
        // 获取特定的视图
        ImageView imageView = (ImageView) findViewById(R.id.comic_large_imageView);
        TextView textView = (TextView) findViewById(R.id.comic_desc_textView);
        // 根据数据设置视图展现
        imageView.setImageResource(imageId);
        textView.setText(desc);

    }

}
