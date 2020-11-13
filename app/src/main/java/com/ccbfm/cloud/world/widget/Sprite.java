package com.ccbfm.cloud.world.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

import com.ccbfm.cloud.world.model.SpriteType;

public class Sprite extends BaseSprite implements View.OnClickListener, View.OnLongClickListener {

    private Paint mPaint;
    private float mCX, mCY, mR;
    private float mLX, mRX, mTY, mBY;
    private int mX, mY, mType = SpriteType.NONE;
    private EventListener mEventListener;
    private Path mPath;
    private float mTranslateX, mTranslateY;

    public Sprite(Context context, int width, int height) {
        super(context, width, height);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(18);
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
    }

    public void setEventListener(EventListener eventListener) {
        mEventListener = eventListener;
    }

    public void setXY(int x, int y) {
        mX = x;
        mY = y;
    }

    public void updateView(int x, int y, int type) {
        setXY(x, y);
        mType = type;
        handlePath(type);
        invalidate();
    }

    private void handlePath(int type) {
        mPath = null;
        mTranslateX = 0f;
        mTranslateY = 0f;
        if (type == SpriteType.TREE) {
            float tx = mLX / 2f;
            float ty = mTY / 2f;
            float cx = mLX + tx;
            float sy = mBY / 4f;
            float cy = sy + sy;
            float ey = mBY - sy;
            mPath = PathUtils.createTree(mRX, mBY, mLX, cx, mCX, sy, cy, ey);
            mTranslateX = tx;
            mTranslateY = ty;
        } else if (type == SpriteType.HUMANITY) {
            float r = mTY / 2f;
            mPath = PathUtils.createHumanity(mLX, mCX, mRX, mTY, mCY, mBY, r);
        } else if(type == SpriteType.DOOR_NORMAL_L){
            mPath = PathUtils.createDoorNormalL(mWidth, mHeight, mLX, mCX, mRX, mTY, mCY, mBY);
        } else if(type == SpriteType.DOOR_NORMAL_R){
            mPath = PathUtils.createDoorNormalR(mWidth, mHeight, mLX, mCX, mRX, mTY, mCY, mBY);
        } else if(type == SpriteType.DOOR_NORMAL_T){
            mPath = PathUtils.createDoorNormalT(mWidth, mHeight, mLX, mCX, mRX, mTY, mCY, mBY);
        } else if(type == SpriteType.DOOR_NORMAL_B){
            mPath = PathUtils.createDoorNormalB(mWidth, mHeight, mLX, mCX, mRX, mTY, mCY, mBY);
        }
    }

    @Override
    public void onClick(View view) {
        if (mEventListener != null) {
            mEventListener.onClick(mX, mY);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mType == SpriteType.NONE) {
            return;
        }
        int width = mWidth;
        int height = mHeight;
        canvas.save();
        if (mType == SpriteType.CIRCLE) {
            canvas.drawCircle(mCX, mCY, mR, mPaint);
        } else if (mType == SpriteType.LINE_L) {
            canvas.drawLine(mLX, 0, mLX, height, mPaint);
        } else if (mType == SpriteType.LINE_R) {
            canvas.drawLine(mRX, 0, mRX, height, mPaint);
        } else if (mType == SpriteType.LINE_T) {
            canvas.drawLine(0, mTY, width, mTY, mPaint);
        } else if (mType == SpriteType.LINE_B) {
            canvas.drawLine(0, mBY, width, mBY, mPaint);
        } else if (mType == SpriteType.ARC_TL) {
            canvas.drawCircle(width, height, mRX, mPaint);
        } else if (mType == SpriteType.ARC_TR) {
            canvas.drawCircle(0, height, mRX, mPaint);
        } else if (mType == SpriteType.ARC_BL) {
            canvas.drawCircle(width, 0, mBY, mPaint);
        } else if (mType == SpriteType.ARC_BR) {
            canvas.drawCircle(0, 0, mBY, mPaint);
        } else if (mType == SpriteType.LINE_TL) {
            canvas.drawLine(mLX, mTY, width, mTY, mPaint);
            canvas.drawLine(mLX, mTY, mLX, height, mPaint);
        } else if (mType == SpriteType.LINE_TR) {
            canvas.drawLine(0, mTY, mRX, mTY, mPaint);
            canvas.drawLine(mRX, mTY, mRX, height, mPaint);
        } else if (mType == SpriteType.LINE_BL) {
            canvas.drawLine(mLX, mBY, width, mBY, mPaint);
            canvas.drawLine(mLX, 0, mLX, mBY, mPaint);
        } else if (mType == SpriteType.LINE_BR) {
            canvas.drawLine(0, mBY, mRX, mBY, mPaint);
            canvas.drawLine(mRX, 0, mRX, mBY, mPaint);
        } else if (mType == SpriteType.SQUARE) {
            canvas.drawRect(0, 0, width, height, mPaint);
        } else if (mPath != null) {
            canvas.translate(mTranslateX, mTranslateY);
            canvas.drawPath(mPath, mPaint);
        }
        canvas.restore();
    }

    public interface EventListener {
        void onClick(int x, int y);
    }
}
