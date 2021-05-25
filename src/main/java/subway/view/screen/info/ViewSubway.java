package subway.view.screen.info;

import java.util.List;
import subway.domain.ImmutableLine;
import subway.domain.Line;
import subway.domain.Subway;
import subway.view.message.InfoMessage;
import subway.view.tools.OutputTool;

public class ViewSubway implements ViewUI {

    @Override
    public void commands(Subway subway) {
        List<ImmutableLine> lineList = subway.getLineList();

        for (ImmutableLine line : lineList) {
            System.out.println(InfoMessage.getInfoHeader() + line.getName());
            System.out.println(InfoMessage.getInfoHeader() + "---");
            OutputTool.printStringListWithHeader(line.getLineStationNameList(),
                InfoMessage.getInfoHeader());
            System.out.println();
        }
    }
}
