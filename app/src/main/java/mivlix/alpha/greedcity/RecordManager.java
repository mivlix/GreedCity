package mivlix.alpha.greedcity;

import android.content.SharedPreferences;

public class RecordManager {
    public final static String GAME = "LAST_GAME";
    private final static String HIGHSCORE = "HIGHSCORE";
    private final SharedPreferences prefs;

    public RecordManager(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public void setHighscore(int pop) {
        prefs.edit().putInt(HIGHSCORE, pop).apply();
    }

    public int getHighscore() {
        return prefs.getInt(HIGHSCORE, 0);
    }
}
