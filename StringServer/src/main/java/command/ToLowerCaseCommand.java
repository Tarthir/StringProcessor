package command;

import processor.StringProcessor;
import requests.RequestObject;
import results.ResultObject;

/**
 * Created by tyler on 9/14/2017.
 */

public class ToLowerCaseCommand implements ICommand {
    private String strToChange;

    public ToLowerCaseCommand(String strToChange) {
        this.strToChange = strToChange;
    }

    @Override
    public ResultObject execute() {
        RequestObject request = new RequestObject(strToChange);
        return StringProcessor.getInstance().ToLowerCase(request);
    }
}
