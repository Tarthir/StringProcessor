package processor;

import commandData.CommandData;
import requests.RequestObject;
import results.ResultObject;

/**
 * Created by tyler on 9/12/2017.
 */

public class StringProcessor implements IStringProcessorServer{
    private static StringProcessor ourInstance = null;

    private StringProcessor(){

    }
    public static StringProcessor getInstance() {
        if(ourInstance == null) {
            ourInstance = new StringProcessor();
        }
        return ourInstance;
    }

    @Override
    public ResultObject ToLowerCase(RequestObject obj) {
        return new ResultObject(obj.getStringToChange().toLowerCase());
    }

    @Override
    public ResultObject Trim(RequestObject obj) {
        return new ResultObject(obj.getStringToChange().trim());
    }

    @Override
    public ResultObject ParseInt(RequestObject obj) {
        try {
            int num = Integer.parseInt(obj.getStringToChange());
            return new ResultObject(String.valueOf(num));
        }
        catch (Exception e){
            return new ResultObject(e.toString());
        }
    }

    @Override
    public ResultObject Execute(CommandData cmd) {
        return null;
    }

}
