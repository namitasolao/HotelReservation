package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;

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
