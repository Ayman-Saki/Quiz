package com.example.quizapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Quiz4 extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button btnNext;
    String correctResponse = "Neil Armstrong";
    int score;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rg = findViewById(R.id.Gr4);
        btnNext = findViewById(R.id.button3);
        Intent intent = getIntent();
        score = intent.getIntExtra("score", 0);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rg.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Quiz4.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                }else{
                    rb=findViewById(rg.getCheckedRadioButtonId());
                    if(rb.getText().toString().equals(correctResponse)){
                        score++;
                    }
                    Intent intent = new Intent(getApplicationContext(), Quiz5.class);
                    intent.putExtra("score", score);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.exit,R.anim.entry);

                }
            }
        });

    }
}