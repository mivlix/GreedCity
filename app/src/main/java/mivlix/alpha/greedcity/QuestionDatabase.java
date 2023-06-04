package mivlix.alpha.greedcity;

public class QuestionDatabase {
        static final int vPop = Game.getVictoryPop();
        private static final Game.Question[] questions = new Game.Question[]{
                new Game.Question(
                        "Жители предлагают построить новый парк.",
                        0, vPop,
                        new Game.Question.Answer[]{
                                new Game.Question.Answer("Да", 1.2, new int[]{+1, 0, +1, -1}),
                                new Game.Question.Answer("Нет", 1.05, new int[]{-1, 0, -1, +1})
                        }
                ),
                new Game.Question(
                        "Что вы построите: Новую станцию метро или Автомагистраль?",
                        500_000, vPop,
                        new Game.Question.Answer[]{
                                new Game.Question.Answer("Метро", 1.2, new int[]{0, +2, +1, -2}),
                                new Game.Question.Answer("Автомагистраль", 1.05, new int[]{-1, +2, -1, -1})
                        }
                ),
                new Game.Question(
                        "Граждане предлагают провести фестиваль мороженого на главном проспекте города. Вы за или против?",
                        0, vPop,
                        new Game.Question.Answer[]{
                                new Game.Question.Answer("За", 1.2, new int[]{0, -1, +2, 0}),
                                new Game.Question.Answer("Против", 1.05, new int[]{0, +1, -2, 0})
                        }
                ),
                new Game.Question(
                        "Здравствуйте, а как зовут вашу кошку?",
                        0, vPop,
                        new Game.Question.Answer[]{
                                new Game.Question.Answer("Снежка", 1, new int[]{0, 0, 0, 0}),
                                new Game.Question.Answer("Что?", 1, new int[]{0, 0, 0, 0}),
                                new Game.Question.Answer("У меня нет кошки!", 1.1, new int[]{0, 0, 0, 0})
                        }
                ),
                new Game.Question(
                        "Где предлагаете построить новый жилой комплекс?",
                        10_000, vPop,
                        new Game.Question.Answer[]{
                                new Game.Question.Answer("На окраине города", 1.4, new int[]{+1, -1, +1, 0}),
                                new Game.Question.Answer("На месте частного сектора", 1.4, new int[]{+1, +1, -1, 0}),
                                new Game.Question.Answer("На месте старого парка", 1.4, new int[]{-1, +1, +1, 0})
                        }
                ),
                new Game.Question(
                        "Ваша казна пополнилась!",
                        0, vPop,
                        new Game.Question.Answer[]{
                                new Game.Question.Answer("Ура!", 1.2, new int[]{0, 0, 0, +1})
                        }
                ),
                new Game.Question(
                        "В ваш город приехал знаменитый голливудский актер!",
                        0, vPop,
                        new Game.Question.Answer[]{
                                new Game.Question.Answer("Ура!", 1.05, new int[]{0, 0, +1, 0})
                        }
                ),
                new Game.Question(
                        "Ураган нанес большой ущерб городу!",
                        0, vPop,
                        new Game.Question.Answer[]{
                                new Game.Question.Answer("Ой!", 0.9, new int[]{-1, -1, -1, -1})
                        }
                ),
                new Game.Question(
                        "Жители прдлагают сделать улицу в центре города пешеходной. Вы за или против?",
                        0, vPop,
                        new Game.Question.Answer[]{
                                new Game.Question.Answer("За", 1.2, new int[]{+1, -1, +1, -1}),
                                new Game.Question.Answer("Против", 1.05, new int[]{-1, +1, -1, 0})
                        }
                ),
        };
        public static Game.Question[] getQuestions() {return questions;}
}
