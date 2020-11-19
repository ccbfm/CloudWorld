package com.ccbfm.cloud.world.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;

import androidx.appcompat.widget.AppCompatTextView;

public abstract class BaseSprite extends AppCompatTextView {
    protected int mWidth, mHeight;
    protected Paint mPaint;

    public BaseSprite(Context context, int width, int height) {
        super(context);
        mWidth = width;
        mHeight = height;
        setWidth(width);
        setHeight(height);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(18);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
    }

}
