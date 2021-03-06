package com.encoder;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;

import commandData.CommandData;
import commandData.ParseCommandData;
import commandData.ToLowerCommandData;
import commandData.TrimCommandData;
import requests.RequestObject;
import results.ResultObject;

public class Encoder {

    private Gson gson = new Gson();
    public Encoder() {
    }
    /**
     * This encodes java objects into JSON
     * */
    public void encode(Object obj,OutputStream respBody) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(respBody);
        writer.write(gson.toJson(obj));
        writer.flush();
    }

    /**
     * This decodes JSON into a Request Object
     * @return RequestObject
     * */
    public RequestObject decodeRequestObj(InputStream input)throws IOException{
        Reader reader = new InputStreamReader(input);
        return gson.fromJson(reader, RequestObject.class);
    }

    /**
     * This decodes JSON into a ResultObject
     * @return ResultObject
     * */
    public ResultObject decodeResultObject(InputStream input)throws IOException {
        Reader reader = new InputStreamReader(input);
        return gson.fromJson(reader, ResultObject.class);
    }


    public CommandData decodeCommaData(InputStream input) {
        Reader reader = new InputStreamReader(input);
        return gson.fromJson(reader, CommandData.class);
    }
}
