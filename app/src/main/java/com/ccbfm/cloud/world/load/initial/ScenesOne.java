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
            map[0][i] = SpriteType.EMPTY;
            map[endY][i] = SpriteType.EMPTY;
        }
        for (int i = 0; i < maxY; i++) {
            map[i][0] = SpriteType.EMPTY;
            map[i][endX] = SpriteType.EMPTY;
        }

        SpriteUtils.buildColumn(map, 8, 1, 2, SpriteType.TREE);
        SpriteUtils.buildColumn(map, 8, 5, 7, SpriteType.TREE);
        SpriteUtils.buildRow(map, 1, 7, 7, SpriteType.TREE);

        SpriteUtils.buildHouse(map, 2, 2, 4, 3);
        map[5][4] = SpriteType.DOOR_NORMAL_B;

        SpriteUtils.buildColumn(map, 10, 1, 7, SpriteType.TREE);
        SpriteUtils.buildColumn(map, 20, 1, 7, SpriteType.TREE);
        SpriteUtils.buildRow(map, 10, 7, 14, SpriteType.TREE);
        SpriteUtils.buildRow(map, 16, 7, 19, SpriteType.TREE);

        SpriteUtils.buildHouse(map, 11, 1, 8, 5);
        map[6][15] = SpriteType.DOOR_NORMAL_B;

        SpriteUtils.buildColumn(map, 21, 1, 7, SpriteType.TREE);

        SpriteUtils.buildHouse(map, 22, 1, 2, 2);
        map[3][23] = SpriteType.DOOR_NORMAL_B;

        SpriteUtils.buildHouse(map, 26, 1, 2, 2);
        map[3][27] = SpriteType.DOOR_NORMAL_B;

        SpriteUtils.buildHouse(map, 22, 5, 2, 2);
        map[7][23] = SpriteType.DOOR_NORMAL_B;

        SpriteUtils.buildHouse(map, 26, 5, 2, 2);
        map[7][27] = SpriteType.DOOR_NORMAL_B;

        SpriteUtils.buildColumn(map, 21, 9, 15, SpriteType.TREE);
        SpriteUtils.buildRow(map, 21, 16, 28, SpriteType.TREE);
    }

    @Override
    protected void loadActive(ScenesModel scenesModel) {
        ActiveModel door1 = new ActiveModel("木门");
        scenesModel.addActive(4, 5, door1);
        ActiveModel door2 = new ActiveModel("铁门");
        scenesModel.addActive(15, 6, door2);
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
        return new Point(15, 12);
    }
}
