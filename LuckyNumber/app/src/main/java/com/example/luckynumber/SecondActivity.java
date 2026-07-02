package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    TextView welcomeText, luckyNumberText;
    Button shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        welcomeText = findViewById(R.id.textView2);
        luckyNumberText = findViewById(R.id.numberdisplay);
        shareBtn = findViewById(R.id.btn2);

        Intent i = getIntent();
        String userName = i.getStringExtra("name");

        int randomNumber = generateRandomNumber();

        luckyNumberText.setText(""+randomNumber);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, randomNumber);
            }
        });

    }

    public int generateRandomNumber(){
        Random random = new Random();
        int upperLimit = 1000;

        return random.nextInt(upperLimit);
    }

    public void shareData(String userName, int randomNumber){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT, userName + "  got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "His lucky number is " + randomNumber);

        startActivity(Intent.createChooser(i, "Choose a Platform!"));
    }
}