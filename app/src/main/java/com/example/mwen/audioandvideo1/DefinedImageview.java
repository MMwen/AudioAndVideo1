package com.example.mwen.audioandvideo1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.support.annotation.Nullable;

public class DefinedImageview extends View {


    public DefinedImageview(Context context) {
        super(context);
    }

    public DefinedImageview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DefinedImageview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    {

    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.angel);
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        float scale_w = ((float) 600) / src_w;
        float scale_h = ((float) 400) / src_h;
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        Bitmap dstbmp = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix,
                true);
        canvas.drawBitmap(dstbmp,0,0,new Paint());
    }
}
