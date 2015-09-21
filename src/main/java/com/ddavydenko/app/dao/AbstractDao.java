package com.ddavydenko.app.dao;

import java.util.List;

/**
 * @author ddavydenko
 *
 */
public interface AbstractDao<Type> {

    Type find(Long id);

    void saveOrUpdate(Type entity);

    List<Type> getAll();
    
    void flushAndClearSession();
}
