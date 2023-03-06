package com.example.greedcity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.greedcity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private final Question question = new Question();

    private ActivityMainBinding binding;
    private TextManager textManager;

    public static Intent newInstance(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        textManager = new TextManager(getSharedPreferences(textManager.NAME, MODE_PRIVATE));

        setContentView(binding.getRoot());
        initQuestion(0);
    }

    private void initQuestion(int stepNumber) {
        binding.text1.setText("SCORE: " + question.getScore());

        switch (stepNumber) {
            case -1: GoodEnding(); break;
            case -2: BadEnding(); break;
            default: setQuestionState(stepNumber); break;
        }
    }

    private void setQuestionState(int stepNumber) {
        Question.Question question = question.getQuestion(stepNumber);
        binding.desc.setText(question.getDesc());
        fillButtons(question.getAnswers());
    }

    private void GoodEnding() {
        binding.desc.setText("Вы победили *_*");
        fillCloseButton();
        writeBestScore();
    }

    private void BadEnding() {
        binding.desc.setText("Вы убиты Х_Х");
        fillCloseButton();
        writeBestScore();
    }

    private void writeBestScore() {
        textManager.setScore(Math.max(textManager.getScore(), question.getScore()));
    }

    private void fillCloseButton() {
        binding.buttons.removeAllViews();

        ItemButtonBinding buttonBinding = ItemButtonBinding.inflate(
                getLayoutInflater(),
                binding.buttons,
                false
        );
        buttonBinding.getRoot().setText("Выйти в меню");
        buttonBinding.getRoot().setOnClickListener(v -> finish());
        binding.buttons.addView(buttonBinding.getRoot());
    }

    private void fillButtons(Question.Question.Answer[] answers) {
        binding.buttons.removeAllViews();
        for (Quest.Question.Answer answer : answers) {
            ItemButtonBinding buttonBinding = ItemButtonBinding.inflate(
                    getLayoutInflater(),
                    binding.buttons,
                    false
            );
            buttonBinding.getRoot().setText(answer.getName());
            buttonBinding.getRoot().setOnClickListener(v -> goNext(answer));
            binding.buttons.addView(buttonBinding.getRoot());
        }
    }

    private void goNext(Question.Question.Answer answer) {
        question.addScore(answer.getScore());
        initQuestion(answer.getNextStep());
    }
}