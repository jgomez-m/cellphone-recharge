package com.bitgray.cellphone.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "refill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Refill.findAll", query = "SELECT r FROM Refill r")
    , @NamedQuery(name = "Refill.findByRefillId", query = "SELECT r FROM Refill r WHERE r.refillId = :refillId")
    , @NamedQuery(name = "Refill.findByMobilePhone", query = "SELECT r FROM Refill r WHERE r.mobilePhone = :mobilePhone")})
public class Refill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "refill_id")
    private Integer refillId;
    
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "mobile_phone")
    private String mobilePhone;
    
    @NotNull
    @Lob
    @Column(name = "price")
    private int price;

    public Refill() {
    }

    public Refill(Integer refillId) {
        this.refillId = refillId;
    }

    public Refill(Integer refillId, String mobilePhone, int price) {
        this.refillId = refillId;
        this.mobilePhone = mobilePhone;
        this.price = price;
    }

    public Integer getRefillId() {
        return refillId;
    }

    public void setRefillId(Integer refillId) {
        this.refillId = refillId;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refillId != null ? refillId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Refill)) {
            return false;
        }
        Refill other = (Refill) object;
        if ((this.refillId == null && other.refillId != null) || (this.refillId != null && !this.refillId.equals(other.refillId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitgray.cellphone.entities.Refill[ refillId=" + refillId + " ]";
    }
    
}
