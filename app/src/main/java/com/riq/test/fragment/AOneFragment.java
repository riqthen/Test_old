package com.riq.test.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.riq.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AOneFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.btn_cancel)
    Button btnCancel;
    @BindView(R.id.btn_ok)
    Button btnOk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aone, container, false);
        unbinder = ButterKnife.bind(this, view);
        ATwoFragment twoFragment = new ATwoFragment();
        AThreeFragment threeFragment = new AThreeFragment();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_cancel, R.id.btn_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                break;
            case R.id.btn_ok:
                break;
        }
    }
}
