package example.ybdesire.com.javacompiler.View;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import example.ybdesire.com.javacompiler.JsonFile.Json_Data_Get;
import example.ybdesire.com.javacompiler.JsonFile.Question_Data;
import example.ybdesire.com.javacompiler.R;

public class View_MC_Question extends AppCompatActivity {


    private Question_Data question_data = new Question_Data();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    int getInListView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            getInListView = extras.getInt("Question");
        }

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    //Toast.makeText(View_MC_Question.this,"correct",Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(View_MC_Question.this, "wrong", Toast.LENGTH_SHORT).show();
                    mButtonChoice1.setBackgroundColor(Color.parseColor("#B71C1C"));
                }

            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    //Toast.makeText(View_MC_Question.this,"correct",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(View_MC_Question.this, "wrong", Toast.LENGTH_SHORT).show();
                    mButtonChoice2.setBackgroundColor(Color.parseColor("#B71C1C"));
                }
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonChoice3.getText() == mAnswer) {
                    mScore = mScore += 1;
                    updateScore(mScore);
                    updateQuestion();
                    //Toast.makeText(View_MC_Question.this,"correct",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(View_MC_Question.this, "wrong", Toast.LENGTH_SHORT).show();
                    mButtonChoice3.setBackgroundColor(Color.parseColor("#B71C1C"));
                }
            }
        });

    }

    private void updateQuestion() {

        try {
            String Question = Json_Data_Get.getJsonArray_MC_Question("MultipleChoice", getAssets().open("user_db.json"), getInListView, mQuestionNumber);
            mQuestionView.setText(Question);

            String Choice0 = Json_Data_Get.getJsonArray_MC_Choice("MultipleChoice", getAssets().open("user_db.json"), mQuestionNumber, 0);
            String Choice1 = Json_Data_Get.getJsonArray_MC_Choice("MultipleChoice", getAssets().open("user_db.json"), mQuestionNumber, 1);
            String Choice2 = Json_Data_Get.getJsonArray_MC_Choice("MultipleChoice", getAssets().open("user_db.json"), mQuestionNumber, 2);

            mButtonChoice1.setText(Choice0);
            mButtonChoice2.setText(Choice1);
            mButtonChoice3.setText(Choice2);

            mAnswer = Json_Data_Get.getJsonArray_MC_answer("MultipleChoice", getAssets().open("user_db.json"), getInListView, mQuestionNumber);
            Log.e("String", "kwan  choice" + mButtonChoice1.getText());
            Log.e("String", "kwan  choice" + mButtonChoice2.getText());
            Log.e("String", "kwan  choice" + mButtonChoice3.getText());


            Log.e("string", "kwan ans   " + mAnswer);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Toast.makeText(View_MC_Question.this, "correct", Toast.LENGTH_SHORT).show();

        if (mQuestionNumber < 4) {
            mQuestionNumber += 1;
        }

    }


    private void EndQuestion() {
        mQuestionView.setText("Complete!\nyou Got 3/3");
        mButtonChoice1.setVisibility(View.GONE);
        mButtonChoice2.setVisibility(View.GONE);
        mButtonChoice3.setVisibility(View.GONE);
        Toast.makeText(View_MC_Question.this, "Nice", Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                // yourMethod();
            }
        }, 1000);
    }


    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
        mButtonChoice1.setBackgroundColor(Color.parseColor("#0091EA"));
        mButtonChoice2.setBackgroundColor(Color.parseColor("#0091EA"));
        mButtonChoice3.setBackgroundColor(Color.parseColor("#0091EA"));
    }

}
