package com.ccbfm.cloud.world;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;

import com.ccbfm.cloud.world.model.GameModel;
import com.ccbfm.cloud.world.model.LoadModel;
import com.ccbfm.cloud.world.model.ScenesModel;
import com.ccbfm.cloud.world.model.initial.InitialLoad;
import com.ccbfm.cloud.world.widget.GameView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        GameView gameView = new GameView(this, width, height);
        gameView.setBackgroundColor(Color.rgb(119, 136, 153));
        setContentView(gameView);

        HashMap<String, GameModel> maps = new HashMap<>();
        LoadModel loadModel = new InitialLoad();
        loadModel.load(maps);

        gameView.updateView(maps.get("initial_map"));
    }

}
