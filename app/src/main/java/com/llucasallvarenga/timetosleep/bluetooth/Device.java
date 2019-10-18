package com.llucasallvarenga.timetosleep.bluetooth;

public class Device {

   private String nameBt;
   private String macAddress;

   public Device(){}

    public Device(String nameBt, String macAddress) {
        this.nameBt = nameBt;
        this.macAddress = macAddress;
    }

    public String getNameBt() {
        return nameBt;
    }

    public void setNameBt(String nameBt) {
        this.nameBt = nameBt;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
