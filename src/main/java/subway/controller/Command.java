package subway.controller;

public interface Command {

    Command execute();

    boolean isEnd();
}
