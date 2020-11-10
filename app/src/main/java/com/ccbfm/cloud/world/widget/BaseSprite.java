package com.ccbfm.cloud.world.widget;

import android.content.Context;
import android.view.View;

public abstract class BaseSprite extends View {
    protected int mWidth, mHeight;

    public BaseSprite(Context context, int width, int height) {
        super(context);
        mWidth = width;
        mHeight = height;
    }

}
