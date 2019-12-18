package com.simplex;

import java.util.Date;

public class Visit {

    private float latitude;
    private float longitude;
    private Date arrivalTime;
    private Date departureTime;

    public Visit(float latitude, float longitude, Date arrivalTime, Date departureTime) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
}
