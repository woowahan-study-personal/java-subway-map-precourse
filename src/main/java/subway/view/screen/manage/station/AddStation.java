package subway.view.screen.manage.station;

import java.util.Scanner;
import subway.domain.Subway;
import subway.view.message.ErrorMessage;
import subway.view.message.InfoMessage;
import subway.view.message.InputMessage;
import subway.view.screen.ManageUI;
import subway.view.screen.MenuUI;
import subway.view.tools.InputTool;

public class AddStation implements ManageUI {

    @Override
    public void commands(Scanner sc, Subway subway) {
        String stationName = InputTool.inputString(sc, InputMessage.askStationNameMessageForAdd(),
            ErrorMessage.failedRequestErrorMessage());

        if (stationName == null) {
            return;
        }

        if (!subway.addStation(stationName)) {
            System.out.println(ErrorMessage.stationAlreadyExistsErrorMessage());
            return;
        }

        System.out.println(InfoMessage.SubmittedStationInfoMessage());
    }
}