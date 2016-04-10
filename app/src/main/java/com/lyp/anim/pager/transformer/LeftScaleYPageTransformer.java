package com.lyp.anim.pager.transformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by demon.li on 2016/4/10.
 */
public class LeftScaleYPageTransformer implements ViewPager.PageTransformer {

    private float MIN_SCALE = 0.2F;

    @Override
    public void transformPage(View page, float position) {
           if(position<=0){
               page.setAlpha(1-Math.abs(position)+MIN_SCALE);
               page.setScaleY(1-Math.abs(position));
           }else{
               if(position+MIN_SCALE>1){
                   page.setAlpha(1-position);
               }else{
                  page.setAlpha(1-position+MIN_SCALE);
               }
           }
    }
}
