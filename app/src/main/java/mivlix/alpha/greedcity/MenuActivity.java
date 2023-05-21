package mivlix.alpha.greedcity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import mivlix.alpha.greedcity.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {
    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        loadBestResult();
        binding.play.setOnClickListener(v -> {
            startActivity(GameActivity.newIntent(this));
        });
    }

    private void loadBestResult() {
        binding.best.setText("BEST: 1234");
        //TODO
    }
}