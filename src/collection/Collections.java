package collection;

import model.Customer;
import model.IRoom;

import java.util.HashMap;
import java.util.Map;

public class Collections {
    protected Map<Integer , IRoom> room = new HashMap<Integer , IRoom>();
    protected Map<String , Customer>  customer = new HashMap<String , Customer>();
}
