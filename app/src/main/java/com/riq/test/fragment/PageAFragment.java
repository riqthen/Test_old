package com.riq.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.riq.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageAFragment extends Fragment {

    @BindView(R.id.btn_finish)
    Button btnFinish;
    @BindView(R.id.ly_content)
    FrameLayout lyContent;

    Unbinder unbinder;

    FragmentManager fm;
    FragmentTransaction ft;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_a, container, false);
        unbinder = ButterKnife.bind(this, view);
        AOneFragment oneFragment = new AOneFragment();
        fm = getFragmentManager();
        ft = fm.beginTransaction();
        ft.add(R.id.ly_content, oneFragment);
        ft.commit();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
