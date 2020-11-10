package com.ccbfm.cloud.world.widget;

import android.content.Context;

import com.ccbfm.cloud.world.model.StatusModel;

public class StatusView extends BaseView<StatusModel> {

    public StatusView(Context context, int width, int height) {
        super(context, width, height);

        addView(BorderView.create(context, width, height));
    }

    @Override
    public void updateView(StatusModel model) {

    }
}
