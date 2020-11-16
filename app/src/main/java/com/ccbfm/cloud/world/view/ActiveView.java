package com.ccbfm.cloud.world.view;

import android.content.Context;

import com.ccbfm.cloud.world.model.ActiveModel;
import com.ccbfm.cloud.world.model.ScenesModel;

import java.util.LinkedList;


public class ActiveView extends BaseView<ScenesModel> implements ScenesChangeListener {
    private ScenesModel mScenesModel;

    public ActiveView(Context context, int width, int height) {
        super(context, width, height);
        addView(BorderView.create(context, width, height));
    }

    @Override
    public void updateView(ScenesModel model) {
        mScenesModel = model;
    }

    @Override
    public void change(int x, int y) {
        LinkedList<ActiveModel> activeModels = mScenesModel.getActiveModels(x, y);
        if (activeModels != null) {

        }
    }
}
