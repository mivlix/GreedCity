package mivlix.alpha.greedcity;

import static mivlix.alpha.greedcity.RecordManager.GAME;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mivlix.alpha.greedcity.databinding.ActivityGameBinding;
import mivlix.alpha.greedcity.databinding.ButtonBinding;

public class GameActivity extends AppCompatActivity {
    private final Game game = new Game();
    private ActivityGameBinding binding;
    private RecordManager recorder;

    public static Intent newIntent(Context context) {
        return new Intent(context, GameActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        recorder = new RecordManager(getSharedPreferences(RecordManager.GAME, MODE_PRIVATE));
        setContentView(binding.getRoot());
        initQuestion((int) (Math.random() * game.getQuestionsLength()));
    }

    private void initQuestion(int id) {
        binding.pop.setText("Население: " + game.getPop());
        binding.eco.setText("Экология: " + game.getChars()[0]);
        binding.road.setText("Траффик: " + game.getChars()[1]);
        binding.mood.setText("Настроение: " + game.getChars()[2]);
        binding.money.setText("Бюджет: " + game.getChars()[3]);
        switch (id) {
            case -1:
                setEcologicalEnding();
                break;
            case -2:
                setTrafficEnding();
                break;
            case -3:
                setHappinessEnding();
                break;
            case -4:
                setMoneyEnding();
                break;
            case -99:
                setVictory();
                break;
            default:
                setQuestionState(id);
                break;
        }
    }

    private void fillRestartButton() {
        binding.answers.removeAllViews();
        ButtonBinding buttonBinding = ButtonBinding.inflate(
                getLayoutInflater(),
                binding.answers, false);
        buttonBinding.getRoot().setText("Выйти в меню");
        buttonBinding.getRoot().setOnClickListener(v -> finish());
        binding.answers.addView(buttonBinding.getRoot());
    }

    private void setEcologicalEnding() {
        binding.desc.setText("Ваш город утонул в пыли и грязи!");
        fillRestartButton();
    }

    private void setTrafficEnding() {
        binding.desc.setText("Ваш город встал в бесконечную пробку!");
        fillRestartButton();
    }

    private void setHappinessEnding() {
        binding.desc.setText("Ваши граждане свергли вас!");
        fillRestartButton();
    }

    private void setMoneyEnding() {
        binding.desc.setText("Ваша казна опустела!");
        fillRestartButton();
    }

    private void setVictory() {
        binding.desc.setText("Ваш город достиг отметки в 100 млн жителей! Как такое возможно?!");
        fillRestartButton();
        writeHighscore();
    }

    private void writeHighscore() {
        recorder.setHighscore(Math.max(recorder.getHighscore(), game.getPop()));
    }

    private void setQuestionState(int id) {
        Game.Question question = game.getQuestion(id);
        binding.desc.setText(question.getDesc());
        final int[] chars = game.getChars();
        binding.answers.removeAllViews();
        for (Game.Question.Answer answer : question.getAnswers()) {
            ButtonBinding buttonBinding = ButtonBinding.inflate(
                    getLayoutInflater(),
                    binding.answers, false);
            buttonBinding.getRoot().setText(answer.getName());
            buttonBinding.getRoot().setOnClickListener(v -> goNext(answer));
            binding.answers.addView(buttonBinding.getRoot());
        }
    }

    private void goNext(Game.Question.Answer answer) {
        game.changeChars(answer.getPop(), answer.getChars());
        initQuestion(answer.getNextQuestion());
    }
}
