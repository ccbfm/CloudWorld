package com.ccbfm.cloud.world.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.ccbfm.cloud.world.model.SpriteType;

import java.util.Random;

public class Sprite extends BaseSprite implements View.OnClickListener, View.OnLongClickListener {

    private Paint mPaint;
    private float mCX, mCY, mR;
    private float mLX, mRX, mTY, mBY;
    private int mX, mY, mType = SpriteType.NONE;
    private EventListener mEventListener;

    public Sprite(Context context, int width, int height) {
        super(context, width, height);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);

        mCX = width / 2.0f;
        mCY = mHeight / 2.0f;
        mR = mCX;

        mLX = width / 4.0f;
        mRX = width - mLX;
        mTY = height / 4.0f;
        mBY = height - mTY;

        setOnClickListener(this);
        setOnLongClickListener(this);
        mType = new Random().nextInt(10) + 1;
    }

    public void setEventListener(EventListener eventListener) {
        mEventListener = eventListener;
    }

    public void setXY(int x, int y){
        mX = x;
        mY = y;
    }

    public void updateView(int x, int y, int type) {
        setXY(x, y);
        mType = type;
        invalidate();
    }

    @Override
    public void onClick(View view) {
        if(mEventListener != null){
            mEventListener.onClick(mX, mY);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = mWidth;
        int height = mHeight;
        if (mType == SpriteType.NONE) {
            return;
        }
        if (mType == SpriteType.CIRCLE) {
            canvas.drawCircle(mCX, mCY, mR, mPaint);
        } else if (mType == SpriteType.LINE_LEFT) {
            canvas.drawLine(mLX, 0, mLX, height, mPaint);
        } else if (mType == SpriteType.LINE_RIGHT) {
            canvas.drawLine(mRX, 0, mRX, height, mPaint);
        } else if (mType == SpriteType.LINE_TOP) {
            canvas.drawLine(0, mTY, width, mTY, mPaint);
        } else if (mType == SpriteType.LINE_BOTTOM) {
            canvas.drawLine(0, mBY, 0, mBY, mPaint);
        } else if (mType == SpriteType.ARC_TL) {
            canvas.drawCircle(width, height, mRX, mPaint);
        } else if (mType == SpriteType.ARC_TR) {
            canvas.drawCircle(0, height, mRX, mPaint);
        } else if (mType == SpriteType.ARC_BL) {
            canvas.drawCircle(width, 0, mBY, mPaint);
        } else if (mType == SpriteType.ARC_BR) {
            canvas.drawCircle(0, 0, mBY, mPaint);
        } else if (mType == SpriteType.SQUARE) {
            canvas.drawRect(0, 0, width, height, mPaint);
        }
    }

    public interface EventListener {
        void onClick(int x, int y);
    }
}
