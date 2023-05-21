package mivlix.alpha.greedcity;

import java.util.HashMap;

public class Game {
    private int pop = 1000;
    private static final int victoryPop = 100_000_000;
    private static int[] chars = {5, 5, 5, 5};

    private static final Question[] questions = new Question[]{
            new Question(
                    "Жители предлагают построить новый парк.",
                    0, victoryPop,
                    new Question.Answer[]{
                        new Question.Answer("Да", 1.2, new int[]{+1, 0, +1, -1}),
                        new Question.Answer("Нет", 1.05, new int[]{-1, 0, -1, +1})
                    }
            ),
            new Question(
                    "Что вы построите: Новую станцию метро или Автомагистраль?",
                    500_000, victoryPop,
                    new Question.Answer[]{
                            new Question.Answer("Метро", 1.2, new int[]{0, +2, +1, -2}),
                            new Question.Answer("Автомагистраль", 1.05, new int[]{-1, +2, -1, -1})
                    }
            ),
            new Question(
                    "Граждане предлагают провести фестиваль мороженого на главном проспекте города. Вы за или против?",
                    0, victoryPop,
                    new Question.Answer[]{
                            new Question.Answer("За", 1.2, new int[]{0, -1, +2, 0}),
                            new Question.Answer("Против", 1.05, new int[]{0, +1, -2, 0})
                    }
            ),
            new Question(
                    "Здравствуйте, а как зовут вашу кошку?",
                    0, victoryPop,
                    new Question.Answer[]{
                            new Question.Answer("Снежка", 1, new int[]{0, 0, 0, 0}),
                            new Question.Answer("Что?", 1, new int[]{0, 0, 0, 0}),
                            new Question.Answer("У меня нет кошки!", 1.1, new int[]{0, 0, 0, 0})
                    }
            ),
            new Question(
                    "Где предлагаете построить новый жилой комплекс?",
                    10_000, victoryPop,
                    new Question.Answer[]{
                            new Question.Answer("На окраине города", 1.4, new int[]{+1, -1, +1, 0}),
                            new Question.Answer("На месте частного сектора", 1.4, new int[]{+1, +1, -1, 0}),
                            new Question.Answer("На месте старого парка", 1.4, new int[]{-1, +1, +1, 0})
                    }
            ),
            new Question(
                    "Ваша казна пополнилась!",
                    0, victoryPop,
                    new Question.Answer[]{
                            new Question.Answer("Ура!", 1.2, new int[]{0, 0, 0, +1})
                    }
            ),
            new Question(
                    "В ваш город приехал знаменитый голливудский актер!",
                    0, victoryPop,
                    new Question.Answer[]{
                            new Question.Answer("Ура!", 1.05, new int[]{0, 0, +1, 0})
                    }
            ),
            new Question(
                    "Ураган нанес большой ущерб городу!",
                    0, victoryPop,
                    new Question.Answer[]{
                            new Question.Answer("Ой!", 0.9, new int[]{-1, -1, -1, -1})
                    }
            ),
            new Question(
                    "Жители прдлагают сделать улицу в центре города пешеходной. Вы за или против?",
                    0, victoryPop,
                    new Question.Answer[]{
                            new Question.Answer("За", 1.2, new int[]{+1, -1, +1, -1}),
                            new Question.Answer("Против", 1.05, new int[]{-1, +1, -1, 0})
                    }
            ),
    };

    public void changeChars(double pop, int[] chars){
        this.pop *= pop;
        for (int i = 0; i < chars.length; i++) {
            this.chars[i] += chars[i];
        }
    }

    public int getPop() {return pop;}
    public int getVictoryPop() {return victoryPop;}
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