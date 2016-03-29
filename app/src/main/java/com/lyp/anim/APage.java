package com.lyp.anim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;

/**
 * Created by demon.li on 2016/3/29.
 */
public class APage extends BaseActivty {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_layout);
        findViewById(R.id.btn_start_page_b).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
