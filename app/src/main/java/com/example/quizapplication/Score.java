package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Score extends AppCompatActivity {

    ProgressBar pb;
    TextView tvscore;
    Button btnAgain, btnLogout;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        pb = findViewById(R.id.progressBar);
        tvscore = findViewById(R.id.textView4);
        btnAgain=findViewById(R.id.button);
        btnLogout=findViewById(R.id.btnryAgain);
        Intent i1=getIntent();
        score=i1.getIntExtra("score",0);
        tvscore.setText(100*score/5+"%");
        pb.setProgress(100*score/5);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Score.this,"Merci pour votre participation",
                        Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();

            }
        });
        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Quiz1.class));
                finish();
            }
        });

    }
}