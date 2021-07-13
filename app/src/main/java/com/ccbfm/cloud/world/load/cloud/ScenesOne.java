package com.ccbfm.cloud.world.load.cloud;

import android.graphics.Point;

import com.ccbfm.cloud.world.load.LoadModel;
import com.ccbfm.cloud.world.model.ScenesModel;

public class ScenesOne extends LoadModel
{
    @Override
    protected void loadMap(int[][] map, int maxX, int maxY) {

    }

    @Override
    protected void loadActive(ScenesModel scenesModel) {

    }

    @Override
    protected String createKey() {
        return "scenes_one";
    }

    @Override
    protected String modelName() {
        return null;
    }

    @Override
    protected Point maxPoint() {
        return null;
    }

    @Override
    protected Point initPoint() {
        return null;
    }
}
