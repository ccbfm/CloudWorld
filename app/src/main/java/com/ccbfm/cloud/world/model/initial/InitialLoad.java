package com.ccbfm.cloud.world.model.initial;

import android.graphics.Point;

import com.ccbfm.cloud.world.model.ActiveModel;
import com.ccbfm.cloud.world.model.LoadModel;
import com.ccbfm.cloud.world.model.MenuModel;
import com.ccbfm.cloud.world.model.ScenesModel;
import com.ccbfm.cloud.world.model.SpriteType;
import com.ccbfm.cloud.world.model.SpriteUtils;
import com.ccbfm.cloud.world.model.StatusModel;

public class InitialLoad extends LoadModel {
    private static final int COLUMN = 30;
    private static final int ROW = 30;

    @Override
    protected void loadScenes(ScenesModel mapModel) {
        int[][] map = new int[ROW][COLUMN];
        int endR = ROW - 1;
        int endC = COLUMN - 1;
        for (int i = 0; i < COLUMN; i++) {
            map[0][i] = SpriteType.TREE;
            map[endR][i] = SpriteType.TREE;
        }
        for (int i = 0; i < ROW; i++) {
            map[i][0] = SpriteType.TREE;
            map[i][endC] = SpriteType.TREE;
        }

        SpriteUtils.buildColumn(map, 8, 1, 3, SpriteType.TREE);
        SpriteUtils.buildColumn(map, 8, 5, 8, SpriteType.TREE);
        SpriteUtils.buildRow(map, 1, 7, 8, SpriteType.TREE);

        SpriteUtils.buildHouse(map, 2, 2, 4, 3);
        map[5][4] = SpriteType.DOOR_NORMAL_B;

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
        return new Point(5, 1);
    }

}
