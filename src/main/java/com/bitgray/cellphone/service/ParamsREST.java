package com.bitgray.cellphone.service;

import com.bitgray.cellphone.entities.Params;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
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
@Path("/parameter")
public class ParamsREST extends AbstractFacade<Params> {

    @PersistenceContext(unitName = "cellphonePU")
    private EntityManager em;

    public ParamsREST() {
        super(Params.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response create(Params entity) {
        return super.create(entity);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Params find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("/name/{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Params findByName(@PathParam("name") String parameterName) {
        TypedQuery<Params> query = getEntityManager().createNamedQuery(
                "Params.findByName", Params.class);
        return query.getSingleResult();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Params> findAll() {
        return super.findAll();
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
