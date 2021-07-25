package com.example.uaspakdony311810700;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.login_home);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginMainActivity2();
            }
        });
    }
    public void openLoginMainActivity2(){
        Intent intent = new Intent(this, com.example.uaspakdony311810700.MainActivity2.class);
        startActivity(intent);
    }
}