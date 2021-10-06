package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(){}

    public Reservation(Customer customer , IRoom room ,Date checkInDate ,Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;

    }

    //* Accessor methods(getters) *//
    public Date getCheckInDate(){
        return this.checkInDate;
    }
    public Date getCheckOutDate(){
        return this.checkOutDate;
    }
    public Customer getCustomer() { return this.customer; }
    public IRoom getRoom() {return this.room; }

    //* Mutator methods(setters) *//
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    public void setRoom(IRoom room){
        this.room = room;
    }
    public void setCheckInDate(Date checkInDate){
        this.checkInDate = checkInDate;
    }
    public void setCheckOutDate(Date checkOutDate){
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toString(){

        return "Room = "+this.room.getRoomnumber()+" Checkin date = "+ (this.checkInDate)+
                " Checkout date = "+this.checkOutDate+ " Customer = "+this.customer.getFirstName()+ " "+this.customer.getLastName();
    }
}
