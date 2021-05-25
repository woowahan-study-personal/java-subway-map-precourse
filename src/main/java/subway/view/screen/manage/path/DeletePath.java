package subway.view.screen.manage.path;

import java.util.Scanner;
import subway.AppStatusCode;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InfoMessage;
import subway.view.message.InputMessage;
import subway.view.screen.ManageUI;
import subway.view.tools.InputTool;

public class DeletePath implements ManageUI {

    @Override
    public void commands(Scanner sc, Subway subway) {
        String lineName = InputTool.inputString(sc, InputMessage.askLineNameMessage(),
            ErrorMessage.failedRequestErrorMessage());
        String stationName = InputTool.inputString(sc, InputMessage.askStationNameMessage(),
            ErrorMessage.failedRequestErrorMessage());

        if (lineName == null || stationName == null) {
            return;
        }

        if (subway.deleteStationInLine(lineName, stationName) == AppStatusCode.notFoundCode()) {
            System.out.println(ErrorMessage.cannotFoundMessage());
            return;
        }

        System.out.println(InfoMessage.DeletedPathInfoMessage());
    }
}
