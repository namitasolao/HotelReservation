package model;

public class Room implements IRoom {
    protected String roomnumber;
    protected Double roomPrice;
    protected RoomType enumeration;

    //* Accessor methods(getters) *//
    public String getRoomNumber(){
        return this.roomnumber;
    }
    public Double getRoomPrice(){
        return this.roomPrice;
    }
    public RoomType getEnumeration(){
        return this.enumeration;
    }

    //* Mutator methods(setters) *//
    public void setRoomnumber(String roomnumber){
        this.roomnumber = roomnumber;
    }
    public void setRoomPrice(Double roomPrice){
        this.roomPrice = roomPrice;
    }
    public void setEnumeration(RoomType type){
        this.enumeration = type;
    }

    @Override
    public String getRoomnumber() {
        return null;
    }

    @Override
    public Double getroomPrice() {
        return null;
    }

    @Override
    public RoomType getRoomType() {
        return null;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString(){
        return "Price of room number "+roomnumber+" is "+roomPrice;
    }
}
