package mivlix.alpha.greedcity;

import android.content.SharedPreferences;
import android.util.Log;

public class RecordManager {
    public final static String GAME = "LAST_GAME";
    private final static String HIGHSCORE = "HIGHSCORE";
    private final SharedPreferences prefs;

    public RecordManager(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    public void setHighscore(int pop) {
        prefs.edit().putInt(HIGHSCORE, pop).apply();
        Log.i("high", "set, " + pop);
    }

    public int getHighscore() {
        int highscore = prefs.getInt(HIGHSCORE, 0);
        Log.i("high", "get, " + highscore);
        return highscore;
    }
}
