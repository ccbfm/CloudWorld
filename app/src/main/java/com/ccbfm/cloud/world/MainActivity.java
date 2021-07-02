package com.ccbfm.cloud.world;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.ccbfm.cloud.world.load.initial.InitialWorld;
import com.ccbfm.cloud.world.model.GameModel;
import com.ccbfm.cloud.world.view.GameView;

public class MainActivity extends AppCompatActivity {

    private static final String VIEW_WIDTH = "VIEW_WIDTH";
    private static final String VIEW_HEIGHT = "VIEW_HEIGHT";

    public static void start(Context context, int width, int height){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(VIEW_WIDTH, width);
        intent.putExtra(VIEW_HEIGHT, height);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        Intent intent = getIntent();
        int width = 0, height = 0;
        if(intent != null){
            width = intent.getIntExtra(VIEW_WIDTH, 0);
            height = intent.getIntExtra(VIEW_HEIGHT, 0);
        }
        if(width == 0 || height == 0){
            DisplayMetrics metrics = getResources().getDisplayMetrics();
            width = metrics.widthPixels;
            height = metrics.heightPixels;
        }

        GameView gameView = new GameView(this, width, height);
        setContentView(gameView);

        InitialWorld initialGame = new InitialWorld();
        GameModel gameModel = initialGame.load();
        gameView.updateView(gameModel);
    }

    @Override
    public void onBackPressed() {

    }
}
