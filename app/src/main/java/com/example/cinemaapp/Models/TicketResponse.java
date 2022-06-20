package com.example.cinemaapp.Models;

public class TicketResponse {
    public String message;
    public Ticket ticket;

    @Override
    public String toString() {
        return "TicketResponse{" +
                "message='" + message + '\'' +
                ", ticket=" + ticket +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public TicketResponse(String message, Ticket ticket) {
        this.message = message;
        this.ticket = ticket;
    }
}
