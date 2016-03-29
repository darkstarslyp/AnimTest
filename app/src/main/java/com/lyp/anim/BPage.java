package com.lyp.anim;

import android.os.Bundle;
import android.view.View;

/**
 * Created by demon.li on 2016/3/29.
 */
public class BPage extends BaseActivty {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_layout);
        AppInstance.mAppInstance.addActivity(this);
        findViewById(R.id.btn_start_page_mainactivty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
