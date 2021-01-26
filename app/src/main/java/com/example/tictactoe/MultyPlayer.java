
package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MultyPlayer extends AppCompatActivity {

    int[] gameState = {2,2,2,2,2,2,2,2,2,2};

    int player1Wins = 0;
    int player2Wins = 0;

    // activePlayer values 0: player1, 1: player2 and so on
    int activePlayer = 0;

    int vacantPositions = 9;

    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    boolean gameActive = true;

    public void showImage(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]==2 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            if (activePlayer == 0) {

                //if flag is true then show image for O
                counter.setImageResource(R.drawable.tictactoeo);
                activePlayer = 1;

            } else {

                //if flag is true then show image for X
                counter.setImageResource(R.drawable.tictactoex);
                activePlayer = 0;

            }
            for (int[] positions : winningPositions) {
                if (gameState[positions[0]] == gameState[positions[1]] && gameState[positions[1]] == gameState[positions[2]] && gameState[positions[0]] != 2) {

                    gameActive = false;
                    String message ;
                    if (activePlayer == 1) {
                        message = "Player 1 ";
                        player1Wins++;
                    } else {
                        message = "Player 2 ";
                        player2Wins++;
                    }

                    TextView pointsDisplay1 = (TextView) findViewById(R.id.pointsDisplay1);
                    TextView pointsDisplay2 = (TextView) findViewById(R.id.pointsDisplay2);
                    TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
                    Button resultButton = (Button) findViewById(R.id.playAgainButton);

                    resultTextView.setText(message+getString(R.string.winner_tagline));
                    pointsDisplay1.setText(""+player1Wins);
                    pointsDisplay2.setText(""+player2Wins);

                    resultButton.setVisibility(View.VISIBLE);
                    resultTextView.setVisibility(View.VISIBLE);

                    break;
                }
            }
            vacantPositions--;
        }
        if(gameActive && vacantPositions<=0){
            TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
            Button resultButton = (Button) findViewById(R.id.playAgainButton);

            resultTextView.setText("Match Draw!");

            resultButton.setVisibility(View.VISIBLE);
            resultTextView.setVisibility(View.VISIBLE);
        }

    }

    public void playAgain(View view){
        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        Button resultButton = (Button) findViewById(R.id.playAgainButton);

        resultButton.setVisibility(View.INVISIBLE);
        resultTextView.setVisibility(View.INVISIBLE);

        Arrays.fill(gameState, 2);
        vacantPositions =9;
        gameActive = true;
        activePlayer = 0;

        androidx.gridlayout.widget.GridLayout gridLayout = findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount();i++){
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multyplayer);
    }
}
