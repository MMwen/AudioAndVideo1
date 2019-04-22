package com.example.mwen.audioandvideo1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceViewDraw extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private Rect aa;
    private Bitmap bitmap;
    public SurfaceViewDraw(Context context) {
        super(context,null);
    }

    public SurfaceViewDraw(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public SurfaceViewDraw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //得到控制器
        surfaceHolder = getHolder();
        //对surfaceview进行操作
        surfaceHolder.addCallback(this);

        paint = new Paint();
         bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.angel);
//        int src_w = bitmap.getWidth();
//        int src_h = bitmap.getHeight();
//        float scale_w = ((float) 600) / src_w;
//        float scale_h = ((float) 400) / src_h;
//        Matrix matrix = new Matrix();
//        matrix.postScale(scale_w, scale_h);
//        dstbmp = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix,
//                true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        //重要的一点要说明.在这里可以在线程里面用canvas绘制图片,所以为什么SurfaceView比较时候绘制图片和图形
        Canvas canvas = surfaceHolder.lockCanvas();

        //开始画
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        float scale_w = ((float) 600) / src_w;
        float scale_h = ((float) 400) / src_h;
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        Bitmap dstbmp = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix,
                true);
        canvas.save();
        canvas.drawBitmap(dstbmp, matrix, paint);
        canvas.restore();
        //解锁画布
        surfaceHolder.unlockCanvasAndPost(canvas);

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
