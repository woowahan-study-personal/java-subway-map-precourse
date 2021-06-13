package subway.controller;

public class Finish extends AbstractCommand {

    @Override
    public Command execute() {
        // 예외처리 하기
        return null;
    }

    @Override
    public boolean isEnd() {
        return true;
    }
}
