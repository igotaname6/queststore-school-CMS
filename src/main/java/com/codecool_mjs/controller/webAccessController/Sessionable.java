package com.codecool_mjs.controller.webAccessController;

import com.codecool_mjs.dataaccess.dao.DaoException;
import com.codecool_mjs.model.User;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public interface Sessionable {
    String getAccessType();
    void sendPageForPopperAccess(HttpExchange httpExchange) throws IOException, DaoException;
    void setLoggedUser();
    String processTemplate(String templateUrl) throws DaoException;
}
