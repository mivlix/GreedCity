package mivlix.alpha.greedcity;

import java.util.HashMap;

public class Game {
    private int pop = 1000;
    private final int victoryPop = 100_000_000;
    private int[] chars = {5, 5, 5, 5};

    private final Question[] questions = new Question[]{
        new Question(
            "Хотите построить новый парк?",
            0, victoryPop,
            new Question.Answer[]{
                new Question.Answer("Да", 1.3, new HashMap<String, Integer>(){{
                    put("eco", +1);
                    put("traffic", +1);
                    put("mood", 0);
                    put("money", -1);
                }}),
                new Question.Answer("Нет", 1.1, new HashMap<String, Integer>(){{
                    put("eco", -1);
                    put("traffic", -1);
                    put("mood", 0);
                    put("money", 0);
                }})
            }
        )
    };

    public int getPop() {return pop;}
    public int getVictoryPop() {return victoryPop;}
    public int[] getChars() {return chars;}

    public Question getQuestion(int id) {
        if (id >= 0 && id < questions.length) {
            return questions[id];
        }
        return null;
    }

    public class Question {
        private final String desc;
        private final int maxPop;
        private final int minPop;
        private final Answer[] answers;

        public Question(String desc, int minPop, int maxPop, Answer[] answers) {
            this.desc = desc;
            this.minPop = minPop;
            this.maxPop = maxPop;
            this.answers = answers;
        }

        public String getDesc() {return desc;}
        public Answer[] getAnswers() {return answers;}
        public record Answer(String name, double pop, HashMap<String, Integer> chars) {
            public String getName() {return name;}
        }
    }
}