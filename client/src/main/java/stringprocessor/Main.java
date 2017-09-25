package stringprocessor;

import requests.RequestObject;
import results.ResultObject;

/**
 * Created by tyler on 9/12/2017.
 */

public class Main {

    public static void main(String args[]){
        //Doing ParseInt
        ResultObject result = StringProcessorProxy.getInstance().ParseInt(new RequestObject("11"));
        System.out.println("This will give us back 11: " + result.getResultingString());

        ResultObject result2 = StringProcessorProxy.getInstance().ParseInt(new RequestObject("aa"));
        System.out.println("This will give us back an error message: " + result2.getResultingString());

        ResultObject resultCmd = StringProcessorProxy.getInstance().Execute("parseInt","1503");
        System.out.println("This will give us back 1503: " + resultCmd.getResultingString());

        ResultObject resultcmdError = StringProcessorProxy.getInstance().Execute("parseInt","aaaaa");
        System.out.println("Error for Command: " + resultcmdError.getResultingString());

        //Doing ToLowerCase
        ResultObject result3 = StringProcessorProxy.getInstance().ToLowerCase(new RequestObject("ABC"));
        System.out.println("This will give us back abc: " + result3.getResultingString());

        ResultObject result4 = StringProcessorProxy.getInstance().ToLowerCase(new RequestObject("aa"));
        System.out.println("This will give us back aa: " + result4.getResultingString());

        ResultObject resultCmd2 = StringProcessorProxy.getInstance().Execute("toLowerCase","AFDSDFA");
        System.out.println("This will give us back afdsdfa: " + resultCmd2.getResultingString());


        //Doing Trim
        ResultObject result5 = StringProcessorProxy.getInstance().Trim(new RequestObject("  11  "));
        System.out.println("This will give us back \"|11|\": |" + result5.getResultingString() +"|");

        ResultObject result6 = StringProcessorProxy.getInstance().Trim(new RequestObject("aa"));
        System.out.println("This will give us back |aa|: |" + result6.getResultingString() + "|");

        ResultObject result7 = StringProcessorProxy.getInstance().Trim(new RequestObject("    I will be there     "));
        System.out.println("This will give us back |I will be there|: |" + result7.getResultingString() + "|");

        ResultObject resultCmd3 = StringProcessorProxy.getInstance().Execute("trim","   hello   ");
        System.out.println("This will give us back |hello|: |" + resultCmd3.getResultingString() + "|");
    }
}
