package com.example.mwen.audioandvideo1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        SurfaceView surfaceView = findViewById(R.id.sfv);
        surfaceHolder = surfaceView.getHolder();
        paint = new Paint();
        paint.setColor(Color.WHITE);
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                // 锁定整个SurfaceView
                Canvas canvas = surfaceHolder.lockCanvas();
                // 绘制背景
                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.angel);
                int src_w = bitmap.getWidth();
                int src_h = bitmap.getHeight();
                float scale_w = ((float) 600) / src_w;
                float scale_h = ((float) 400) / src_h;
                Matrix matrix = new Matrix();
                matrix.postScale(scale_w, scale_h);
                Bitmap dstbmp = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix,
                        true);
                //绘制背景
                canvas.drawBitmap(dstbmp, 0, 0, null);
                // 绘制完成，释放画布，提交修改
//                surfaceHolder.unlockCanvasAndPost(canvas);
                //重新锁一次，"持久化"上次所绘制的内容
//                surfaceHolder.lockCanvas(new Rect(0, 0, 0, 0));
                surfaceHolder.unlockCanvasAndPost(canvas);

            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }
}
