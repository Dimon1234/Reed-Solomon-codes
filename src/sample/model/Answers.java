package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answers {
    private int variantNumber;
    private List<String> listAnswers;

    public Answers(String text) {
        String[] array = text.split("\n");
        variantNumber = Integer.parseInt(array[0]);
        listAnswers = new ArrayList<>();
        listAnswers.addAll(Arrays.asList(array).subList(1, array.length));
    }

    public int getVariantNumber() {
        return variantNumber;
    }

    public List<String> getListAnswers() {
        return listAnswers;
    }
}
