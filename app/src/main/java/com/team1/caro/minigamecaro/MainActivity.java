package com.team1.caro.minigamecaro;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener{

    private Context context;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        context = this;
        connectView();

    }

    private void connectView() {
        //tvMain = (TextView) findViewById(R.id.tvMain);
        //findViewById(R.id.btnNewGame).setOnClickListener(this);
        //image = (ImageView) findViewById(R.id.btnNewGame);
        //findViewById(R.id.btnNewGame).setOnClickListener(this);
        //findViewById(R.id.btnOption).setOnClickListener(this);
        //findViewById(R.id.btnExit).setOnClickListener(this);
        image = (ImageView) findViewById(R.id.btnPlay);
        findViewById(R.id.btnPlay).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
//            case R.id.btnOption:
//                option();
//                break;
            case R.id.btnPlay:
                nickname();
                break;
//            case R.id.btnExit:
//                exit();
//                break;
        }
    }

    private void newgame() {
        // create intent to show Option Activity
        Intent intent = new Intent(context, NewGameActivity.class);

        // start NewGame Activity
        startActivity(intent);
    }

    private void nickname() {
        // create intent to show NickName Activity
        Intent intent = new Intent(context, NickNameActivity.class);

        // start NickName Activity
        startActivity(intent);
    }

    private void exit() {
        /*new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        System.exit(0);
                    }
                })
                .setNegativeButton("No", null)
                .show();
        */
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

}
