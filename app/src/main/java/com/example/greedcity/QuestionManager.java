package com.example.greedcity;

import android.content.Context;
import android.content.Intent;

public class QuestionManager {

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
    //TODO: Вопроситель
}
