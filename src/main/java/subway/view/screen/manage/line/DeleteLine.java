package subway.view.screen.manage.line;

import java.util.Objects;
import java.util.Scanner;
import subway.AppStatusCode;
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

        if (Objects.isNull(lineName)) {
            return;
        }

        if (subway.deleteLine(lineName) == AppStatusCode.notFoundCode()) {
            System.out.println(ErrorMessage.cannotFoundMessage());
            return;
        }

        System.out.println(InfoMessage.DeletedLineInfoMessage());
    }
}
