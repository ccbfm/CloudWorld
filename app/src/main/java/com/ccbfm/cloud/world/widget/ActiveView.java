package com.ccbfm.cloud.world.widget;

import android.content.Context;

import com.ccbfm.cloud.world.model.ActiveModel;

public class ActiveView extends BaseView<ActiveModel> {

    public ActiveView(Context context, int width, int height) {
        super(context, width, height);
        addView(BorderView.create(context, width, height));
    }

    @Override
    public void updateView(ActiveModel model) {

    }
}
