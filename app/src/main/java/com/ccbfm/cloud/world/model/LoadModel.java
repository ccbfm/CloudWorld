package com.ccbfm.cloud.world.model;

import android.graphics.Point;

import com.ccbfm.cloud.world.util.CheckUtils;

import java.util.Map;

public abstract class LoadModel {

    public void load(Map<String, GameModel> maps){
        CheckUtils.checkNotNull(maps);
        String key = createKey();


        GameModel gameModel = new GameModel();
        gameModel.key = key;
        maps.put(key, gameModel);

        ScenesModel mapModel = new ScenesModel();
        Point point = initPoint();
        loadScenes(mapModel);

        mapModel.initX = point.x;
        mapModel.initY = point.y;
        gameModel.setScenesModel(mapModel);

        ActiveModel activeModel = loadActive();
        gameModel.setActiveModel(activeModel);

        StatusModel statusModel = loadStatus();
        gameModel.setStatusModel(statusModel);

        MenuModel menuModel = loadMenu();
        gameModel.setMenuModel(menuModel);
    }

    protected abstract void loadScenes(ScenesModel mapModel);

    protected abstract ActiveModel loadActive();

    protected abstract StatusModel loadStatus();

    protected abstract MenuModel loadMenu();

    protected abstract String createKey();

    protected abstract Point initPoint();
}
