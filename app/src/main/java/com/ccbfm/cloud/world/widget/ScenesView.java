package com.ccbfm.cloud.world.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.FrameLayout;

import com.ccbfm.cloud.world.model.ScenesModel;
import com.ccbfm.cloud.world.model.SpriteType;
import com.ccbfm.cloud.world.util.LogUtils;

import java.lang.ref.WeakReference;
import java.util.LinkedList;

public class ScenesView extends BaseView<ScenesModel> implements Sprite.EventListener {
    private int mGridX, mGridY, mRow, mColumn;
    private float mPaddingX, mPaddingY;
    private Paint mPaint;
    private Sprite[][] mSprites;
    private boolean mIsHelpLine = false;
    private int[][] mScenesMap;
    private int mCX, mCY, mOX, mOY;

    private boolean mIsMove = false;
    private LinkedList<Point> mMoveTrack;
    private ScenesHandler mHandler;

    public ScenesView(Context context, int width, int height) {
        super(context, width, height);
        setBackgroundColor(Color.rgb(119, 136, 153));

        mHandler = new ScenesHandler(Looper.getMainLooper(), this);
        mMoveTrack = new LinkedList<>();

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
        handleUpdateResult(map, ix, iy, true);
    }

    private void handleUpdateResult(int[][] map, int cx, int cy, boolean init) {
        if (handleUpdate(map, cx, cy, init)) {

        }
    }

    private boolean handleUpdate(int[][] map, int cx, int cy, boolean init) {
        int mx = map[0].length;
        int my = map.length;
        int column = mColumn;
        int row = mRow;
        int ox, oy;
        if (mx < column) {
            ox = (column - mx) >> 1;
            if (init) {
                cx = ox + cx;
            }
        } else if (mx > column) {
            int psx = column >> 1;
            int pmx = column - mx;
            if (init) {
                ox = psx - cx;
                //LogUtils.w("wds", "psx=" + psx + ",cx=" + cx + "," + ox + ",pmx=" + pmx);
            } else {
                //LogUtils.w("wds", "cx=" + cx + ",mOX=" + mOX);
                int mmx = cx - mOX;
                ox = psx - mmx;
                //LogUtils.w("wds", "ox=" + ox + ",mmx=" + mmx + ",ptx=" + ",cx=" + cx);
            }
            int ptx = ox - mOX;
            cx = cx + ptx;

            //LogUtils.w("wds", "ox=" + ox);
            if (ox >= 0) {
                //cx = cx + (0 - ox);
                cx = cx - ox;
                ox = 0;
            } else if (ox <= pmx) {
                //LogUtils.w("wds", "cx=" + cx);
                cx = cx + (pmx - ox);
                //LogUtils.w("wds", "cx=" + cx);
                ox = pmx;
            }
            mOX = ox;
        } else {
            ox = 0;
        }

        if (my < row) {
            oy = (row - my) >> 1;
            if (init) {
                cy = oy + cy;
            }
        } else if (my > row) {
            int psy = row >> 1;
            int pmy = row - my;
            if (init) {
                oy = psy - cy;
            } else {
                int mmy = cy - mOY;
                oy = psy - mmy;
            }
            int pty = oy - mOY;
            cy = cy + pty;

            if (oy >= 0) {
                //cy = cy + (0 - oy);
                cy = cy - oy;
                oy = 0;
            } else if (oy <= pmy) {
                cy = cy + (pmy - oy);
                oy = pmy;
            }
            mOY = oy;
        } else {
            oy = 0;
        }

        if (cx < ox || cx >= ox + mx || cy < oy || cy >= oy + my) {
            //LogUtils.w("wds", "ox=ffff" + (cx < ox) + "," + (cx >= ox + mx));
            //LogUtils.w("wds", "ox=ffff" + cy + "," +oy+ ","+my);
            return false;
        }

        //LogUtils.w("wds", "ox=" + ox + "," + oy + "," + cx + "," + cy);
        for (int i = 0; i < row; i++) {
            int ty = i - oy;
            for (int j = 0; j < column; j++) {
                int tx = j - ox;
                if (tx >= 0 && tx < mx && ty >= 0 && ty < my) {
                    if (j == cx && i == cy) {
                        mSprites[i][j].updateView(j, i, SpriteType.HUMANITY);
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
        LogUtils.w("ScenesView", "onClick-[" + x + "," + y + "]  mIsMove=" + mIsMove);
        if (mScenesMap == null) {
            return;
        }

        if (!checkMove(mScenesMap, x, y, mOX, mOY)) {
            return;
        }

        if (!mIsMove && handleMoveTrack(mMoveTrack, mScenesMap, mCX, mCY, x, y, mOX, mOY)) {
            move();
        }
        //LogUtils.w("wds", "mMoveTrack=" + mMoveTrack);
    }

    private boolean checkMove(int[][] map, int x, int y, int ox, int oy) {
        int zx = x - ox;
        int zy = y - oy;
        return checkMove(map, zx, zy);
    }

    private boolean checkMove(int[][] map, int x, int y) {
        return map[y][x] % 2 == 0;
    }

    private boolean handleMoveTrack(LinkedList<Point> track, int[][] map, int cx, int cy,
                                    int mx, int my, int ox, int oy) {
        if (cx == mx && cy == my) {
            return false;
        }

        track.clear();

        return calculateMoveTrack(track, map, cx, cy, mx, my, ox, oy);
    }

    private boolean calculateMoveTrack(LinkedList<Point> track, int[][] map, int cx, int cy,
                                       int mx, int my, int ox, int oy) {
        if (cx == mx && cy == my) {
            return true;
        }
        int ofx = mx - cx;
        int tx = cx;
        if (ofx > 0) {
            tx = cx + 1;
        } else if (ofx < 0) {
            tx = cx - 1;
        }
        if (tx != cx) {
            int xx = tx - ox;
            int xy = cy - oy;
            if (checkMove(map, xx, xy)) {
                track.add(new Point(xx, xy));
                return calculateMoveTrack(track, map, tx, cy, mx, my, ox, oy);
            }
        }

        int ofy = my - cy;
        int ty = cy;
        if (ofy > 0) {
            ty = cy + 1;
        } else if (ofy < 0) {
            ty = cy - 1;
        }

        if (ty != cy) {
            int xx = cx - ox;
            int xy = ty - oy;
            if (checkMove(map, xx, xy)) {
                track.add(new Point(xx, xy));
                return calculateMoveTrack(track, map, cx, ty, mx, my, ox, oy);
            }
        }
        return false;
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

    private static final int MOVE = 1;

    private static final int MOVE_SPEED = 200;

    private static class ScenesHandler extends Handler {

        private WeakReference<ScenesView> mScenesView;

        private ScenesHandler(Looper looper, ScenesView scenesView) {
            super(looper);
            mScenesView = new WeakReference<>(scenesView);
        }

        @Override
        public void handleMessage(Message msg) {
            if (msg.what == MOVE) {
                if (mScenesView.get() != null) {
                    mScenesView.get().move();
                }
            }
        }
    }

    private void move() {
        if (mMoveTrack.size() > 0) {
            mIsMove = true;
            Point p = mMoveTrack.removeFirst();
            handleUpdateResult(mScenesMap, p.x + mOX, p.y + mOY, false);
            mHandler.sendEmptyMessageDelayed(MOVE, MOVE_SPEED);
        } else {
            mIsMove = false;
        }
    }
}
