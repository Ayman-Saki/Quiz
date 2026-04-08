package com.example.quizapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    EditText name, email, password, confirm;
    Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.Name);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.RegisterPassword);
        confirm = findViewById(R.id.ConfirmPassword);
        button = findViewById(R.id.signbutton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String conf = confirm.getText().toString().trim();

                if (TextUtils.isEmpty(mail)) {
                    Toast.makeText(MainActivity2.this, "Please fill the email field", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity2.this, "Please fill the password field", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(conf)) {
                    Toast.makeText(MainActivity2.this, "Please fill the confirm password field", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!pass.equals(conf)) {
                    Toast.makeText(MainActivity2.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Success
                Toast.makeText(MainActivity2.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
