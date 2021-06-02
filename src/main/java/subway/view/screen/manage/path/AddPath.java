package subway.view.screen.manage.path;

import java.util.Objects;
import java.util.Scanner;
import subway.AppStatusCode;
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

        if (Objects.isNull(lineName) || Objects.isNull(stationName) || order == AppStatusCode
            .outOfRangeCode()) {
            return;
        }

        if (subway.addStationToLine(lineName, stationName, order) == AppStatusCode
            .contentAlreadyExistsCode()) {
            System.out.println(ErrorMessage.stationAlreadyExistsInLineErrorMessage());
            return;
        }

        System.out.println(InfoMessage.SubmittedPathInfoMessage());
    }
}
