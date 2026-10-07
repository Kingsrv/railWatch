package com.railwatch.pnr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PnrPassengerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int passengerNumber;

    private String bookingStatus;

    private Integer bookingBerthNumber;

    private String currentStatus;

    private Integer currentBerthNumber;

    @ManyToOne
    @JoinColumn(name = "pnr")
    private PnrEntity pnr;

    public PnrPassengerEntity() {
    }

    public Long getId() {
        return id;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Integer getBookingBerthNumber() {
        return bookingBerthNumber;
    }

    public void setBookingBerthNumber(Integer bookingBerthNumber) {
        this.bookingBerthNumber = bookingBerthNumber;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public Integer getCurrentBerthNumber() {
        return currentBerthNumber;
    }

    public void setCurrentBerthNumber(Integer currentBerthNumber) {
        this.currentBerthNumber = currentBerthNumber;
    }

    public PnrEntity getPnr() {
        return pnr;
    }

    public void setPnr(PnrEntity pnr) {
        this.pnr = pnr;
    }
}