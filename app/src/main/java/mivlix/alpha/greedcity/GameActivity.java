package mivlix.alpha.greedcity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mivlix.alpha.greedcity.databinding.ActivityGameBinding;
import mivlix.alpha.greedcity.databinding.ButtonBinding;

public class GameActivity extends AppCompatActivity {
    private final Game game = new Game();
    private ActivityGameBinding binding;

    public static Intent newIntent(Context context) {
        return new Intent(context, GameActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    private void initQuestion(int id) {
        Game.Question question = game.getQuestion(id);
        binding.desc.setText(question.getDesc());
        for (Game.Question.Answer answer : question.getAnswers()) {
            ButtonBinding buttonBinding = ButtonBinding.inflate(
                    getLayoutInflater(),
                    binding.answers, false);
            buttonBinding.getRoot().setText(answer.getName());
            buttonBinding.getRoot().setOnClickListener(v -> goNext(answer));
        }
    }

    private void goNext(Game.Question.Answer answer) {

    }
}
