package com.lyp.anim.image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;

import com.lyp.anim.common.CustomException;

/**
 * 创建具有倒影效果的ImageView
 * Created by demon.li on 2016/4/11.
 */
public class InvertedImage{

    /**
     *
     * @param originBitmap
     * @return
     */
    public static Bitmap convert(Bitmap originBitmap) throws CustomException {
        Bitmap result = null;
        if(originBitmap==null){
           throw new CustomException("bitmap can not be null");
        }
        int width = originBitmap.getWidth();
        int height = originBitmap.getHeight();
        Matrix matrix = new Matrix();
        // 实现图片翻转90度
        matrix.preScale(1, -1);
        // 创建倒影图片（是原始图片的一半大小）
        Bitmap reflectionImage = Bitmap.createBitmap(originBitmap, 0, height / 2, width, height / 2, matrix, false);
        // 创建总图片（原图片 + 倒影图片）
         result = Bitmap.createBitmap(width, (height + height / 2), Bitmap.Config.ARGB_8888);
        // 创建画布
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(originBitmap, 0, 0, null);
        //把倒影图片画到画布上
        canvas.drawBitmap(reflectionImage, 0, height + 1, null);
        Paint shaderPaint = new Paint();
       //创建线性渐变LinearGradient对象
        LinearGradient shader = new LinearGradient(0, originBitmap.getHeight(), 0, result.getHeight() + 1, 0x70ffffff,
                0x00ffffff, Shader.TileMode.REPEAT);
        shaderPaint.setShader(shader);
        shaderPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        //画布画出反转图片大小区域，然后把渐变效果加到其中，就出现了图片的倒影效果。
        canvas.drawRect(0, height + 1, width, result.getHeight(), shaderPaint);
        return result;
    }
}
