package com.example.quiz;

import static com.example.quiz.MainActivity.listOfQue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    CountDownTimer countDownTimer;
    ProgressBar progressBar;
    List<ModelClass> allQuesList;
    ModelClass modelClass;
    TextView card_ques,optionA,optionB,optionC,optionD,ic_exit_btn;
    CardView cardOA,cardOB,cardOC,cardOD;
    int timerValue = 100;
    int index = 0;
    int correctCount = 0;
    int wrongCount = 0;
    ImageView ic_back_btn;
    LinearLayout nextQuesBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hooks();
        progressBar = findViewById(R.id.quiz_timer);
        allQuesList = listOfQue;
        Collections.shuffle(allQuesList);
        modelClass = listOfQue.get(index);

        setallData();

        ic_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        countDownTimer = new CountDownTimer(100000,1000) {
            @Override
            public void onTick(long l) {
                timerValue = timerValue-1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(DashboardActivity.this,R.style.Dialoge);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.time_out);

                dialog.findViewById(R.id.try_again_btn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                        startActivity(intent);
                    }
                });
                dialog.show();
            }
        }.start();
    }
    private void setallData(){
        card_ques.setText(modelClass.getQuestions());
        optionA.setText(modelClass.getoA());
        optionB.setText(modelClass.getoB());
        optionC.setText(modelClass.getoC());
        optionD.setText(modelClass.getoD());

    }
    private void Hooks(){
        // Buttons
        ic_back_btn = findViewById(R.id.ic_back);
        ic_exit_btn = findViewById(R.id.ic_exit);
        card_ques = findViewById(R.id.card_questions);
        optionA = findViewById(R.id.card_option_A);
        optionB = findViewById(R.id.card_option_B);
        optionC = findViewById(R.id.card_option_C);
        optionD = findViewById(R.id.card_option_D);

        cardOA = findViewById(R.id.cardA);
        cardOB = findViewById(R.id.cardB);
        cardOC = findViewById(R.id.cardC);
        cardOD = findViewById(R.id.cardD);
        nextQuesBtn = findViewById(R.id.next_question);
    }
    public void correct(CardView cardView){
        cardView.setCardBackgroundColor(getResources().getColor(R.color.green));
        nextQuesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCount++;
                index++;
                modelClass = listOfQue.get(index);
                resetColor();
                setallData();
                enableBtn();
            }
        });

    }
    public void wrong(CardView cardView){
        cardView.setCardBackgroundColor(getResources().getColor(R.color.red));
        nextQuesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongCount++;
                if(index<listOfQue.size()-1){
                    index++;
                    modelClass = listOfQue.get(index);
                    resetColor();
                    setallData();
                    enableBtn();
                }
                else{
                    QuizWon();
                }
            }
        });
    }

    private void QuizWon() {
        Intent intent = new Intent(DashboardActivity.this,QuizWonActivity.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",wrongCount);
        startActivity(intent);
    }
    public void enableBtn(){
        cardOA.setClickable(true);
        cardOB.setClickable(true);
        cardOC.setClickable(true);
        cardOD.setClickable(true);
    }
    public void disableBtn(){
        cardOA.setClickable(false);
        cardOB.setClickable(false);
        cardOC.setClickable(false);
        cardOD.setClickable(false);
    }
    public void resetColor(){
        cardOA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cardOD.setCardBackgroundColor(getResources().getColor(R.color.white));
    }

    public void optionAClick(View view) {
        disableBtn();
        nextQuesBtn.setClickable(true);
        if(modelClass.getoA().equals(modelClass.getAns())){
            cardOA.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<listOfQue.size()-1){
                correct(cardOA);
            }else {
                QuizWon();
            }
        }
        else{
            wrong(cardOA);
        }
    }
    public void optionBClick(View view) {
        disableBtn();
        nextQuesBtn.setClickable(true);
        if(modelClass.getoB().equals(modelClass.getAns())){
            cardOB.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<listOfQue.size()-1){
                correct(cardOB);
            }else {
                QuizWon();
            }
        }
        else{
            wrong(cardOB);
        }
    }
    public void optionCClick(View view) {
        disableBtn();
        nextQuesBtn.setClickable(true);
        if(modelClass.getoC().equals(modelClass.getAns())){
            cardOC.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<listOfQue.size()-1){
                correct(cardOC);
            }else {
                QuizWon();
            }
        }
        else{
            wrong(cardOC);
        }
    }
    public void optionDClick(View view) {
        disableBtn();
        nextQuesBtn.setClickable(true);
        if(modelClass.getoD().equals(modelClass.getAns())){
            cardOD.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<listOfQue.size()-1){
               correct(cardOD);
            }else {
                QuizWon();
            }
        }
        else{
            wrong(cardOD);
        }
    }
}