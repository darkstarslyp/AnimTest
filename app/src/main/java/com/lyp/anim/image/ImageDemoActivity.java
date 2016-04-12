package com.lyp.anim.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.lyp.anim.BaseActivty;
import com.lyp.anim.R;

/**
 * Created by demon.li on 2016/4/11.
 */
public class ImageDemoActivity extends BaseActivty {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inverted_image_layout);
        ImageView imageView = (ImageView)findViewById(R.id.image_view);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.invert_image_gyy);
        try{
            imageView.setImageBitmap(InvertedImage.convert(bitmap));
        }catch (Exception e){

        }

    }
}
