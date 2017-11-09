package com.codecool_mjs.controller;

import com.codecool_mjs.utilities.MimeTypeResolver;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

public class StaticController implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String root = "../../resources/web/static";
        URI uri = httpExchange.getRequestURI();
        String path = uri.getPath();

        File file = new File(root + path).getCanonicalFile();

        OutputStream os = httpExchange.getResponseBody();

        if(file.exists()) {
            sendFile(httpExchange, file);
        } else {
            send404(httpExchange);
        }
    }

    private void send404(HttpExchange httpExchange) throws IOException {
        String response = "404 (Not Found)\n";
        httpExchange.sendResponseHeaders(404, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.toString().getBytes());
        os.close();
    }

    private void sendFile(HttpExchange httpExchange, File file) throws IOException {

        MimeTypeResolver resolver = new MimeTypeResolver(file);
        String mime = resolver.getMimeType();

        httpExchange.getResponseHeaders().set("Content-Type", mime);
        httpExchange.sendResponseHeaders(200, 0);

        OutputStream os = httpExchange.getResponseBody();

        FileInputStream fs = new FileInputStream(file);
        final byte[] buffer = new byte[0x10000];
        int count = 0;
        while((count = fs.read(buffer)) >= 0) {
            os.write(buffer, 0, count);
        }
        fs.close();
        os.close();
    }
}
