package com.bitgray.cellphone.dao;

import com.bitgray.cellphone.entities.Refill;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.PathParam;

/**
 *
 * @author Julian
 */
@Local
public interface IRefillDao {
    
    public void create(Refill entity);
    
    public List<Refill> findAll();
    
    public List<Refill> findByPhone(@PathParam("mobilePhone") String mobilePhone);
    
    public int getSumRefillByPhone(String mobilePhone);
}
