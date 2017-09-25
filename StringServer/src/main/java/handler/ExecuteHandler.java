package handler;

import com.encoder.Encoder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import command.ParseCommand;
import command.ToLowerCaseCommand;
import command.TrimCommand;
import commandData.CommandData;
import commandData.ParseCommandData;
import commandData.ToLowerCommandData;
import commandData.TrimCommandData;
import processor.StringProcessor;
import requests.RequestObject;
import results.ResultObject;

/**
 * Created by tyler on 9/12/2017.
 */

public class ExecuteHandler implements HttpHandler {
    public ExecuteHandler(){}
    @Override
    /**This method handles the clear request from the server*/
    public void handle(HttpExchange exchange) throws IOException {
        OutputStream respBody = exchange.getResponseBody();
        try {
            Encoder encoder = new Encoder();
            if (exchange.getRequestMethod().toLowerCase().equals("post")) {
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);//otherwise send Forbidden/BadRequest/etc as needed
                CommandData data = encoder.decodeCommaData(exchange.getRequestBody());
                if(data.getTypeOfCommand().equals("toLowerCase")){
                    ToLowerCaseCommand cmd = new ToLowerCaseCommand(data.getStrToChange());
                    encoder.encode(cmd.execute(),respBody);
                }
                else if(data.getTypeOfCommand().equals("parseInt")){
                    ParseCommand cmd = new ParseCommand(data.getStrToChange());
                    encoder.encode(cmd.execute(),respBody);
                }
                else if(data.getTypeOfCommand().equals("trim")){
                    TrimCommand cmd = new TrimCommand(data.getStrToChange());
                    encoder.encode(cmd.execute(),respBody);
                }

                respBody.close();
            }
            else{
                exchange.sendResponseHeaders(HttpURLConnection.HTTP_BAD_REQUEST, 0);
                respBody.close();
            }
        } catch (IOException e) {
            exchange.sendResponseHeaders(HttpURLConnection.HTTP_SERVER_ERROR, 0);
            respBody.close();
        }
    }
}
