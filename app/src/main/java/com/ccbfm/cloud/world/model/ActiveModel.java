package com.ccbfm.cloud.world.model;


import android.view.View;

import com.ccbfm.cloud.world.util.LogUtils;
import com.ccbfm.cloud.world.view.GameView;

public class ActiveModel extends Model {

    public int type = ActiveType.STILL_BODY;

    public ActiveModel(String name) {
        this.name = name;
    }

    public void clickEvent(GameView view){
        LogUtils.w("wds", "clickEvent-name=" + name +"," + view);
    }
}
