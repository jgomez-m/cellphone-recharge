
package com.bitgray.cellphone.dao;

import com.bitgray.cellphone.entities.Consume;
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
public class ConsumeDao implements IConsumeDao{
    
    @PersistenceContext(unitName = "cellphonePU")
    private EntityManager em;

    @Override
    public void create(Consume entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public List<Consume> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Consume.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public List<Consume> findByPhone(String mobilePhone) {
        TypedQuery<Consume> query = em.createNamedQuery(
                "Consume.findByMobilePhone", Consume.class);
        query.setParameter("mobilePhone", mobilePhone);
        return query.getResultList();
    }
    
    protected EntityManager getEntityManager(){
        return em;
    }

    @Override
    public int getSumConsumeByPhone(String mobilePhone) {
        Query q = getEntityManager().createNativeQuery("select sum(number_seconds) from "
                + "consume where mobile_phone = :mobilephone;");
        q.setParameter("mobilephone", mobilePhone);
        return q.getFirstResult();
    }
    
}
