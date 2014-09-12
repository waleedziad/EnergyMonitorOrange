package com.orange.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "node")
public class Node implements Serializable{
    
    @Id
    @Column(name = "transactionID")
    private int transactionID ;
    @Column(name = "apikey")
private int apikey ;
 
    @Column(name = "voltage")
private double voltage ;
 
 @Column(name = "Current")
private double CurrentAmp ;
 
 @Column(name = "power")
private double power ;

 @Column(name = "apparentPower")
private double apparentPower ;

@Column(name = "powerFactor")
private double powerFactor ;

    public Node() {
    }





    public Node(int apikey, double voltage, double current, double power, double apparentPower, double powerFactor) {
        this.apikey = apikey;
        this.voltage = voltage;
        this.CurrentAmp = current;
        this.power = power;
        this.apparentPower = apparentPower;
        this.powerFactor = powerFactor;
    }

    /**
     * @return the apikey
     */
    public int getApikey() {
        return apikey;
    }

    /**
     * @param apikey the apikey to set
     */
    public void setApikey(int apikey) {
        this.apikey = apikey;
    }

    /**
     * @return the voltage
     */
    public double getVoltage() {
        return voltage;
    }

    /**
     * @param voltage the voltage to set
     */
    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    /**
     * @return the CurrentAmp
     */
    public double getCurrentAmp() {
        return CurrentAmp;
    }

    /**
     * @param CurrentAmp the CurrentAmp to set
     */
    public void setCurrentAmp(double CurrentAmp) {
        this.CurrentAmp = CurrentAmp;
    }

    /**
     * @return the power
     */
    public double getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     * @return the apparentPower
     */
    public double getApparentPower() {
        return apparentPower;
    }

    /**
     * @param apparentPower the apparentPower to set
     */
    public void setApparentPower(double apparentPower) {
        this.apparentPower = apparentPower;
    }

    /**
     * @return the powerFactor
     */
    public double getPowerFactor() {
        return powerFactor;
    }

    /**
     * @param powerFactor the powerFactor to set
     */
    public void setPowerFactor(double powerFactor) {
        this.powerFactor = powerFactor;
    }

    /**
     * @return the transactionID
     */
    public int getTransactionID() {
        return transactionID;
    }

    /**
     * @param transactionID the transactionID to set
     */
    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
    
    
}
