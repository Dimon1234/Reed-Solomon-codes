package service;

import model.TestQuestion;

import java.util.*;

public class TestQuestionService {
    private static List<TestQuestion> questions;

    /**
     * Инициализирует лист 10 рандомными вопросами
     */
    static {
        questions = new ArrayList<>();
        questions.addAll(ParseService.parse());
        Collections.shuffle(questions);
        questions = questions.subList(0,10);
    }
    private TestQuestionService() {

    }

    public static List<TestQuestion> getQuestions() {
        return questions;
    }
}
