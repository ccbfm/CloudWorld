package com.ccbfm.cloud.world.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.FrameLayout;

import com.ccbfm.cloud.world.Config;
import com.ccbfm.cloud.world.model.Model;

public abstract class BaseView<M extends Model> extends FrameLayout {
    protected int mWidth, mHeight;
    protected Paint mPaint;
    protected RectF mBorderRectF;

    public BaseView(Context context, int width, int height) {
        super(context);
        mWidth = width;
        mHeight = height;

        initPaint();
    }

    public void setBackgroundColor() {
        setBackgroundColor(Config.COLOR_BG);
    }

    public float setBorder(float border) {
        setBackgroundColor();
        if (border == -1) {
            if (mWidth > mHeight) {
                border = mHeight / 16.0f;
            } else {
                border = mWidth / 16.0f;
            }
        }
        mBorderRectF = new RectF(border, border, mWidth - border, mHeight - border);
        return border;
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    public void updateView(M model, boolean flag){

    }

    public void updateView(M model){
        updateView(model, false);
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (mBorderRectF != null) {
            canvas.drawRoundRect(mBorderRectF, 0, 0, mPaint);
        }
    }

}
