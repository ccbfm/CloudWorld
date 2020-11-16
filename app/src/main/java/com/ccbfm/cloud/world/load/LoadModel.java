package com.ccbfm.cloud.world.load;

import android.graphics.Point;

import com.ccbfm.cloud.world.model.ScenesModel;

public abstract class LoadModel {

    public ScenesModel loadScenesModel(){
        ScenesModel mapModel = new ScenesModel();
        Point point = initPoint();
        loadScenes(mapModel);
        loadActive(mapModel);
        mapModel.initX = point.x;
        mapModel.initY = point.y;
        return mapModel;
    }

    protected abstract void loadScenes(ScenesModel scenesModel);

    protected abstract void loadActive(ScenesModel scenesModel);

    protected abstract String createKey();

    protected abstract String modelName();

    protected abstract Point initPoint();
}
