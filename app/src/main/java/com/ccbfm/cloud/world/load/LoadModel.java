package com.ccbfm.cloud.world.load;

import android.graphics.Point;

import com.ccbfm.cloud.world.model.ScenesModel;

public abstract class LoadModel {

    public ScenesModel loadScenesModel(){
        ScenesModel mapModel = new ScenesModel();
        mapModel.name = modelName();
        Point max = maxPoint();
        mapModel.map = new int[max.y][max.x];
        loadMap(mapModel.map, max.x, max.y);
        loadActive(mapModel);
        Point point = initPoint();
        mapModel.initX = point.x;
        mapModel.initY = point.y;
        return mapModel;
    }

    protected abstract void loadMap(int[][] map, int maxX, int maxY);

    protected abstract void loadActive(ScenesModel scenesModel);

    protected abstract String createKey();

    protected abstract String modelName();

    protected abstract Point maxPoint();

    protected abstract Point initPoint();
}
