package com.ccbfm.cloud.world;

import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;

import com.ccbfm.cloud.world.load.initial.InitialGame;
import com.ccbfm.cloud.world.model.GameModel;
import com.ccbfm.cloud.world.view.GameView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        GameView gameView = new GameView(this, width, height);
        setContentView(gameView);

        InitialGame initialGame = new InitialGame();
        GameModel gameModel = initialGame.load();
        gameView.updateView(gameModel);
    }

}
