package com.zhihuiye.inovationcourse;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ComicAdapter extends ArrayAdapter<Comic> {
    public ComicAdapter(Context context, int resource, List<Comic> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获取数据
        final Comic comic = getItem(position);
        // 创建布局
        View oneComicView =
                LayoutInflater.from(getContext()).inflate(R.layout.comic_item, parent, false);
        // 获取 ImageView 和 TextView
        ImageView imageView = (ImageView)
                oneComicView.findViewById(R.id.comic_small_imageView);
        TextView textView = (TextView)
                oneComicView.findViewById(R.id.comic_name_textView);
        // 根据数据设置 ImageView 和 TextView 的展现
        imageView.setImageResource(comic.getImageId());
        textView.setText(comic.getName());
        oneComicView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 初始化一个准备跳转到 TeacherDetailActivity 的 Intent
                Intent intent = new Intent(getContext(), ComicDetailActivity.class);
                // 往 Intent 中传入 Teacher 相关的数据，供 TeacherDetailActivity使用
                intent.putExtra("teacher_image", comic.getImageId());
                intent.putExtra("teacher_desc", comic.getDesc());
                // 初始化一个准备跳转到 TeacherDetailActivity 的 Intent
                getContext().startActivity(intent);
            }
        });
      /*  oneComicView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public  boolean  onLongClick(View v){
                Log.d("hi","OOOOOO");
                return true;
            }
        });*/
        return oneComicView;
    }
}

