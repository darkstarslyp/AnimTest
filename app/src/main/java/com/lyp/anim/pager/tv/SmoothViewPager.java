package com.lyp.anim.pager.tv;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

/**
 * 解决在TV中ViewPager快速切换的问题，自定实现不同滑动效果
 * Created by demon.li on 2016/3/20.
 */
public class SmoothViewPager extends ViewPager {

    private Context ctx;
    private Interpolator mInterpolator;
    private int mScrollDuration = 500; //0.5s duration

    public SmoothViewPager(Context context) {
        super(context);
        this.ctx = context;
        init();
        setScrollAttrs();
    }

    public SmoothViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.ctx = context;
        init();
        setScrollAttrs();

    }

    /**
     * init default value
     */
    void init(){
        mInterpolator = new AccelerateDecelerateInterpolator();//平滑效果

    }


    public Interpolator getmInterpolator() {
        return mInterpolator;
    }

    public void setmInterpolator(Interpolator mInterpolator) {
        this.mInterpolator = mInterpolator;
        setScrollAttrs();
    }

    public int getmScrollDuration() {
        return mScrollDuration;
    }

    public void setmScrollDuration(int mScrollDuration) {
        this.mScrollDuration = mScrollDuration;
    }

    public void setScrollAttrs(){
        try{
            Field field = ViewPager.class.getDeclaredField("mScroller");
            field.setAccessible(true);
            FixScroller fixScroller = new FixScroller(ctx,mInterpolator);
            field.set(this,fixScroller);

        }catch (Exception e){
            e.getMessage();
        }


    }

    class FixScroller extends Scroller{

        public FixScroller(Context context) {
            super(context,mInterpolator);
        }

        public FixScroller(Context context, Interpolator interpolator) {
            super(context, interpolator);
        }


        @Override
        public void startScroll(int startX, int startY, int dx, int dy) {
            super.startScroll(startX, startY, dx, dy,mScrollDuration);
        }

        @Override
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
            super.startScroll(startX, startY, dx, dy, mScrollDuration);
        }
    }
}
