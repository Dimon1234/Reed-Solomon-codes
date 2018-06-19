package service;


import model.Answers;
import model.Variant;

import java.util.List;
import java.util.Random;

public class InitVariantsService {

    private InitVariantsService() {
    }

    public static Variant getRandomVariant() {
        List<Variant> list = ParseService.getVariants();
        Variant variant = list.get(new Random().nextInt(list.size()));
        variant.setAnswers(getAnswersByVarNumber(variant.getVarNumber()));
        return variant;
    }

    private static Answers getAnswersByVarNumber(int variantNumber) {
        return ParseService.getListAnswers().stream()
                .filter(answers1 -> answers1.getVariantNumber() == variantNumber)
                .findFirst()
                .get();
    }
}
