package com.ccbfm.cloud.world.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.FrameLayout;

import com.ccbfm.cloud.world.model.ScenesModel;
import com.ccbfm.cloud.world.model.SpriteType;
import com.ccbfm.cloud.world.util.LogUtils;

public class ScenesView extends BaseView<ScenesModel> implements Sprite.EventListener {
    private int mGridX, mGridY, mRow, mColumn;
    private float mPaddingX, mPaddingY;
    private Paint mPaint;
    private Sprite[][] mSprites;
    private boolean mIsHelpLine = false;
    private int[][] mScenesMap;
    private int mCX, mCY;

    public ScenesView(Context context, int width, int height) {
        super(context, width, height);
        setBackgroundColor(Color.rgb(119, 136, 153));
        mColumn = 16;
        mGridY = mGridX = width / mColumn;
        mPaddingX = (width % mGridX) / 2.0f;
        mRow = height / mGridY;
        mPaddingY = (height % mGridY) / 2.0f;
        LogUtils.w("ScenesView", "mGridY=" + mGridY + "," + mColumn + "," + mRow);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.WHITE);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.FILL);

        mSprites = new Sprite[mRow][mColumn];
        for (int i = 0; i < mRow; i++) {
            float tm = i * mGridY + mPaddingY;
            for (int j = 0; j < mColumn; j++) {
                float lm = j * mGridX + mPaddingX;
                Sprite sprite = new Sprite(getContext(), mGridX, mGridY);
                sprite.setEventListener(this);
                sprite.setXY(j, i);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(mGridX, mGridY);
                lp.topMargin = (int) tm;
                lp.leftMargin = (int) lm;
                mSprites[i][j] = sprite;
                addView(sprite, lp);
            }
        }
    }

    @Override
    public void updateView(ScenesModel model) {
        int[][] map = model.map;
        if (map == null || map.length <= 0 || map[0].length <= 0) {
            return;
        }
        mScenesMap = map;
        int ix = model.initX;
        int iy = model.initY;
        handleUpdate(map, ix, iy, true);
    }

    private boolean handleUpdate(int[][] map, int cx, int cy, boolean init) {
        int mx = map[0].length;
        int my = map.length;
        int column = mColumn;
        int row = mRow;
        int ox, oy;
        if (mx < column) {
            ox = (column - mx) >> 1;
        } else if(mx > column){
            ox = 0;
        } else {
            ox = 0;
        }

        if (my < row) {
            oy = (row - my) >> 1;
        } else if(my > row){
            oy = 0;
        } else {
            oy = 0;
        }

        if(init){
            cx = ox + cx;
            cy = oy + cy;
        }

        if(cx < ox || cx >= ox + mx || cy < oy || cy >= oy + my){
            return false;
        }

        for (int i = 0; i < row; i++) {
            int ty = i - oy;
            for (int j = 0; j < column; j++) {
                int tx = j - ox;
                if(tx >= 0 && tx < mx && ty >= 0 && ty < my) {
                    if(j == cx && i == cy){
                        mSprites[i][j].updateView(j, i, SpriteType.CIRCLE);
                    } else {
                        mSprites[i][j].updateView(j, i, map[ty][tx]);
                    }
                } else {
                    mSprites[i][j].updateView(j, i, SpriteType.NONE);
                }
            }
        }
        mCX = cx;
        mCY = cy;
        return true;
    }

    @Override
    public void onClick(int x, int y) {
        LogUtils.w("ScenesView", "onClick-[" + x + "," + y + "]");
        if (mScenesMap == null) {
            return;
        }
        if(handleUpdate(mScenesMap, x, y, false)){

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = mHeight;
        int width = mWidth;
        float sX = mPaddingX, eX = width - sX;
        float sY = mPaddingY, eY = height - sY;
        int column = mColumn;
        int row = mRow;

        for (int i = 0, count = column + 1; i < count; i++) {
            if ((i > 0 && i < column)) {
                if (!mIsHelpLine) {
                    continue;
                }
            }
            float x = i * mGridX + sX;
            canvas.drawLine(x, sY, x, eY, mPaint);
        }

        for (int i = 0, count = row + 1; i < count; i++) {
            if ((i > 0 && i < row)) {
                if (!mIsHelpLine) {
                    continue;
                }
            }
            float h = i * mGridY + sY;
            canvas.drawLine(sX, h, eX, h, mPaint);
        }
    }


}
