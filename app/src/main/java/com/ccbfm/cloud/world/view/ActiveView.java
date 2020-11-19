package com.ccbfm.cloud.world.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ccbfm.cloud.world.model.ActiveModel;
import com.ccbfm.cloud.world.model.ActiveType;
import com.ccbfm.cloud.world.model.ScenesModel;
import com.ccbfm.cloud.world.util.LogUtils;

import java.util.LinkedList;


public class ActiveView extends BaseView<ScenesModel> implements ScenesChangeListener {
    private ScenesModel mScenesModel;
    private RecyclerAdapter mAdapter;

    public ActiveView(Context context, int width, int height) {
        super(context, width, height);
        int border = (int) setBorder(-1);
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        int zw = width - border - border;
        int zh = height - border - border;
        int w = zw >> 2;
        int h = zh / 3;
        mAdapter = new RecyclerAdapter(context, w, h);
        recyclerView.setAdapter(mAdapter);
        LayoutParams lp = new LayoutParams(zw, zh);
        lp.gravity = Gravity.CENTER;
        lp.topMargin = border;
        lp.bottomMargin = border;
        lp.leftMargin = border;
        lp.rightMargin = border;
        addView(recyclerView, lp);
    }

    @Override
    public void updateView(ScenesModel model) {
        mScenesModel = model;
    }

    @Override
    public void change(int x, int y) {
        LinkedList<ActiveModel> activeModels = mScenesModel.getActiveModels(x, y);

        mAdapter.setActiveModels(activeModels);
    }

    private class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
        private LinkedList<ActiveModel> mActiveModels;
        private Context mContext;
        private int mWidth, mHeight;

        public RecyclerAdapter(Context context, int width, int height) {
            mContext = context;
            mWidth = width;
            mHeight = height;
        }

        public void setActiveModels(LinkedList<ActiveModel> activeModels) {
            if (mActiveModels == activeModels) {
                return;
            }
            mActiveModels = activeModels;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(new ActiveItem(mContext, mWidth, mHeight));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.activeItem.setModel(getData(position));
        }

        @Override
        public int getItemCount() {
            return mActiveModels == null ? 0 : mActiveModels.size();
        }

        public ActiveModel getData(int position) {
            if (mActiveModels != null) {
                return mActiveModels.get(position);
            }
            return null;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ActiveItem activeItem;

        public ViewHolder(@NonNull ActiveItem itemView) {
            super(itemView);
            this.activeItem = itemView;
        }
    }

    private class ActiveItem extends BaseSprite {

        private ActiveModel mModel;
        private float mCX, mCY, mX2, mX4, mX8;
        private Path mPath;

        public ActiveItem(Context context, int width, int height) {
            super(context, width, height);
            mPaint.setTextSize(height / 3.0f);
            mCX = width / 2.0f;
            mCY = height / 2.0f;
            mX2 = mCX / 2.0f;
            mX4 = mCX / 4.0f;
            mX8 = mCX / 8.0f;
        }

        public void setModel(ActiveModel model) {
            mModel = model;
            if (mModel != null) {
                int type = mModel.type;
                float x4 = mX4;
                float x8 = mX8;
                if (type == ActiveType.STILL_BODY) {
                    mPath = new Path();
                    mPath.moveTo(x8, mCY - x8);
                    mPath.lineTo(x8, mCY + x8);
                    mPath.lineTo(x4 + x8, mCY + x8);
                    mPath.lineTo(x4 + x8, mCY - x8);
                    mPath.lineTo(x8, mCY - x8);
                } else if (type == ActiveType.MOVE_BODY) {
                    mPath = new Path();
                    mPath.addCircle(x4, mCY, x8, Path.Direction.CW);
                } else if (type == ActiveType.PERSON) {
                    mPath = new Path();
                    mPath.addCircle(x4, mCY, x8, Path.Direction.CW);
                }
                invalidate();
            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (mModel != null) {
                if (mPath != null) {
                    mPaint.setStyle(Paint.Style.STROKE);
                    canvas.drawPath(mPath, mPaint);
                }
                if(!TextUtils.isEmpty(mModel.name)) {
                    mPaint.setStyle(Paint.Style.FILL);
                    Paint.FontMetrics metrics = mPaint.getFontMetrics();
                    float distance = (metrics.bottom - metrics.top) / 2 - metrics.bottom;
                    canvas.drawText(mModel.name, mX2, mCY + distance, mPaint);
                }
            }
        }
    }
}
