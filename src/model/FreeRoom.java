package model;

public class FreeRoom extends Room{

    public FreeRoom(){
        this.roomPrice = 0.0;
    }

    @Override
    public String toString(){
        return this.roomnumber+" is free!";
    }
}
