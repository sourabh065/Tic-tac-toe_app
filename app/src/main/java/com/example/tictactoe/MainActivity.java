package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public void multyPlayer(View view){
        Intent intent = new Intent(this, MultyPlayer.class);
        startActivity(intent);
    }

    public void singlePlayer(View view){
        Intent intent = new Intent(this, SinglePlayer.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}