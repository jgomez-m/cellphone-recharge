/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitgray.cellphone.service;

import com.bitgray.cellphone.entities.BalanceDTO;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Julian
 */
@Stateless
@Path("/mobilephone")
public class MobilePhoneREST {
    
    @GET
    @Path("balance/{mobilephone}")
    @Produces(MediaType.APPLICATION_JSON)
    public BalanceDTO getBalance(@PathParam("mobilephone") String mobilePhone){
        return null;
    }
}
