package com.ccbfm.cloud.world.load.cloud;

import com.ccbfm.cloud.world.load.LoadModel;
import com.ccbfm.cloud.world.load.LoadWorld;
import com.ccbfm.cloud.world.model.MenuModel;
import com.ccbfm.cloud.world.model.StatusModel;

import java.util.LinkedList;

public class CloudWorld extends LoadWorld {
    @Override
    protected String createKey() {
        return null;
    }

    @Override
    protected String createScenesKey() {
        return null;
    }

    @Override
    protected void getLoadModelList(LinkedList<LoadModel> models) {

    }

    @Override
    protected StatusModel loadStatus() {
        return null;
    }

}
