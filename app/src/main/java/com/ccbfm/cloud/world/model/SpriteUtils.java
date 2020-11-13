package com.ccbfm.cloud.world.model;

public class SpriteUtils {

    public static void buildHouse(int[][] map, int x, int y, int ox, int oy) {
        int ex = x + ox;
        int ey = y + oy;
        map[y][x] = SpriteType.LINE_TL;
        map[y][ex] = SpriteType.LINE_TR;
        map[ey][x] = SpriteType.LINE_BL;
        map[ey][ex] = SpriteType.LINE_BR;

        for (int i = x + 1; i < ex; i++) {
            map[y][i] = SpriteType.LINE_T;
            map[ey][i] = SpriteType.LINE_B;
        }
        for (int i = y + 1; i < ey; i++) {
            map[i][x] = SpriteType.LINE_L;
            map[i][ex] = SpriteType.LINE_R;
        }
        for (int i = x + 1; i < ex; i++) {
            for (int j = y + 1; j < ey; j++) {
                map[j][i] = SpriteType.HAVE;
            }
        }
    }

    public static void buildRow(int[][] map, int x, int y, int ox, int type){
        for (int i = x; i < ox; i++) {
            map[y][i] = type;
        }
    }

    public static void buildColumn(int[][] map, int x, int y, int oy, int type){
        for (int i = y; i < oy; i++) {
            map[i][x] = type;
        }
    }
}
