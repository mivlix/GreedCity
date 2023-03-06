package com.example.greedcity;

import android.content.Context;
import android.content.Intent;

import com.example.greedcity.databinding.ActivityMainBinding;

public class ButtonSomething {
    private static ActivityMainBinding binding;

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }
    //TODO: Текстователь
}
