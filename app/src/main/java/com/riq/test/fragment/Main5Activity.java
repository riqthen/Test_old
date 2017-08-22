package com.riq.test.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.riq.mylibrary.utils.Lc;
import com.riq.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main5Activity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager vp;

    List<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ButterKnife.bind(this);
        fragments.add(new PageAFragment());
        fragments.add(new PageBFragment());
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragments));
        Lc.print("88888888", "222");
        Lc.print(new String[]{"1", "2"});
        Lc.print("你好", new String[]{"1", "2"});
    }

}
