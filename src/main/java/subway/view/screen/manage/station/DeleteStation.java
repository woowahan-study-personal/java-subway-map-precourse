package subway.view.screen.manage.station;

import java.util.Objects;
import java.util.Scanner;
import subway.AppStatusCode;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InfoMessage;
import subway.view.message.InputMessage;
import subway.view.screen.ManageUI;
import subway.view.tools.InputTool;

public class DeleteStation implements ManageUI {

    @Override
    public void commands(Scanner sc, Subway subway) {
        String stationName = InputTool.inputString(sc, InputMessage.askLineNameMessage(),
            ErrorMessage.failedRequestErrorMessage());

        if (Objects.isNull(stationName)) {
            return;
        }

        int executeCode = subway.deleteStation(stationName);

        if (executeCode == AppStatusCode.notFoundCode()) {
            System.out.println(ErrorMessage.cannotFoundMessage());
            return;
        }

        if (executeCode == AppStatusCode.contentAlreadyExistsCode()) {
            System.out.println(ErrorMessage.stationAlreadyExistsErrorMessage());
            return;
        }

        System.out.println(InfoMessage.DeletedStationInfoMessage());
    }
}
