package service;

import model.Answers;
import model.Variant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InitVariantsService {

    private InitVariantsService() {
    }

    public static Variant getRandomVariant() {
        Random r = new Random();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/resources/variants.txt")))) {
            for (int i = 0; i < r.nextInt(16); i++) reader.readLine();
            Variant variant = new Variant(reader.readLine().split(" "));
            variant.setAnswers(new Answers(getAnswerList(variant.getVarNumber())));
            return variant;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static List<String> getAnswerList(int variantNumber) {
        List<String> answerList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/resources/answers.txt")))) {
            while (reader.ready())
            {
                String line = reader.readLine();
                if (line.startsWith("v") & line.equals("v" + String.valueOf(variantNumber))) {
                    for (int i = 0; i < 15; i++) {
                        answerList.add(reader.readLine());
                    }
                    return answerList;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
