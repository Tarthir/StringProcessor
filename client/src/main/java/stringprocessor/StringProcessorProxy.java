package stringprocessor;

import java.io.IOException;
import java.net.URL;

import commandData.CommandData;
import commandData.ParseCommandData;
import commandData.ToLowerCommandData;
import commandData.TrimCommandData;
import requests.RequestObject;
import results.ResultObject;

/**
 * Created by tyler on 9/12/2017.
 */

public class StringProcessorProxy implements IStringProcessor{

    private static StringProcessorProxy ourInstance = new StringProcessorProxy();

    public static StringProcessorProxy getInstance() {
        return ourInstance;
    }

    private StringProcessorProxy() {
        this.serverHost = "localhost";
        this.serverPort = "8080";
    }

    private String serverHost;
    private String serverPort;

    @Override
    public ResultObject ToLowerCase(RequestObject request) {

        try {
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/toLowerCase");
            return ClientCommunicator.getInstance().send(url,request);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultObject Trim(RequestObject request) {
        try {
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/trim");
            return ClientCommunicator.getInstance().send(url,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultObject ParseInt(RequestObject request) {
        try {
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/parseInt");
            return ClientCommunicator.getInstance().send(url,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public ResultObject Execute(String type, String strToChange) {
        try{
            URL url = new URL("http://" + serverHost + ":" + serverPort + "/execute");
            CommandData cmd;
            switch (type){
                case "trim":
                    cmd = new TrimCommandData(type, strToChange);
                    return ClientCommunicator.getInstance().send(url,cmd);
                case "parseInt":
                    cmd = new ParseCommandData(type,strToChange);
                    return ClientCommunicator.getInstance().send(url,cmd);
                case "toLowerCase":
                    cmd = new ToLowerCommandData(type,strToChange);
                    return ClientCommunicator.getInstance().send(url,cmd);
            }
            return null;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
