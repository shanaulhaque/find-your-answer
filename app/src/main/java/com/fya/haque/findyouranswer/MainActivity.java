package com.fya.haque.findyouranswer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.TextView;

import com.fya.haque.utils.Validator;

public class MainActivity extends AppCompatActivity {

    private TextView    tv_answer;
    private EditText    et_question;
    private Button      btn_search;
    private String      question;
    private String      answer;
    private Context     mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        initResources();

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                question    =   et_question.getText().toString();
                Boolean  isQuestionEmpty = Validator.validateQuestion(question);
                setAnswer(isQuestionEmpty);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        setEditTextScrollable(et_question,4);
        setTextViewScrollable(tv_answer,14);

    }

    private void setEditTextScrollable(EditText view, int maxLine){
        view.setScroller(new Scroller(mContext));
        view.setMaxLines(maxLine);
        view.setVerticalScrollBarEnabled(true);
        view.setMovementMethod(new ScrollingMovementMethod());
    }
    private void setTextViewScrollable(TextView view, int maxLine){
        view.setScroller(new Scroller(mContext));
        view.setMaxLines(maxLine);
        view.setVerticalScrollBarEnabled(true);
        view.setMovementMethod(new ScrollingMovementMethod());
    }

    private void setAnswer(Boolean isQuestionEmpty){
        if(isQuestionEmpty){
            answer  = "Please enter question";
        }else{
            /*
                call your function passing variable question as a variable
                Ex findAnswer(question)
                and set it to answer variable
             */
            answer  = question;
        }
        tv_answer.setText(answer);
    }


    private void initResources(){
        tv_answer   =   (TextView)  findViewById(R.id.tv_answer);
        et_question =   (EditText)  findViewById(R.id.et_question);
        btn_search  =   (Button)    findViewById(R.id.btn_find_answer);
    }


}
