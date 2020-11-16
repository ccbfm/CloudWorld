package com.ccbfm.cloud.world.view;


import android.graphics.Path;

public final class PathUtils {

    public static Path createTree(float w, float h,
                                  float lx, float cx, float rx,
                                  float ty, float cy, float by) {
        Path path = new Path();
        path.moveTo(cx, 0);
        path.lineTo(0, ty);
        path.lineTo(lx, ty);
        path.lineTo(0, cy);
        path.lineTo(lx, cy);
        path.lineTo(0, by);
        path.lineTo(lx, by);
        path.lineTo(lx, h);
        path.lineTo(rx, h);
        path.lineTo(rx, by);
        path.lineTo(w, by);
        path.lineTo(rx, cy);
        path.lineTo(w, cy);
        path.lineTo(rx, ty);
        path.lineTo(w, ty);
        path.lineTo(cx, 0);
        return path;
    }

    public static Path createHumanity(float lx, float cx, float rx,
                                  float ty, float cy, float by, float r) {
        Path path = new Path();
        path.addCircle(cx, ty, r, Path.Direction.CW);
        path.moveTo(cx, ty + r);
        path.lineTo(cx, cy + r);
        path.lineTo(lx, by + r);
        path.moveTo(cx, cy + r);
        path.lineTo(rx, by + r);
        path.moveTo(lx, cy);
        path.lineTo(rx, cy);
        return path;
    }

    public static Path createDoorNormalL(int w, int h, float lx, float cx, float rx,
                                         float ty, float cy, float by) {
        Path path = new Path();
        path.moveTo(lx, 0);
        path.lineTo(lx, h);
        path.moveTo(lx, ty);
        path.lineTo(cx, ty);
        path.lineTo(cx, by);
        path.lineTo(lx, by);
        return path;
    }

    public static Path createDoorNormalR(int w, int h, float lx, float cx, float rx,
                                         float ty, float cy, float by) {
        Path path = new Path();
        path.moveTo(rx, 0);
        path.lineTo(rx, h);
        path.moveTo(rx, ty);
        path.lineTo(cx, ty);
        path.lineTo(cx, by);
        path.lineTo(rx, by);
        return path;
    }

    public static Path createDoorNormalT(int w, int h, float lx, float cx, float rx,
                                         float ty, float cy, float by) {
        Path path = new Path();
        path.moveTo(0, ty);
        path.lineTo(w, ty);
        path.moveTo(lx, ty);
        path.lineTo(lx, cy);
        path.lineTo(rx, cy);
        path.lineTo(rx, ty);
        return path;
    }

    public static Path createDoorNormalB(int w, int h, float lx, float cx, float rx,
                                      float ty, float cy, float by) {
        Path path = new Path();
        path.moveTo(0, by);
        path.lineTo(w, by);
        path.moveTo(lx, by);
        path.lineTo(lx, cy);
        path.lineTo(rx, cy);
        path.lineTo(rx, by);
        return path;
    }
}
