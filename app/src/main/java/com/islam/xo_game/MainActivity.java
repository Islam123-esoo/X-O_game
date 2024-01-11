package com.islam.xo_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout p ;
    TextView playerScoreOne;
    TextView playerScoreTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playerScoreOne=findViewById(R.id.score1);
        playerScoreTwo =findViewById(R.id.score2);
        p=findViewById(R.id.p);
        initializeBoardState();
    }
    ArrayList <String>  boardState;
    int counter = 0;
    int playerScore1=0;
    int playerScore2=0;

    int mScore=100;
    private void max (){
        if (playerScore1 >=mScore){
            Toast.makeText(this, "THE PLAYER (X) IS WINNER", Toast.LENGTH_SHORT).show();
            playerScore1=0;
            playerScore2=0;
            playerScoreOne.setText(playerScore1);
            playerScoreTwo.setText(playerScore2);
            return;
        }else if (playerScore2>=mScore ){
            Toast.makeText(this, "THE PLAYER (O) IS WINNER", Toast.LENGTH_SHORT).show();
            playerScore1=0;
            playerScore2=0;
            playerScoreOne.setText(playerScore1);
            playerScoreTwo.setText(playerScore2);
            return;
        }

    }
    private void  initializeBoardState(){
        boardState=new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            boardState.add("");
        }
        for (int i = 0; i < p.getChildCount(); i++) {
            View  view = p.getChildAt(i);
            if (view instanceof Button){
                ((Button)view).setText("");
            }

        }
    }
    private void putPlayerSymbolInBoardState(int id ,String playerSymbol){
            if (id== R.id.button1){
                boardState.set(0,playerSymbol);
            }else if (id== R.id.button2){
                boardState.set(1,playerSymbol);
            }else if (id== R.id.button3){
                boardState.set(2,playerSymbol);
            }else if (id== R.id.button4){
                boardState.set(3,playerSymbol);
            }else if (id== R.id.button5){
                boardState.set(4,playerSymbol);
            }else if (id== R.id.button6){
                boardState.set(5,playerSymbol);
            }else if (id== R.id.button7){
                boardState.set(6,playerSymbol);
            }else if (id== R.id.button8){
                boardState.set(7,playerSymbol);
            }else if (id== R.id.button9){
                boardState.set(8,playerSymbol);
            }
        }

    private boolean checkWinner(String playerSymbol){
        for (int i = 0; i < 9; i+=3)
        {
                if (boardState.get(i).equals(playerSymbol)
                    && boardState.get(i+1).equals(playerSymbol)
                    && boardState.get(i+2).equals(playerSymbol))
                {
                return true;
                }
        }
        for (int i = 0; i < 3; i++) {
            if (boardState.get(i).equals(playerSymbol)
                    && boardState.get(i+3).equals(playerSymbol)
                    && boardState.get(i+6).equals(playerSymbol))
            {
                return true;
            }

        }
        if (boardState.get(0).equals(playerSymbol)
                && boardState.get(4).equals(playerSymbol)
                && boardState.get(8).equals(playerSymbol))
        {
            return true;
        }
        if (boardState.get(2).equals(playerSymbol)
                && boardState.get(4).equals(playerSymbol)
                && boardState.get(6).equals(playerSymbol))
        {
            return true;
        }
        return false;
    }
    public void onclicked(View view){

        if ( view instanceof Button){

            Button clickedButton=((Button) view);
            if (clickedButton.getText().toString().isEmpty()) {
                if (counter % 2 == 0) {
                    clickedButton.setText("x");
                    putPlayerSymbolInBoardState(clickedButton.getId(),"x");
                } else {
                    clickedButton.setText("o");
                    putPlayerSymbolInBoardState(clickedButton.getId(),"o");
                }
                counter++;
                if (checkWinner("x")){
                    playerScore1+=10;
                    playerScoreOne.setText(""+playerScore1);
                    counter=0;
                    Toast.makeText(this, "PLAYER ( X )  + 10 ", Toast.LENGTH_SHORT).show();
                    initializeBoardState();
                    return;
                }else if (checkWinner("o")){
                    playerScore2+=5;
                    playerScoreTwo.setText(""+playerScore2);
                    counter=0;
                    Toast.makeText(this, "PLAYER ( O )  + 10 ", Toast.LENGTH_SHORT).show();
                    initializeBoardState();
                    return;
                }else if (counter==9){
                    playerScore1 +=5;
                    playerScoreOne.setText(""+playerScore1);
                    playerScore2 +=5;
                    playerScoreTwo.setText(""+playerScore2);
                    counter=0;
                    Toast.makeText(this, "PLAYER ( X & O )  + 2 ", Toast.LENGTH_SHORT).show();
                    initializeBoardState();
                    return;
                }
            }
    }
    }


}