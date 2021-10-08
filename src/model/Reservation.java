package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Customer customer , IRoom room ,Date checkInDate ,Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Date getCheckInDate(){
        return this.checkInDate;
    }
    public Date getCheckOutDate(){
        return this.checkOutDate;
    }
    public Customer getCustomer() { return this.customer; }
    public IRoom getRoom() {return this.room; }

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
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return  ("Reservation \n"+
                this.customer.getFirstName()+" "+this.customer.getLastName()+
                "\nRoom : "+this.room.getRoomnumber()+"-"+this.room.getRoomType()+
                "\nPrice : "+this.room.getroomPrice()+" per night"+
                "\nCheckin date : "+ (sdf.format(this.checkInDate))+
                " Checkout date : "+(sdf.format(this.checkOutDate)));
    }
}
