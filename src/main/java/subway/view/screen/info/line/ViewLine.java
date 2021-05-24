package subway.view.screen.info.line;

import subway.domain.Subway;
import subway.view.message.InfoMessage;
import subway.view.screen.info.ViewUI;
import subway.view.tools.OutputTool;

public class ViewLine implements ViewUI {

    @Override
    public void commands(Subway subway) {
        OutputTool.printStringListWithHeader(subway.getLineNameList(), InfoMessage.getInfoHeader());
    }
}
