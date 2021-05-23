package subway.view.screen.manage.station;

import java.util.Scanner;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InfoMessage;
import subway.view.message.InputMessage;
import subway.view.screen.ManageUI;
import subway.view.screen.MenuUI;
import subway.view.tools.InputTool;

public class DeleteStation implements ManageUI {

    @Override
    public void commands(Scanner sc, Subway subway) {
        String stationName = InputTool.inputString(sc, InputMessage.askStationNameMessageForDelete(),
            ErrorMessage.failedRequestErrorMessage());

        if (stationName == null) {
            return;
        }

        if (!subway.deleteStation(stationName)) {
            System.out.println(ErrorMessage.stationAlreadyExistsErrorMessage());
            return;
        }

        System.out.println(InfoMessage.DeletedStationInfoMessage());
    }
}
