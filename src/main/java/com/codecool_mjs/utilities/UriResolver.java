package com.codecool_mjs.utilities;

import com.sun.net.httpserver.HttpExchange;

public class UriResolver {

    public static String getUserIdFromURI(HttpExchange httpExchange){

        String id = null;

        String uri = httpExchange.getRequestURI().toString();

        StringBuilder sb = new StringBuilder(uri);
        sb.deleteCharAt(0);

        String [] parts = sb.toString().split("/");

        if(parts.length == 3){
            id = parts[2];
        }
        return id;
    }
}
