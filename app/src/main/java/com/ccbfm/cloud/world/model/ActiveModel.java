package com.ccbfm.cloud.world.model;


public class ActiveModel extends Model {

    public int type = ActiveType.STILL_BODY;

    public ActiveModel(String name) {
        this.name = name;
    }
}
