package com.example.greedcity;

import android.content.Context;
import android.content.Intent;

public class TextManager {
    public static int SCORE = 0;
    public static final String NAME = "stub";

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    public int getScore(){
        return SCORE;
    }

    public void setScore(int score){
        SCORE = score;
    }
    //TODO: Текстователь
}
