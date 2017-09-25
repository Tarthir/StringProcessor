package processor;

import commandData.CommandData;
import requests.RequestObject;
import results.ResultObject;

/**
 * Created by tyler on 9/14/2017.
 */

public interface IStringProcessorServer {
    ResultObject ToLowerCase(RequestObject obj);

    ResultObject Trim(RequestObject obj);

    ResultObject ParseInt(RequestObject obj);

    ResultObject Execute(CommandData cmd);
}
