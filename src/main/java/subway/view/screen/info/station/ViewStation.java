package subway.view.screen.info.station;

import subway.domain.Subway;
import subway.view.message.InfoMessage;
import subway.view.message.MenuMessage;
import subway.view.screen.info.ViewUI;
import subway.view.tools.OutputTool;

public class ViewStation implements ViewUI {

    @Override
    public void commands(Subway subway) {
        System.out.println(MenuMessage.stationListPageMessage());

        OutputTool
            .printStringListWithHeader(subway.getStationNameList(), InfoMessage.getInfoHeader());
    }
}
