package model;

import java.util.List;

public class Answers {
    private List<String> listAnswers;

    public Answers(List<String> listAnswers) {
        this.listAnswers = listAnswers;
    }

    public List<String> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(List<String> listAnswers) {
        this.listAnswers = listAnswers;
    }
}
