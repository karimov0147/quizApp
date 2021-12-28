package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textview;
    RadioGroup radioGroup;
    ScrollView scrollView;
    AppCompatButton btn;
    int selected = -1;
    int count = 0;
    int trueAnswer = 0;
    int n = 0 ;
    boolean bool = false;
    LinearLayoutCompat linear ;
    ImageFilterView image;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = findViewById(R.id.scroll);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        textview = findViewById(R.id.textView);
        btn = findViewById(R.id.btn);
        List<QuestionsData>  questions = LocalStorage.getQuestions();
        loadNewQuestions(questions.get(count));
        linear = findViewById(R.id.linear);
        image = findViewById(R.id.image);


        btn.setOnClickListener( v -> {

            if (bool){
                //radioGroup.removeAllViews();
                //scrollView.removeView(radioGroup);
                finish();
                Intent intent = new Intent(this , LoadingActivity.class);
                startActivity(intent);
            }
            else{
                selected = radioGroup.getCheckedRadioButtonId();
                if (selected != -1) {
                    if (count < questions.size() - 1) {
//                    RadioButton btn1 = ((RadioButton) radioGroup.getChildAt(selected - 1));
//                    questions.get(count).selectedAnswer = btn1.getText().toString();
                        questions.get(count).selectedAnswer = questions.get(count).questions[selected - 1 - n];
                        //btn1.setChecked(false);
                        selected = -1;
                        n += questions.get(count).questions.length;

                        boolean a = questions.get(count).answer == (questions.get(count).selectedAnswer);

                        if (a) {
                            View snackview = findViewById(android.R.id.content);
                            Snackbar snackbar = Snackbar.make(snackview, "True", Snackbar.LENGTH_SHORT);
                            snackbar.setAnchorView(linear);
                            snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.green));
                            snackbar.show();
                        } else {
                            View snackview = findViewById(android.R.id.content);
                            Snackbar snackbar = Snackbar.make(snackview, "False", Snackbar.LENGTH_SHORT);
                            snackbar.setAnchorView(linear);
                            snackbar.setBackgroundTint(ContextCompat.getColor(this, R.color.red));
                            snackbar.show();
                        }

                        if (a) trueAnswer += 1;

                        scrollView.removeViewAt(0);
                        //radioGroup.removeViews(0,questions.get(count).questions.length);
                        loadNewQuestions(questions.get(++count));
//                    for (int i = 0; i < questions.get(count).questions.length; i++) {
//                        RadioButton radio = ((RadioButton) radioGroup.getChildAt(i));
//                       // radio.setVisibility(View.GONE);
//
                    } else {
                        textview.setText("you score : \n" + ++trueAnswer + " / " + questions.size());
                        radioGroup.setVisibility(View.INVISIBLE);
                        btn.setText("Restart");
                        bool = true;
                        image.setVisibility(View.VISIBLE);
                        switch (trueAnswer){
                            case 1: {
                                image.setImageResource(R.drawable.emojione_face_with_head_bandage);
                                break;
                            }
                            case 2: {
                                image.setImageResource(R.drawable.emojione_expressionless_face);
                                break;
                            }
                            case 3: {
                                image.setImageResource(R.drawable.emojione_confused_face);
                                break;
                            }
                            case 4: {
                                image.setImageResource(R.drawable.emojione_smiling_face);
                                break;
                            }
                            case 5:
                            case 6: {
                                image.setImageResource(R.drawable.group);
                                break;
                            }
                            case 7: {
                                image.setImageResource(R.drawable.emojione_smiling_face_with_sunglasses);
                                break;
                            }
                        }
                    }
                } else Toast.makeText(this, "choise answer", Toast.LENGTH_SHORT).show();
            }
        });







    }

    private void loadNewQuestions (QuestionsData data){
        radioGroup = new RadioGroup(this);
        textview.setText(data.task);

        for (int i = 0; i < data.questions.length; i++) {


            radioGroup.addView(LayoutInflater.from(this).inflate(R.layout.radio_btn , radioGroup , false));
            ((RadioButton) radioGroup.getChildAt(i)).setText(data.questions[i]);
        }

        scrollView.addView(radioGroup);


    }




}