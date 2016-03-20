package com.lyp.anim;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by demon.li on 2016/3/20.
 */
public class BaseActivty extends AppCompatActivity {

    public Context ctx;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
    }
}
