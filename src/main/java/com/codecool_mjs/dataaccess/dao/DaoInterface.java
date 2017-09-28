package com.codecool_mjs.dataaccess.dao;

import java.util.List;

public interface DaoInterface <T> {
    public List<T> getAll();
    public List<T> getBy(String category, String arg);
    public boolean update(T t);
    public boolean delete(T t);
    public boolean insert(T t);
}