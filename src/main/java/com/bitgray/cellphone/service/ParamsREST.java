package com.bitgray.cellphone.service;

import com.bitgray.cellphone.dao.IParameterDao;
import com.bitgray.cellphone.entities.Params;
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
@Path("/parameter")
public class ParamsREST {

    @EJB
    IParameterDao dao;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Params entity) {
        try{
            dao.create(entity);
        } catch(Exception e){
            Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        return Response.status(Response.Status.CREATED).build();
    }
    
    @GET
    @Path("/name/{name}")
    @Produces( MediaType.APPLICATION_JSON)
    public Params findByName(@PathParam("name") String parameterName) {
        return dao.findByName(parameterName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Params> findAll() {
        return dao.findAll();
    }
}
