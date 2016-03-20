package com.lyp.anim.pager.adpter;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by demon.li on 2016/3/20.
 */
public class SimpleImgAdapter extends android.support.v4.view.PagerAdapter {

    Context context;
    List<ImageView> imgList = new ArrayList<>();

    public SimpleImgAdapter(Context context){
             this.context = context;
    }

    /**
     * 初始化对象
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(imgList.get(position));

        return imgList.get(position);
    }

    /**
     * 销毁对象
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(imgList.get(position));
    }

    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    /**
     * 提供数据源
     * @param imgList
     */
    public void setData(List<ImageView> imgList){
         if(imgList==null||imgList.size()==0){
             return;
         }
        this.imgList = imgList;

        notifyDataSetChanged();
    }

}
