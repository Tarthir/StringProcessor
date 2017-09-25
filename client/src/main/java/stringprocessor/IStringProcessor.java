package stringprocessor;

import commandData.CommandData;
import requests.RequestObject;
import results.ResultObject;

/**
 * Created by tyler on 9/12/2017.
 */

public interface IStringProcessor {

    ResultObject ToLowerCase(RequestObject obj);

    ResultObject Trim(RequestObject obj);

    ResultObject ParseInt(RequestObject obj);

    ResultObject Execute(String type, String strToChange);
}
