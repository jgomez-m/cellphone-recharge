package com.bitgray.cellphone.service;

import com.bitgray.cellphone.entities.Refill;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Julian
 */
@Stateless
@Path("/refill")
public class RefillREST extends AbstractFacade<Refill> {

    @PersistenceContext(unitName = "cellphonePU")
    private EntityManager em;

    public RefillREST() {
        super(Refill.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Refill entity) {
        return super.create(entity);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Refill find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Refill> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("mobilephone/{mobilePhone}")
    @Produces(MediaType.APPLICATION_JSON)
    /* History by mobile phone */
    public List<Refill> findByMobilePhone(@PathParam("mobilePhone") String mobilePhone) {
        TypedQuery<Refill> query = getEntityManager().createNamedQuery("Refill.findByMobilePhone", 
                Refill.class);
        query.setParameter("mobilePhone", mobilePhone);
        return query.getResultList();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
