package com.ccbfm.cloud.world.load.initial;

import android.graphics.Point;

import com.ccbfm.cloud.world.load.LoadModel;
import com.ccbfm.cloud.world.model.ActiveModel;
import com.ccbfm.cloud.world.model.ScenesModel;
import com.ccbfm.cloud.world.model.SpriteType;
import com.ccbfm.cloud.world.model.SpriteUtils;


public class ScenesOne extends LoadModel {

    @Override
    protected void loadMap(int[][] map, int maxX, int maxY) {
        int endY = maxY - 1;
        int endX = maxX - 1;
        for (int i = 0; i < maxX; i++) {
            map[0][i] = SpriteType.TREE;
            map[endY][i] = SpriteType.TREE;
        }
        for (int i = 0; i < maxY; i++) {
            map[i][0] = SpriteType.TREE;
            map[i][endX] = SpriteType.TREE;
        }

        SpriteUtils.buildColumn(map, 8, 1, 3, SpriteType.TREE);
        SpriteUtils.buildColumn(map, 8, 5, 8, SpriteType.TREE);
        SpriteUtils.buildRow(map, 1, 7, 8, SpriteType.TREE);

        SpriteUtils.buildHouse(map, 2, 2, 4, 3);
        map[5][4] = SpriteType.DOOR_NORMAL_B;


    }

    @Override
    protected void loadActive(ScenesModel scenesModel) {
        ActiveModel door1 = new ActiveModel("木门");
        scenesModel.addActive(4, 5, door1);

    }

    @Override
    protected String createKey() {
        return "scenes_one";
    }

    @Override
    protected String modelName() {
        return "";
    }


    @Override
    protected Point maxPoint() {
        return new Point(30, 30);
    }

    @Override
    protected Point initPoint() {
        return new Point(5, 1);
    }
}
