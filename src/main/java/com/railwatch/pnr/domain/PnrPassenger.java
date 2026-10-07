package com.railwatch.pnr.domain;

public class PnrPassenger {

    private final int passengerNumber;
    private final String bookingStatus;
    private final Integer bookingBerthNumber;
    private final String currentStatus;
    private final Integer currentBerthNumber;

    public PnrPassenger(
            int passengerNumber,
            String bookingStatus,
            Integer bookingBerthNumber,
            String currentStatus,
            Integer currentBerthNumber) {

        this.passengerNumber = passengerNumber;
        this.bookingStatus = bookingStatus;
        this.bookingBerthNumber = bookingBerthNumber;
        this.currentStatus = currentStatus;
        this.currentBerthNumber = currentBerthNumber;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }


    public String getCurrentStatus() {
        return currentStatus;
    }

    public Integer getBookingBerthNumber() {
        return bookingBerthNumber;
    }

    public Integer getCurrentBerthNumber() {
        return currentBerthNumber;
    }
}