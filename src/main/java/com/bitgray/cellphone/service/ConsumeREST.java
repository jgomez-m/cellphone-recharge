package com.bitgray.cellphone.service;

import com.bitgray.cellphone.dao.IConsumeDao;
import com.bitgray.cellphone.entities.Consume;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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
public class ConsumeREST {
    
    @EJB
    private IConsumeDao dao;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Consume entity) {
        try{
            dao.create(entity);
        } catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Consume> findAll() {
        return dao.findAll();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{mobilephone}")
    public List<Consume> findByPhone(@PathParam("mobilephone") String mobilePhone){
        return dao.findByPhone(mobilePhone);
    }
    
}
