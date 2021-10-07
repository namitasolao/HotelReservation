package dataCollection;

import model.Customer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerDB {
    final static  Map<String , Customer> customerTable = new HashMap<String , Customer>();

    public static Customer getCustomer(String email){
        if(!customerTable.containsKey(email))
            return null;
        else
             return customerTable.get(email);
    }

    public static Collection<Customer> getAllCustomers(){
        return customerTable.values();
    }

    public static void addNewCustomer(String email , Customer newCustomer){
        customerTable.put(email , newCustomer);
    }
}
