package com.lyp.anim.pager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lyp.anim.BaseActivty;
import com.lyp.anim.R;
import com.lyp.anim.pager.adpter.SimpleImgAdapter;
import com.lyp.anim.pager.transformer.LeftScaleYPageTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by demon.li on 2016/3/20.
 */
public class PagerActivity  extends BaseActivty{

    @Bind(R.id.view_pager)
    ViewPager mViewPager;
    @Bind(R.id.btn_control)
    Button mBtnControl;

    private SimpleImgAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pager_layout_one);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        int resId [] = new int[]{R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
        List<ImageView> list = new ArrayList<ImageView>();

        int length = resId.length;
        ImageView imageView;
        for(int i=0;i<length;i++){
            imageView =new ImageView(this);
            imageView.setImageResource(resId[i]);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            list.add(imageView);
        }

        adapter = new SimpleImgAdapter(this);
        mViewPager.setAdapter(adapter);
        mViewPager.setPageTransformer(true, new LeftScaleYPageTransformer());
        mViewPager.setClickable(true);
                mViewPager.getX();
        adapter.setData(list);
    }


    @OnClick(R.id.btn_control)
    void onBtncontrolClick(){
        mViewPager.performClick();

    }
}
