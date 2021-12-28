package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.card.MaterialCardView;

public class EnterActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        MaterialCardView cardView = findViewById(R.id.cardView);
        cardView.setOnClickListener(v->{
            intent = new Intent(this , MainActivity.class);
            startActivity(intent);
        });

    }


}