package mivlix.alpha.greedcity;

public class Game {
    private int pop = 1000;
    private static final int victoryPop = 100_000_000;
    private static int[] chars = {5, 5, 5, 5};
    private static final Question[] questions = QuestionDatabase.getQuestions();
    public void changeChars(double pop, int[] chars){
        this.pop *= pop;
        for (int i = 0; i < chars.length; i++) {
            this.chars[i] += chars[i];
        }
    }

    public int getPop() {return pop;}
    public static int getVictoryPop() {return victoryPop;}
    public int[] getChars() {return chars;}

    public Question getQuestion(int id) {
        if (id >= 0 && id < questions.length) {
            return questions[id];
        }
        return null;
    }

    public int getQuestionsLength() {return questions.length;}

    public static class Question {
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
        public static class Answer {
            private final String name;
            private final double pop;
            private final int[] chars;

            public Answer(String name, double pop, int[] chars){
                this.name = name;
                this.pop = pop;
                this.chars = chars;
            }
            public String getName() {return name;}
            public double getPop() {return pop;}
            public int[] getChars() {return chars;}

            public int getNextQuestion() {
                if (Game.chars[0] < 0) {return -1;}
                if (Game.chars[1] < 0) {return -2;}
                if (Game.chars[2] < 0) {return -3;}
                if (Game.chars[3] < 0) {return -4;}
                return (int) (Math.random() * questions.length);
            }
        }
    }
}