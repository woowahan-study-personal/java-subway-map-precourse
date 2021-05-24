package subway.view.screen.manage.path;

import java.util.Scanner;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InfoMessage;
import subway.view.message.InputMessage;
import subway.view.screen.ManageUI;
import subway.view.tools.InputTool;

public class AddPath implements ManageUI {

    @Override
    public void commands(Scanner sc, Subway subway) {
        String lineName = InputTool.inputString(sc, InputMessage.askLineNameMessage(),
            ErrorMessage.failedRequestErrorMessage());
        String stationName = InputTool.inputString(sc, InputMessage.askStationNameMessage(),
            ErrorMessage.failedRequestErrorMessage());
        int order = InputTool.inputInt(sc, InputMessage.askStationOrderMessage(),
            ErrorMessage.requiresIntegerOnlyMessage());

        if (lineName == null || stationName == null || order < 0) {
            return;
        }

        if (!subway.addStationToLine(lineName, stationName, order)) {
            System.out.println(ErrorMessage.failedRequestErrorMessage());
            return;
        }

        System.out.println(InfoMessage.SubmittedPathInfoMessage());
    }
}
