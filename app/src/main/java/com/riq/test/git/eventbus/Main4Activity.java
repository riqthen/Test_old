package com.riq.test.git.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.riq.test.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Main4Activity extends AppCompatActivity {

    @BindView(R.id.btn_to_first)
    Button btnToFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_to_first)
    public void onViewClicked() {
        EventBus.getDefault().post(new MessageEvent("回去吧！"));
        finish();
    }
}
