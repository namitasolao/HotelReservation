package model;

public class FreeRoom extends Room{
    public FreeRoom(String roomnumber, Double roomPrice, RoomType roomType) {
        super(roomnumber, roomPrice, roomType);
    }

    @Override
    public String toString(){
        return this.roomnumber+" is free!";
    }
}
