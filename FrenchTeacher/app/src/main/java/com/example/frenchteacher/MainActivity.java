package com.example.frenchteacher;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button blackBtn, greenBtn, purpleBtn, redBtn, yellowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        blackBtn = findViewById(R.id.black_btn);
        greenBtn = findViewById(R.id.green_btn);
        purpleBtn = findViewById(R.id.purple_btn);
        redBtn = findViewById(R.id.red_btn);
        yellowBtn = findViewById(R.id.yellow_btn);

        blackBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        redBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);

       /* blackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(
                        MainActivity.this,
                        R.raw.black
                );
                mediaPlayer.start();
            }
        });
        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(
                        MainActivity.this,
                        R.raw.green
                );
                mediaPlayer.start();
            }
        });
        purpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(
                        MainActivity.this,
                        R.raw.purple
                );
                mediaPlayer.start();
            }
        });
        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(
                        MainActivity.this,
                        R.raw.red
                );
                mediaPlayer.start();
            }
        });
        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(
                        MainActivity.this,
                        R.raw.yellow
                );
                mediaPlayer.start();
            }
        }); */

    }

    @Override
    public void onClick(View v) {
        int clickedBtnID = v.getId();

        if (clickedBtnID == R.id.black_btn){
            playSounds(R.raw.black);
        } else if (clickedBtnID == R.id.green_btn) {
            playSounds(R.raw.green);
        }else if (clickedBtnID == R.id.purple_btn) {
            playSounds(R.raw.purple);
        }else if (clickedBtnID == R.id.red_btn) {
            playSounds(R.raw.red);
        }else if (clickedBtnID == R.id.yellow_btn) {
            playSounds(R.raw.yellow);
        }
    }

    public void playSounds(int id){
        MediaPlayer mediaPlayer = MediaPlayer.create(
                MainActivity.this,
                id
        );
        mediaPlayer.start();
    }
}