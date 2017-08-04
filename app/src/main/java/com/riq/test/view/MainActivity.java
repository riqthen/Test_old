package com.riq.test.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.riq.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * AutoCompleteTextView
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    AutoCompleteTextView tv;
    String[] s = {"1111", "11112", "3", "232"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, s);
        tv.setAdapter(arrayAdapter);
        tv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "position" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
