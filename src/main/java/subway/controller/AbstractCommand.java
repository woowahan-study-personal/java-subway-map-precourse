package subway.controller;

public abstract class AbstractCommand implements Command {

    @Override
    public boolean isEnd() {
        return false;
    }
}
