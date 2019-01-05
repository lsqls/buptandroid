package com.zhihuiye.call;

import android.app.PendingIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import  android.widget.Button;
import android.widget.EditText;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     Button makecall;
     EditText mobileText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mobileText=(EditText)this.findViewById(R.id.editText);
        makecall=(Button)this.findViewById(R.id.button);
        makecall.setOnClickListener(new  View.OnClickListener() {
            @Override
            public   void onClick(View v){
                String mobile=mobileText.getText().toString();
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+mobile));
                startActivity(intent);
            }
        });

    }

}
