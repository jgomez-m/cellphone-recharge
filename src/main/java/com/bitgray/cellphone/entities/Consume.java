package com.bitgray.cellphone.entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "consume")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consume.findAll", query = "SELECT c FROM Consume c")
    , @NamedQuery(name = "Consume.findByConsumeId", query = "SELECT c FROM Consume c WHERE c.consumeId = :consumeId")
    , @NamedQuery(name = "Consume.findByMobilePhone", query = "SELECT c FROM Consume c WHERE c.mobilePhone = :mobilePhone")
    , @NamedQuery(name = "Consume.findByNumberSeconds", query = "SELECT c FROM Consume c WHERE c.numberSeconds = :numberSeconds")})
public class Consume implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consume_id")
    private Integer consumeId;
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @NotNull
    @Column(name = "number_seconds")
    private int numberSeconds;

    public Consume() {
    }

    public Consume(Integer consumeId) {
        this.consumeId = consumeId;
    }

    public Consume(Integer consumeId, String mobilePhone, int numberSeconds) {
        this.consumeId = consumeId;
        this.mobilePhone = mobilePhone;
        this.numberSeconds = numberSeconds;
    }

    public Integer getConsumeId() {
        return consumeId;
    }

    public void setConsumeId(Integer consumeId) {
        this.consumeId = consumeId;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getNumberSeconds() {
        return numberSeconds;
    }

    public void setNumberSeconds(int numberSeconds) {
        this.numberSeconds = numberSeconds;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consumeId != null ? consumeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consume)) {
            return false;
        }
        Consume other = (Consume) object;
        if ((this.consumeId == null && other.consumeId != null) || (this.consumeId != null && !this.consumeId.equals(other.consumeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bitgray.cellphone.entities.Consume[ consumeId=" + consumeId + " ]";
    }
    
}
