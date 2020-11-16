package com.ccbfm.cloud.world.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

public class BorderView extends BaseSprite {
    private RectF mBorderRectF;
    private Paint mPaint;

    public static BorderView create(Context context, int width, int height){
        float border;
        if(width < height){
            border = width / 16.0f;
        } else {
            border = height / 16.0f;
        }
        BorderView borderView = new BorderView(context, width, height);
        borderView.setBorder(border);
        return borderView;
    }

    public BorderView(Context context, int width, int height) {
        super(context, width, height);
        mBorderRectF = new RectF(0, 0, width, height);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    public void setBorder(float border){
        mBorderRectF = new RectF(border, border, mWidth - border, mHeight - border);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = mBorderRectF;
        canvas.drawRoundRect(rectF, rectF.left, rectF.top, mPaint);
    }
}
