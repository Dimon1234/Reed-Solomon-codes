package service;

import controller.hardQuestions.*;

public class CheckQuestionService {
    private CheckQuestionService() {
    }

    public static boolean check(int currentVariant) {
        switch (currentVariant) {
            case 1:
                return Que1.check();
            case 2:
                return Que2.check();
            case 3:
                return Que3.check();
            case 4:
                return Que4.check();
            case 5:
                return Que5.check();
            case 6:
                return Que6.check();
            case 7:
                return Que7.check();
            case 8:
                return Que8.check();
            case 9:
                return Que9.check();
            case 10:
                return Que10.check();
            case 11:
                return Que11.check();
            case 12:
                return Que12.check();
            case 13:
                return Que13.check();
            case 14:
                return Que14.check();
            case 15:
                return Que15.check();
        }
        return false;
    }
}
