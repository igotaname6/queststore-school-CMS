package com.codecool_mjs.utilities;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FormResolver {

    public static Map<String, String> parseDataForm(String formData) throws UnsupportedEncodingException {

        Map<String, String> map = new HashMap<>();
        String[] pairs = formData.split("&");

        for(String pair : pairs){
            String[] keyValue = pair.split("=");
            String value = new URLDecoder().decode(keyValue[1], "UTF-8");
            map.put(keyValue[0], value);
        }
        return map;
    }
}
