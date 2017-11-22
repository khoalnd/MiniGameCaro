package com.team1.caro.minigamecaro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

//import com.team1.caro.minigamecaro.view.GomokuPanel;

public class NewGameActivity extends Activity implements View.OnClickListener{
    private TextView tvNickname;
    //private GomokuPanel mFIRPanel;
    private TextView tvScore;
    private Context context;
    private Button btnReset;
    private Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new_game);
        connectView();
        //initView();
        tvNickname = (TextView) findViewById(R.id.tvNickname);
        tvScore = (TextView) findViewById(R.id.tvScore);
        Typeface nicknameFont = Typeface.createFromAsset(getAssets(), "font/FFF_Tusj.ttf");
        Typeface scoreFont = Typeface.createFromAsset(getAssets(), "font/Chunkfive.otf");
        context = this;
        tvNickname.setTypeface(nicknameFont);
        tvScore.setTypeface(scoreFont);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra(NickNameActivity.BUNDLE);
            if (bundle != null) {
                tvNickname.setText(bundle.getString(NickNameActivity.NICKNAME));
            } else {
                tvNickname.setText(intent.getStringExtra(NickNameActivity.NICKNAME));
            }
        }

    }

    /*private void initView() {
        mFIRPanel = (GomokuPanel) findViewById(R.id.id_fir_panel);
    }*/

    private void connectView() {
        btnReset = (Button) findViewById(R.id.btnReset);
        findViewById(R.id.btnReset).setOnClickListener(this);
        btnHome = (Button) findViewById(R.id.btnHome);
        findViewById(R.id.btnHome).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnReset:
                Intent intent = new Intent(context, NewGameActivity.class);
                startActivity(intent);
                break;
            case R.id.btnHome:
                Intent intent1 = new Intent(context, MainActivity.class);
                startActivity(intent1);
                break;
        }
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_restart:
                mFIRPanel.restart();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    */
}
