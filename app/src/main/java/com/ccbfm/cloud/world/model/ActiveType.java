package com.ccbfm.cloud.world.model;

public interface ActiveType {
    int SPAN = 2;

    int MOVE_BODY = 1;
    int PERSON = MOVE_BODY + SPAN;

    int STILL_BODY = 0;


}
