package com.common.myutil.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.common.myutil.utils.LogUtils;

/**
 * Created by wangzekeng on 2017/10/9.
 */

public class DemoSurfaceView extends SurfaceView implements SurfaceHolder.Callback ,Runnable{
    SurfaceHolder surfaceHolder;
    private int radius = 10;
    public boolean isRunning;
    private Paint mPaint;
    Canvas canvas;
    public DemoSurfaceView(Context context) {
        super(context);

        init();
    }

    private void init() {
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setFocusable(true);//是否获得焦点
        setFocusableInTouchMode(true);//是否通过触摸获得焦点
        this.setKeepScreenOn(true);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        initView();
        isRunning = true;
        LogUtils.d("draw thread");
        //绘制线程
        new Thread(this).start();
    }


    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isRunning = false;
    }


    @Override
    public void run() {
        while (isRunning) {
           doDraw();
        }
    }

    private void doDraw() {
        try {
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.WHITE);
            canvas.translate(200, 200);
            canvas.drawCircle(0, 0, radius++, mPaint);

            if (radius > 100) {
                radius = 10;
            }
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("draw fail");
        }finally {
            if(canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

    }





}
