package com.bitgray.cellphone.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julian
 */
@Entity
@Table(name = "params")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Params.findAll", query = "SELECT p FROM Params p")
    , @NamedQuery(name = "Params.findByParamsId", query = "SELECT p FROM Params p WHERE p.paramsId = :paramsId")
    , @NamedQuery(name = "Params.findByName", query = "SELECT p FROM Params p WHERE p.name = :name")
    , @NamedQuery(name = "Params.findByValue", query = "SELECT p FROM Params p WHERE p.paramValue = :paramValue")})
public class Params implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "params_id")
    private Integer paramsId;
    
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "param_value")
    private String paramValue;

    public Params() {
    }

    public Params(Integer paramsId) {
        this.paramsId = paramsId;
    }

    public Params(Integer paramsId, String name, String paramValue) {
        this.paramsId = paramsId;
        this.name = name;
        this.paramValue = paramValue;
    }

    public Integer getParamsId() {
        return paramsId;
    }

    public void setParamsId(Integer paramsId) {
        this.paramsId = paramsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paramsId != null ? paramsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Params)) {
            return false;
        }
        Params other = (Params) object;
        if ((this.paramsId == null && other.paramsId != null) || (this.paramsId != null && !this.paramsId.equals(other.paramsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitgray.cellphone.entities.Params[ paramsId=" + paramsId + " ]";
    }
    
}
