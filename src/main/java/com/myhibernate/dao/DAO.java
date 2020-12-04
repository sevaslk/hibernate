package com.myhibernate.dao;

public interface DAO<T, ID> {
    void create(T t);

    T read(ID ID);

    void update(T t);

    void delete(T t);
}

