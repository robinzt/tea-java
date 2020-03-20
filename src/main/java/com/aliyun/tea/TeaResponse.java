package com.aliyun.tea;

import kotlin.Pair;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

public class TeaResponse {

    public Response response;
    public int statusCode;
    public String statusMessage;
    public HashMap<String, String> headers;
    public InputStream body;

    public TeaResponse() {
        headers = new HashMap<>();
    }

    public TeaResponse(Response response) {
        headers = new HashMap<>();
        this.response = response;
        statusCode = response.code();
        statusMessage = response.message();
        body = response.body().byteStream();
        Iterator<Pair<String, String>> headers = response.headers().iterator();
        Pair<String, String> pair;
        while (headers.hasNext()) {
            pair = headers.next();
            this.headers.put(pair.getFirst(), pair.getSecond());
        }
    }

    public InputStream getResponse() throws IOException {
        return this.body;
    }
}
