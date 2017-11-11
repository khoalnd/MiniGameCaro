package com.team1.caro.minigamecaro;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class NickNameActivity extends AppCompatActivity {
    private ImageView btnSendData;
    private EditText edtNickname;
    public static final String NICKNAME = "nickname";
    public static final String BUNDLE = "bundel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nick_name);

        btnSendData = (ImageView) findViewById(R.id.btnYes);
        //edtNickname = (EditText) findViewById(R.id.txtNickname);
        //edtNickname.setText("123");
                btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                byBundle();
            }
        });
    }

    public void byBundle() {
        Intent intent = new Intent(NickNameActivity.this, NewGameActivity.class);
        Bundle bundle = new Bundle();
        //bundle.putString(NICKNAME, edtNickname.getText().toString());
        bundle.putString(NICKNAME, "123");
                intent.putExtra(BUNDLE, bundle);
        startActivity(intent);
    }
}