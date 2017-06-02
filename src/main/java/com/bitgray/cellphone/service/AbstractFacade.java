package com.bitgray.cellphone.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;

/**
 *
 * @author Julian
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public Response create(T entity) {
        try{
            getEntityManager().persist(entity);
        } catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    public Response edit(T entity) {
        try{
            getEntityManager().merge(entity);
        } catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    public Response remove(T entity) {
        try{
            getEntityManager().remove(getEntityManager().merge(entity));
        } catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } 
        return Response.status(Response.Status.OK).build();
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
