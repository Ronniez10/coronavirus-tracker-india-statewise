package com.neelav.coronavirousindiastatewisetracker.models;

public class CoronaData {

    private String state;

    private int confirmed;

    private int active;

    private int recovered;

    private  int deaths;

    private String stateCode;

    private String newCasesToday;

    private String deathsToday;

    private String recoveredToday;

    public CoronaData() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(int confirmed) {
        this.confirmed = confirmed;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getNewCasesToday() {
        return newCasesToday;
    }

    public void setNewCasesToday(String newCasesToday) {
        this.newCasesToday = newCasesToday;
    }

    public String getDeathsToday() {
        return deathsToday;
    }

    public void setDeathsToday(String deathsToday) {
        this.deathsToday = deathsToday;
    }

    public String getRecoveredToday() {
        return recoveredToday;
    }

    public void setRecoveredToday(String recoveredToday) {
        this.recoveredToday = recoveredToday;
    }
}
