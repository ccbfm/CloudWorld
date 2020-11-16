package com.ccbfm.cloud.world.load;

import com.ccbfm.cloud.world.model.GameModel;
import com.ccbfm.cloud.world.model.MenuModel;
import com.ccbfm.cloud.world.model.StatusModel;

import java.util.LinkedList;

public abstract class LoadGame {

    public GameModel load(){
        GameModel gameModel = new GameModel();
        gameModel.setKey(createKey());
        gameModel.setStatusModel(loadStatus());
        gameModel.setMenuModel(loadMenu());
        LinkedList<LoadModel> loadModels = new LinkedList<>();
        getLoadModelList(loadModels);

        gameModel.setScenesKey(createScenesKey());
        for (LoadModel model : loadModels) {
            String key = model.createKey();
            gameModel.putScenesModel(key, model.loadScenesModel());
        }
        return gameModel;
    }

    protected abstract String createKey();

    protected abstract String createScenesKey();

    protected abstract void getLoadModelList(LinkedList<LoadModel> models);

    protected abstract StatusModel loadStatus();

    protected abstract MenuModel loadMenu();
}
