
package com.bitgray.cellphone.dao;

import com.bitgray.cellphone.entities.Consume;
import java.util.List;
import javax.ejb.Local;
import javax.ws.rs.PathParam;

/**
 *
 * @author Julian
 */
@Local
public interface IConsumeDao {
    
    public void create(Consume entity);
    
    public List<Consume> findAll();
    
    public List<Consume> findByPhone(@PathParam("mobilePhone") String mobilePhone); 
    
    public int getSumConsumeByPhone(String mobilePhone);
}
