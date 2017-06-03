/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitgray.cellphone.service;

import com.bitgray.cellphone.dao.IConsumeDao;
import com.bitgray.cellphone.dao.IParameterDao;
import com.bitgray.cellphone.dao.IRefillDao;
import com.bitgray.cellphone.entities.BalanceDTO;
import com.bitgray.cellphone.entities.Params;
import javax.ejb.EJB;
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

    @EJB
    private IParameterDao parameterDao;
    @EJB
    private IConsumeDao consumeDao;
    @EJB
    private IRefillDao refillDao;

    @GET
    @Path("balance/{mobilephone}")
    @Produces(MediaType.APPLICATION_JSON)
    public BalanceDTO getBalance(@PathParam("mobilephone") String mobilePhone) {
        Params parameter = parameterDao.findByName("costPerSecond");
        int costPerSecond = Integer.parseInt(parameter.getParamValue());
        int consumesInSeconds = consumeDao.getSumConsumeByPhone(mobilePhone);
        int refillsInMoney = refillDao.getSumRefillByPhone(mobilePhone);
        int balanceInMoney = refillsInMoney - (consumesInSeconds * costPerSecond);
        int balanceInSeconds = Math.round(balanceInMoney / costPerSecond);
        BalanceDTO balance = new BalanceDTO(mobilePhone, balanceInMoney, balanceInSeconds);
        return balance;
    }
}
