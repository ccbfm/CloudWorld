package com.ccbfm.cloud.world.model;

public interface SpriteType {
    int SPAN = 2;

    int NONE = 0;
    int CIRCLE = NONE + SPAN;
    int SQUARE = CIRCLE + SPAN;
    int HUMANITY = SQUARE + SPAN;
    int DOOR_NORMAL_L = HUMANITY + SPAN;
    int DOOR_NORMAL_R = DOOR_NORMAL_L + SPAN;
    int DOOR_NORMAL_T = DOOR_NORMAL_R + SPAN;
    int DOOR_NORMAL_B = DOOR_NORMAL_T + SPAN;


    int HAVE = 1;
    int LINE_T = HAVE + SPAN;
    int LINE_B = LINE_T + SPAN;
    int LINE_L = LINE_B + SPAN;
    int LINE_R = LINE_L + SPAN;
    int LINE_TL = LINE_R + SPAN;
    int LINE_TR = LINE_TL + SPAN;
    int LINE_BL = LINE_TR + SPAN;
    int LINE_BR = LINE_BL + SPAN;
    int ARC_TL = LINE_BR + SPAN;
    int ARC_TR = ARC_TL + SPAN;
    int ARC_BL = ARC_TR + SPAN;
    int ARC_BR = ARC_BL + SPAN;
    int TREE = ARC_BR + SPAN;
}
