package com.ccbfm.cloud.world.widget;

import android.content.Context;
import android.widget.FrameLayout;

import com.ccbfm.cloud.world.model.Model;

public abstract class BaseView<M extends Model> extends FrameLayout {
    protected int mWidth, mHeight;

    public BaseView(Context context, int width, int height) {
        super(context);
        mWidth = width;
        mHeight = height;
    }

    public abstract void updateView(M model);
}
