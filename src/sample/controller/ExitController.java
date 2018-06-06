package controller;

public interface ExitController {
    default void exit()
    {
        System.exit(0);
    }
}
