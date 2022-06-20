package com.example.cinemaapp.Models.TicketOfUser;

public class TicketDetail implements Comparable<TicketDetail>{
    public int id;
    public UserTicket user;
    public VeTicket ve;

    @Override
    public String toString() {
        return "TicketDetail{" +
                "id=" + id +
                ", user=" + user +
                ", ve=" + ve +
                '}';
    }


    public TicketDetail(int id, UserTicket user, VeTicket ve) {
        this.id = id;
        this.user = user;
        this.ve = ve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserTicket getUser() {
        return user;
    }

    public void setUser(UserTicket user) {
        this.user = user;
    }

    public VeTicket getVe() {
        return ve;
    }

    public void setVe(VeTicket ve) {
        this.ve = ve;
    }



    public int compareTo(TicketDetail ticketDetail) {

        int compareId = ((TicketDetail) ticketDetail).getId();

        //ascending order
        //return this.quantity - compareQuantity;

        //descending order
        return compareId - this.id;

    }
}
