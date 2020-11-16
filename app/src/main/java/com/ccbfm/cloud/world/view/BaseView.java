package com.ccbfm.cloud.world.view;

import android.content.Context;
import android.widget.FrameLayout;

public abstract class BaseView<M> extends FrameLayout {
    protected int mWidth, mHeight;

    public BaseView(Context context, int width, int height) {
        super(context);
        mWidth = width;
        mHeight = height;
    }

    public abstract void updateView(M model);
}
