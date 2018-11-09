package br.com.paulohpfranco.startrekquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void checkQuestionOneAnswers(){
        RadioButton questionOneCaptain = findViewById(R.id.question1captain);
        boolean isQuestionOneCaptainChecked = questionOneCaptain.isChecked();
        if(isQuestionOneCaptainChecked) {
            correctAnswers++;
        }
    }

    private void checkQuestionTwoAnswers(){
        CheckBox questionTwoData = findViewById(R.id.question2data);
        CheckBox questionTwoDonkeyKong = findViewById(R.id.question2donkeykong);
        CheckBox questionTwoMarioBros = findViewById(R.id.question2mariobros);
        CheckBox questionTwoDeannaTroi = findViewById(R.id.question2deannatroi);

        boolean isQuestionTwoDataChecked = questionTwoData.isChecked();
        boolean isQuestionTwoDonkeyKongChecked = questionTwoDonkeyKong.isChecked();
        boolean isQuestionTwoMarioBrosChecked = questionTwoMarioBros.isChecked();
        boolean isQuestionTwoDeannaTroiChecked = questionTwoDeannaTroi.isChecked();

        if(isQuestionTwoDonkeyKongChecked && isQuestionTwoMarioBrosChecked && !isQuestionTwoDataChecked && !isQuestionTwoDeannaTroiChecked) {
            correctAnswers++;
        }

    }

    private void checkQuestionThreeAnswer(){
        EditText questionThreeAnswer = findViewById(R.id.question3answer);
        String answer = questionThreeAnswer.getText().toString();

        if (answer.trim().equalsIgnoreCase("James T. Kirk")) {
            correctAnswers++;
        }

    }

    private void checkQuestionFourAnswers(){
        RadioButton questionFourDelta = findViewById(R.id.question4delta);
        boolean isQuestionFourDeltaChecked = questionFourDelta.isChecked();
        if(isQuestionFourDeltaChecked) {
            correctAnswers++;
        }
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswers();
    }

    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }

    public void avaliar(View view) {
        checkAllQuestions();
        Toast.makeText(MainActivity.this, getString(R.string.correctAnwsers, ""+correctAnswers) + "/4", Toast.LENGTH_LONG).show();
        resetCounterCorrectAnswers();
    }
}
