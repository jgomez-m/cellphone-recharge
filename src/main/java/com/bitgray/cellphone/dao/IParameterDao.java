package com.bitgray.cellphone.dao;

import com.bitgray.cellphone.entities.Params;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.PathParam;

/**
 *
 * @author Julian
 */
@Local
public interface IParameterDao {
    
    public void create(Params entity);
    
    public Params findByName(@PathParam("name") String parameterName);
    
    public List<Params> findAll();
}
