package com.lyp.anim;

import android.app.Application;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by demon.li on 2016/3/29.
 */
public class AppInstance extends Application{

    private List<BaseActivty> activtyArray = new ArrayList<>();
    public  static AppInstance mAppInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppInstance = this;

    }


    public void addActivity(BaseActivty baseActivty){
        activtyArray.add(baseActivty);
    }

    public void remomeActivity(BaseActivty baseActivty){
        activtyArray.remove(baseActivty);
    }


}
