package mivlix.alpha.greedcity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mivlix.alpha.greedcity.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {
    private ActivityMenuBinding binding;
    private RecordManager recorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        recorder = new RecordManager(getSharedPreferences(RecordManager.GAME, MODE_PRIVATE));
        setContentView(binding.getRoot());
        loadHighscore();
        binding.play.setOnClickListener(v -> {
            startActivity(GameActivity.newIntent(this));
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        loadHighscore();
    }

    private void loadHighscore() {
        binding.best.setText("Рекорд: " + recorder.getHighscore() + " чел.");
    }
}