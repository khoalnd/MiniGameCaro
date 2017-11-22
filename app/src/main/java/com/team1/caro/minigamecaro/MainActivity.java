package com.team1.caro.minigamecaro;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.io.IOException;

public class MainActivity extends Activity {

    private Context context;
    private ImageView btnPlay;
    private int if_music;
    private int if_sound;
    private ImageView musicViewButton;
    //private ImageView soundViewButton;
    private GestureDetectorCompat mGestureDetector;

    MediaPlayer music = new MediaPlayer();
    CheckBox checkMusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        if_music = 0;
        if_sound = 0;

        //musicViewButton = (ImageView)findViewById(R.id.btnSpeaker);
        //soundViewButton = (ImageView)findViewById(R.id.toggleButton2);


        //nhac nen
        checkMusic = (CheckBox) findViewById(R.id.ckbMusic);
        checkMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean kt) {
                if(kt){
                    music.stop();
                } else
                    try {
                        music.prepare();
                        music.start();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

            }
        });

        music = MediaPlayer.create(this, R.raw.bgm);
        music.start();

        //link NickNameActivity
        btnPlay = (ImageView) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NickNameActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });




        //==========================================================================
        context = this;

        //mGestureDetector = new GestureDetectorCompat(this, new GestureListener());
        //hideUI();

    }
//when click back
    private void exit() {
        AlertDialog.Builder buider;
        buider = new AlertDialog.Builder(context);
        buider.setMessage("Are you sure you want to exit?")
        .setCancelable(false)
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
                System.exit(0);
            }
        })
        .setNegativeButton("No", null)
        .show();
    }

    /*private class GestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            if (getSupportActionBar() != null && getSupportActionBar().isShowing()) {
                hideUI();
            } else {
                showSystemUI();
            }
            return true;
        }
    }

    private void hideUI() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE |
                        View.SYSTEM_UI_FLAG_FULLSCREEN | //Full screen mode
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE |     //Stable when using multiple flags
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | //avoid artifacts when FLAG_FULLSCREEN
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        );
    }

    private void showSystemUI() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
    }
*/
}
