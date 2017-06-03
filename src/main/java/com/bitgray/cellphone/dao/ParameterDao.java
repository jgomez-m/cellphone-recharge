package com.bitgray.cellphone.dao;

import com.bitgray.cellphone.entities.Params;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.ws.rs.PathParam;

/**
 *
 * @author Julian
 */
@Stateless
public class ParameterDao implements IParameterDao {
    
    @PersistenceContext(unitName = "cellphonePU")
    private EntityManager em;

    @Override
    public void create(Params entity) {
        getEntityManager().persist(entity);
    }
    
    @Override
    public Params findByName(@PathParam("name") String parameterName) {
        TypedQuery<Params> query = em.createNamedQuery(
                "Params.findByName", Params.class);
        query.setParameter("name", parameterName);
        return query.getSingleResult();
    }
     
    @Override
    public List<Params> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Params.class));
        return getEntityManager().createQuery(cq).getResultList();
    }

    protected EntityManager getEntityManager() {
        return em;
    }

}
