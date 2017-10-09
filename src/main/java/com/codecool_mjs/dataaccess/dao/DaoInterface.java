package com.codecool_mjs.dataaccess.dao;

import java.util.List;

public interface DaoInterface <T> {
    public List<T> getAll();
    public List<T> getBy(String category, String arg);
    public Integer update(T t);
    public Integer delete(T t);
    public Integer insert(T t);

}