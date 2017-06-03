package com.bitgray.cellphone.service;

import com.bitgray.cellphone.dao.IRefillDao;
import com.bitgray.cellphone.entities.Refill;
import java.util.List;
import javax.ejb.EJB;
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
public class RefillREST {
    
    @EJB
    private IRefillDao dao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Refill entity) {
        try{
            dao.create(entity);
        } catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Refill> findAll() {
        return dao.findAll();
    }
    
    @GET
    @Path("mobilephone/{mobilePhone}")
    @Produces(MediaType.APPLICATION_JSON)
    /* History by mobile phone */
    public List<Refill> findByMobilePhone(@PathParam("mobilePhone") String mobilePhone) {
       return dao.findByPhone(mobilePhone);
    }
}
