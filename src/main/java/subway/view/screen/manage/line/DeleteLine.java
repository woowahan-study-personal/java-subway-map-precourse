package subway.view.screen.manage.line;

import java.util.Scanner;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InfoMessage;
import subway.view.message.InputMessage;
import subway.view.screen.ManageUI;
import subway.view.tools.InputTool;

public class DeleteLine implements ManageUI {

    @Override
    public void commands(Scanner sc, Subway subway) {
        String lineName = InputTool.inputString(sc, InputMessage.askStationNameMessageForDelete(),
            ErrorMessage.failedRequestErrorMessage());

        if (lineName == null) {
            return;
        }

        if (!subway.deleteLine(lineName)) {
            System.out.println(ErrorMessage.failedRequestErrorMessage());
            return;
        }

        System.out.println(InfoMessage.DeletedLineInfoMessage());
    }
}
