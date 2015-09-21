package com.ddavydenko.app.dao.Impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ddavydenko.app.dao.AbstractDao;

/**
 * @author ddavydenko
 *
 */
public class AbstractDaoImpl<Type> implements AbstractDao<Type> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<Type> typeClass;

    public AbstractDaoImpl() {
        Object clazz = getClass().getGenericSuperclass();
        while (!(clazz instanceof ParameterizedType)) {
            clazz = ((Class<?>) clazz).getGenericSuperclass();
        }
        ParameterizedType parameterizedType = (ParameterizedType) clazz;

        this.typeClass = (Class<Type>) parameterizedType.getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    public Type find(Long id) {
        return (Type) sessionFactory.getCurrentSession().get(typeClass, id);
    }

    public void saveOrUpdate(Type entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    public List<Type> getAll() {
        return (List<Type>) sessionFactory.getCurrentSession().createCriteria(typeClass).list();
    }

    public void flushAndClearSession() {
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }
}
