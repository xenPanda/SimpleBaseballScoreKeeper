package com.chrisbarilla.simplebaseballscorekeeper;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Create Variables to hold Field Data
    Button btnIncrementHome;
    Button btnDecrementHome;
    Button btnIncrementVisitor;
    Button btnDecrementVisitor;
    Button btnIncrementInning;
    Button btnDecrementInning;
    Button btnReset;
    CheckBox ckbxoneOut;
    CheckBox ckbxtwoOut;
    CheckBox ckbxthreeOut;


    TextView txthomeScore;
    TextView txtvisitorScore;
    TextView txtinningNumber;

    //private SharedPreferences score;
    private static final String Game_Score_FileName = "gameScore";
    private String Home_Score = "txthomeScore";
    private String Visitor_Score = "txtvisitorScore";
    private String Inning_Number = "txtinningNumber";

    SharedPreferences score;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set default value in SharedPreferences file
        score = getSharedPreferences(Game_Score_FileName, Context.MODE_PRIVATE);


        // Get Values of the Form Fields
        btnIncrementHome = findViewById(R.id.buttonIncrementHome);
        btnDecrementHome = findViewById(R.id.buttonDecrementHome);
        btnIncrementVisitor = findViewById(R.id.buttonIncrementVisitor);
        btnDecrementVisitor = findViewById(R.id.buttonDecrementVisitor);
        btnIncrementInning = findViewById(R.id.buttonIncrementInning);
        btnDecrementInning = findViewById(R.id.buttonDecrementInning);
        btnReset = findViewById(R.id.buttonReset);
        txthomeScore = findViewById(R.id.homeScore);
        txtvisitorScore = findViewById(R.id.visitorScore);
        txtinningNumber = findViewById(R.id.inningNumber);
        ckbxoneOut = (CheckBox) findViewById(R.id.checkBox1Out);
        ckbxtwoOut = (CheckBox) findViewById(R.id.checkBox2Out);
        ckbxthreeOut = (CheckBox) findViewById(R.id.checkBox3Out);


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

                ckbxoneOut.setChecked(false);
                ckbxtwoOut.setChecked(false);
                ckbxthreeOut.setChecked(false);


            }
        });


    }

    @Override
    protected void onPause(){
      super.onPause();

        String homeScore = txthomeScore.getText().toString();
        String visitorScore = txtvisitorScore.getText().toString();
        String inningNumber = txtinningNumber.getText().toString();

        score = getSharedPreferences(Game_Score_FileName, MODE_PRIVATE);
        SharedPreferences.Editor editor = score.edit();

      editor.putString("Inning_Number",inningNumber);
      editor.putString("Visitor_Score",visitorScore);
      editor.putString("Home_Score",homeScore);
      editor.apply();

    }

    @Override
    protected void onResume(){
        super.onResume();

        score = getSharedPreferences(Game_Score_FileName, MODE_PRIVATE);

        String Home = score.getString("Home_Score","0");
        String Visitor = score.getString("Visitor_Score","0");
        String Inning = score.getString("Inning_Number","1");

        txthomeScore.setText(Home);
        txtvisitorScore.setText(Visitor);
        txtinningNumber.setText(Inning);

    }



}
