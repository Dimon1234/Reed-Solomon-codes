package service;

import model.Variant;

import java.io.*;
import java.util.Random;

public class InitVariantsService {
    private InitVariantsService() {
    }

    public static Variant getRandomVariant()
    {
        Random r = new Random();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("../variants.txt")));
            for (int i = 0; i < r.nextInt(50); i++) reader.readLine();
            return new Variant(reader.readLine().split(" "));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
