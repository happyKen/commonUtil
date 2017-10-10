package com.common.myutil.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by wangzekeng on 2017/10/9.
 */

public class AnimateView extends View {
    float radius = 10;
    Paint paint;

    public AnimateView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,radius++,paint);
        if(radius > 100){
            radius = 10;
        }
        invalidate();//会调用onDraw
    }
}
