/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitgray.cellphone.dao;

import com.bitgray.cellphone.entities.Refill;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Julian
 */
@Stateless
public class RefillDao implements IRefillDao{

    @PersistenceContext(unitName = "cellphonePU")
    private EntityManager em;
    
    @Override
    public void create(Refill entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public List<Refill> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Refill.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public List<Refill> findByPhone(String mobilePhone) {
        TypedQuery<Refill> query = em.createNamedQuery(
                "Refill.findByMobilePhone", Refill.class);
        query.setParameter("mobilePhone", mobilePhone);
        return query.getResultList();
    }
    
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public int getSumRefillByPhone(String mobilePhone) {
        Query q = getEntityManager().createNativeQuery("select sum(price) from "
                + "refill where mobile_phone = :mobilephone;");
        q.setParameter("mobilephone", mobilePhone);
        return q.getFirstResult();
    }
    
}
