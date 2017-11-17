package com.chrisbarilla.simplebaseballscorekeeper;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnIncrementHome;
    Button btnDecrementHome;
    Button btnIncrementVisitor;
    Button btnDecrementVisitor;
    Button btnIncrementInning;
    Button btnDecrementInning;
    Button btnReset;

    TextView txthomeScore;
    TextView txtvisitorScore;
    TextView txtinningNumber;

    public static final String Game_Score_FileName = "gameScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnIncrementHome = (Button)findViewById(R.id.buttonIncrementHome);
        btnDecrementHome = (Button)findViewById(R.id.buttonDecrementHome);
        btnIncrementVisitor = (Button)findViewById(R.id.buttonIncrementVisitor);
        btnDecrementVisitor = (Button)findViewById(R.id.buttonDecrementVisitor);
        btnIncrementInning = (Button)findViewById(R.id.buttonIncrementInning);
        btnDecrementInning = (Button)findViewById(R.id.buttonDecrementInning);
        btnReset = (Button)findViewById(R.id.buttonReset);


        txthomeScore = (TextView)findViewById(R.id.homeScore);
        txtvisitorScore = (TextView)findViewById(R.id.visitorScore);
        txtinningNumber = (TextView)findViewById(R.id.inningNumber);


        SharedPreferences score = getSharedPreferences(Game_Score_FileName, Context.MODE_PRIVATE);
        String Home = score.getString("Home_Score","0");
        String Visitor = score.getString("Visitor_Score","0");
        String Inning = score.getString("Inning_Number","1");

        txthomeScore.setText(Home);
        txtvisitorScore.setText(Visitor);
        txthomeScore.setText(Inning);



        btnIncrementHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String homeScoreValue = txthomeScore.getText().toString();
                int inthomeScoreValue = Integer.parseInt(homeScoreValue);
                inthomeScoreValue++;
                txthomeScore.setText(String.valueOf(inthomeScoreValue));
            }
        });

        btnDecrementHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String homeScoreValue = txthomeScore.getText().toString();
                int inthomeScoreValue = Integer.parseInt(homeScoreValue);
                inthomeScoreValue--;
                if (inthomeScoreValue < 0) {
                    inthomeScoreValue=0;
                }
                txthomeScore.setText(String.valueOf(inthomeScoreValue));
            }
        });

        btnIncrementVisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String visitorScoreValue = txtvisitorScore.getText().toString();
                int intvisitorScoreValue = Integer.parseInt(visitorScoreValue);
                intvisitorScoreValue++;
                txtvisitorScore.setText(String.valueOf(intvisitorScoreValue));
            }
        });

        btnDecrementVisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String visitorScoreValue = txtvisitorScore.getText().toString();
                int intvisitorScoreValue = Integer.parseInt(visitorScoreValue);
                intvisitorScoreValue--;
                if (intvisitorScoreValue < 0) {
                    intvisitorScoreValue=0;
                }
                txtvisitorScore.setText(String.valueOf(intvisitorScoreValue));
            }
        });

        btnIncrementInning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inningNumberValue = txtinningNumber.getText().toString();
                int intinningNumberValue = Integer.parseInt(inningNumberValue);
                intinningNumberValue++;
                txtinningNumber.setText(String.valueOf(intinningNumberValue));
            }
        });

        btnDecrementInning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inningNumberValue = txtinningNumber.getText().toString();
                int intinningNumberValue = Integer.parseInt(inningNumberValue);
                intinningNumberValue--;
                if (intinningNumberValue < 0) {
                    intinningNumberValue=0;
                }
                txtinningNumber.setText(String.valueOf(intinningNumberValue));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txthomeScore.setText(String.valueOf(0));
                txtvisitorScore.setText(String.valueOf(0));
                txtinningNumber.setText(String.valueOf(0));
            }
        });

        String homeScore = txthomeScore.getText().toString().trim();
        String visitorScore = txtvisitorScore.getText().toString().trim();
        String inningNumber = txtinningNumber.getText().toString().trim();

        SharedPreferences.Editor editor = getSharedPreferences(Game_Score_FileName,MODE_PRIVATE).edit();
        editor.putString("Home_Score",homeScore);
        editor.putString("Visitor_Score",visitorScore);
        editor.putString("Inning_Number",inningNumber);
        editor.commit();



    }
}
