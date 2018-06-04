package sample.service;

import sample.model.TestQuestion;

import java.util.*;

public class TestQuestionService {
    private List<TestQuestion> questions;

    /**
     * Инициализирует лист 10 рандомными вопросами
     */
    public TestQuestionService() {
        questions.addAll(Objects.requireNonNull(ParseService.parse()));
        Collections.shuffle(questions);
        questions = questions.subList(0,10);
    }

    public void print()
    {
        int i = 0;
        for (TestQuestion question : questions) System.out.println(i+++" "+question);
    }

    public List<TestQuestion> getQuestions() {
        return questions;
    }
}
