package com.riq.test.git.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.riq.test.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 2017/8/4
 * 接收页面注册EventBus
 */
public class Main3Activity extends AppCompatActivity {

    @BindView(R.id.btn_to_second)
    Button btnToSecond;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        EventBus.getDefault().register(this);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_to_second)
    public void onViewClicked() {
        startActivity(new Intent(this, Main4Activity.class));

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent event) {
        String msg = event.getMsg();
        tv.setText(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
