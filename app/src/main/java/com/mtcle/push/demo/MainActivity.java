package com.mtcle.push.demo;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mtcle.push.demo.configs.PushHelper;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainActivity extends AppCompatActivity {

    public static List<String> logList = new CopyOnWriteArrayList<String>();

    private TextView mLogView = null;

    private EditText et_alias, et_account, et_subscribe_topic;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        DemoApplication.setMainActivity(this);
        mLogView = (TextView) findViewById(R.id.log);
        et_alias = findViewById(R.id.et_alias);
        et_account = findViewById(R.id.et_account);
        et_subscribe_topic = findViewById(R.id.et_subscribe_topic);


        // 设置别名
        findViewById(R.id.set_alias).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String alias = et_alias.getText().toString();
                String account = et_account.getText().toString();
                String tag = et_subscribe_topic.getText().toString();

                Log.d("mtcle", "设置信息：\naccount:" + account + "\nalias:" + alias + "\ntag:" + tag);
                PushHelper.getInstance().setUnionIds(mContext, account, alias, tag);
            }
        });
        // 撤销别名
        findViewById(R.id.unset_alias).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        // 停止推送
        findViewById(R.id.stop_push).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PushHelper.getInstance().pausePush(mContext);
            }
        });


        findViewById(R.id.restart_push).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PushHelper.getInstance().pausePush(mContext);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshLogInfo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DemoApplication.setMainActivity(null);
    }

    public void refreshLogInfo() {
        String AllLog = "";
        for (String log : logList) {
            AllLog = AllLog + log + "\n\n";
        }
        mLogView.setText(AllLog);
    }
}
