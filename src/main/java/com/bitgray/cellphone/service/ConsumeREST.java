package com.bitgray.cellphone.service;

import com.bitgray.cellphone.entities.Consume;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Path("/consume")
public class ConsumeREST extends AbstractFacade<Consume> {

    @PersistenceContext(unitName = "cellphonePU")
    private EntityManager em;

    public ConsumeREST() {
        super(Consume.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Consume entity) {
        return super.create(entity);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Consume find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Consume> findAll() {
        return super.findAll();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
