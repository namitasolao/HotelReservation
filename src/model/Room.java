package model;

import static model.RoomType.SINGLE;

public class Room implements IRoom {
    protected String roomnumber;
    protected Double roomPrice;
    protected RoomType roomType;

    public Room(){}

    public Room(String roomnumber , Double roomPrice , RoomType roomType){
        this.roomnumber = roomnumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
    }

//    //public String getRoomNumber(){
//        return this.roomnumber;
//    }
    public Double getRoomPrice(){
        return this.roomPrice;
    }
    public RoomType getEnumeration(){
        return this.roomType;
    }

    public void setRoomnumber(String roomnumber){
        this.roomnumber = roomnumber;
    }
    public void setRoomPrice(Double roomPrice){
        this.roomPrice = roomPrice;
    }
    public void setEnumeration(RoomType type){
        this.roomType = type;
    }

    @Override
    public String getRoomnumber() {
        return this.roomnumber;
    }

    @Override
    public Double getroomPrice() {
        return this.roomPrice;
    }

    @Override
    public RoomType getRoomType() {
        return this.roomType;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Room number :" + roomnumber);
        switch (roomType){
            case SINGLE: sb.append(" Single bed "); break;
            default : sb.append(" Double bed ");
        }
        sb.append(" Room price: "+roomPrice);

        return sb.toString();
    }
}
