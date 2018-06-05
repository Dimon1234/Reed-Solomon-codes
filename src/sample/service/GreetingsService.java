package service;

import java.io.UnsupportedEncodingException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ResourceBundle;

public class GreetingsService {
    private static Queue<String> keys;

    static {
        keys = new PriorityQueue<>();
        for (int i = 1; i <= 3; i++) {
            keys.add(String.valueOf(i));
        }

    }

    private GreetingsService() {
    }

    public static String getGreeting() throws UnsupportedEncodingException {
        String key = keys.poll();
        if (key == null) return null;
        String val = ResourceBundle.getBundle("greetings").getString(key);
        return new String(val.getBytes("WINDOWS-1252"), "WINDOWS-1251");
}
}
