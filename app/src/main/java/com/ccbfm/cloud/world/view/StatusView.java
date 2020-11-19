package com.ccbfm.cloud.world.view;

import android.content.Context;

import com.ccbfm.cloud.world.model.StatusModel;

public class StatusView extends BaseView<StatusModel> {

    public StatusView(Context context, int width, int height) {
        super(context, width, height);
        setBorder(-1);
    }

    @Override
    public void updateView(StatusModel model) {

    }
}
