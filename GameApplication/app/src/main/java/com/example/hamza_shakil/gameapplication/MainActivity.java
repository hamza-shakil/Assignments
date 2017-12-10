package com.example.hamza_shakil.gameapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

int levelno=1,CorrectGuess=0,range=20,attemptsNo=0,actualno;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actualno=new Random().nextInt(range);
        Log.i("number",actualno+"");
        TextView lvl=(TextView)findViewById(R.id.level);
        lvl.setText("level "+levelno);

    }
    public void GuessGame(View view){
        EditText text=(EditText)findViewById(R.id.editText);
        if(text.getText().toString()=="") {
            Toast.makeText(getApplicationContext(),"Please guess any num first!",Toast.LENGTH_SHORT).show();
            return;
        }
        int userNum=Integer.parseInt(text.getText().toString());
        if(attemptsNo <8){

            if(actualno<userNum){
                Toast.makeText(getApplicationContext(),"Number is less than "+userNum,Toast.LENGTH_SHORT).show();
                text.setText("");
                attemptsNo ++;
                TextView attemp=(TextView)findViewById(R.id.AttempsNo);
                attemp.setText("Attemp "+attemptsNo);
            }
            else if(actualno>userNum){
                Toast.makeText(getApplicationContext(),"Number is greater than "+userNum,Toast.LENGTH_SHORT).show();
                text.setText("");
                attemptsNo++;
                TextView attemp=(TextView)findViewById(R.id.AttempsNo);
                attemp.setText("Attemp "+attemptsNo);
            }
            else{
                Toast.makeText(getApplicationContext(),"Perfect number is"+actualno,Toast.LENGTH_SHORT).show();
                CorrectGuess++;
                range+=10;
                levelno++;
                TextView guess=(TextView)findViewById(R.id.correctGuess);
                guess.setText("correct guess "+CorrectGuess);
                TextView lvl=(TextView)findViewById(R.id.level);
                lvl.setText("Level "+levelno);
                actualno=new Random().nextInt();
                Log.i("number",actualno+"");
                text.setText("");
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Game Over",Toast.LENGTH_LONG).show();
            Button Tryagain=(Button)findViewById(R.id.TryAgain);
            Tryagain.setVisibility(View.VISIBLE);
        }

    }
    public void onClick (View v){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
