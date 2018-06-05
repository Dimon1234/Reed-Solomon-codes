package service;

import model.TestQuestion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseService {


    /**
     * Парсит que.txt
     *
     * @return
     */
    public static List<TestQuestion> parse() {
        List<TestQuestion> questions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/que.txt")))) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.equals("")) break;
                questions.add(
                        new TestQuestion(line, new String[]
                                {
                                        reader.readLine(),
                                        reader.readLine(),
                                        reader.readLine(),
                                        reader.readLine()
                                }
                        )
                );
            }
            return questions;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
