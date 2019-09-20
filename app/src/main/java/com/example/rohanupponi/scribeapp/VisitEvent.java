package com.example.rohanupponi.scribeapp;

public class VisitEvent extends Object{
    private String appointment;
    private String organization;
    private String date;
    private String doctor;
    private String prescription;
    private String notes;

    public String getAppointment() {
        return appointment;
    }
    public void setAppointment(String newAppointment) {
        appointment = newAppointment;
    }

    public String getOrganization() {
        return organization;
    }
    public void setOrganization(String newOrganization) {
        organization = newOrganization;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String newDate) {
        date = newDate;
    }

    public String getDoctor() {
        return doctor;
    }
    public void setDoctor(String newDoctor) {
        doctor = newDoctor;
    }

    public String getPrescription() {
        return prescription;
    }
    public void setPrescription(String newPrescription) {
        prescription = newPrescription;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String newNotes) {
        notes = newNotes;
    }
}