package model;

import java.util.Arrays;
import java.util.Objects;

/**
 * Вопросы теста
 */
public class TestQuestion {
    /**
     * текст вопроса
     */
    private String textQuestion;
    /**
     * 4 Варианта ответа, правильный под индексом 0
     */
    private String[] variants;

    public TestQuestion(String textQuestion, String[] variants) {
        this.textQuestion = textQuestion;
        this.variants = variants;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String[] getVariants() {
        return variants;
    }

    public void setVariants(String[] variants) {
        this.variants = variants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestQuestion testQuestion = (TestQuestion) o;
        return Objects.equals(textQuestion, testQuestion.textQuestion) &&
                Arrays.equals(variants, testQuestion.variants);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(textQuestion);
        result = 31 * result + Arrays.hashCode(variants);
        return result;
    }

    @Override
    public String toString() {
        return "TestQuestion{" +
                "textQuestion='" + textQuestion + '\'' +
                ", variants=" + Arrays.toString(variants) +
                '}';
    }
}
