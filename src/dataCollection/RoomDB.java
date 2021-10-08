package dataCollection;

import model.IRoom;
import java.util.*;

public class RoomDB {

    final static Map<String , IRoom> roomTable = new HashMap<String , IRoom>();

    public static IRoom getRoom(String roomNumber){
        return roomTable.get(roomNumber);
    }

    public static Collection<IRoom> getAllRooms(){
        Collection<IRoom> allRooms = new ArrayList<>(roomTable.values());
        return (ArrayList<IRoom>) allRooms;
    }

    public static void addRoom(String roomNumber , IRoom room){
        roomTable.put(roomNumber , room);
    }
}

