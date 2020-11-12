package com.ccbfm.cloud.world.model.initial;

import android.graphics.Point;

import com.ccbfm.cloud.world.model.ActiveModel;
import com.ccbfm.cloud.world.model.LoadModel;
import com.ccbfm.cloud.world.model.MenuModel;
import com.ccbfm.cloud.world.model.ScenesModel;
import com.ccbfm.cloud.world.model.SpriteType;
import com.ccbfm.cloud.world.model.StatusModel;

public class InitialLoad extends LoadModel {
    private static final int COLUMN = 36;
    private static final int ROW = 10;//18;

    @Override
    protected void loadScenes(ScenesModel mapModel) {
        int[][] map = new int[ROW][COLUMN];
        int endR = ROW - 1;
        int endC = COLUMN - 1;
        for (int i = 0; i < COLUMN; i++) {
            if (i % 2 == 0) {
                map[0][i] = SpriteType.SQUARE;
                map[endR][i] = SpriteType.SQUARE;
            } else {
                int ii = i % 16;
                map[0][i] =  ii;
                map[endR][i] = ii;
            }
        }
        for (int i = 0; i < ROW; i++) {
            map[i][0] = SpriteType.SQUARE;
            map[i][endC] = SpriteType.SQUARE;
        }
        mapModel.map = map;
    }

    @Override
    protected ActiveModel loadActive() {
        return null;
    }

    @Override
    protected StatusModel loadStatus() {
        return null;
    }

    @Override
    protected MenuModel loadMenu() {
        return null;
    }

    @Override
    protected String createKey() {
        return "initial_map";
    }

    @Override
    protected Point initPoint() {
        return new Point(33,9);
    }

}
