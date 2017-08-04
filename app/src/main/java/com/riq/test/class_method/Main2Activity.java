package com.riq.test.class_method;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.riq.test.R;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * BigDecimal
 */
public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.ly_main)
    LinearLayout lyMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        tv.setText(new BigDecimal(1.222222222222225665151651651651651).toString() + "\n" + new BigDecimal(String.valueOf(1.22)).toString());
    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
    }
}
