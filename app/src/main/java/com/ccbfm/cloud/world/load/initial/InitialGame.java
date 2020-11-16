package com.ccbfm.cloud.world.load.initial;

import com.ccbfm.cloud.world.load.LoadGame;
import com.ccbfm.cloud.world.load.LoadModel;
import com.ccbfm.cloud.world.model.MenuModel;
import com.ccbfm.cloud.world.model.StatusModel;

import java.util.LinkedList;

public class InitialGame extends LoadGame {

    @Override
    protected void getLoadModelList(LinkedList<LoadModel> models) {
        models.add(new ScenesOne());
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
    protected String createScenesKey() {
        return "scenes_one";
    }
}
