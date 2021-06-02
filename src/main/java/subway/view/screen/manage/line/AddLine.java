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

public class AddLine implements ManageUI {

    @Override
    public void commands(Scanner sc, Subway subway) {
        String lineName = InputTool.inputString(sc, InputMessage.askLineNameMessageForAdd(),
            ErrorMessage.failedRequestErrorMessage());

        String fromStationName = InputTool
            .inputString(sc, InputMessage.askFromStationNameForAddMessage(),
                ErrorMessage.failedRequestErrorMessage());

        String toStationName = InputTool
            .inputString(sc, InputMessage.askToStationNameForAddMessage(),
                ErrorMessage.failedRequestErrorMessage());

        if (Objects.isNull(lineName) || Objects.isNull(fromStationName) || Objects
            .isNull(toStationName)) {
            return;
        }

        int executeCode = subway.addLine(lineName, fromStationName, toStationName);

        if (executeCode == AppStatusCode.contentAlreadyExistsCode()) {
            System.out.println(ErrorMessage.lineAlreadyExistsErrorMessage());
            return;
        }

        if (executeCode == AppStatusCode.contentRangeFailedCode()) {
            System.out.println(ErrorMessage.contentLengthOutOfRangeMessage());
            return;
        }

        System.out.println(InfoMessage.SubmittedLineInfoMessage());
    }
}
