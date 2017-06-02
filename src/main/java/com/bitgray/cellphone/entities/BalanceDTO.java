package com.bitgray.cellphone.entities;

import com.bitgray.cellphone.service.MobilePhoneREST;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Julian
 */

@XmlRootElement
public class BalanceDTO implements Serializable {
    
    private String mobilePhone;
    
    private int money;
    
    private int seconds;
    
    public BalanceDTO(String mobilePhone, int money, int seconds){
        this.mobilePhone = mobilePhone;
        this.money = money;
        this.seconds = seconds;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
    
    
}
