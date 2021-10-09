package service;

import model.Customer;
import dataCollection.CustomerDB;
import java.util.Collection;
import java.util.regex.Pattern;

public class CustomerService {
    private static final CustomerService instance = new CustomerService();

    private CustomerService(){
    }

    public static CustomerService getInstance(){
        return instance;
    }

    public boolean customerExists(String email){
        if (CustomerDB.getCustomer(email) == null)
            return false;
        return true;
    }

    public boolean validateEmail(String email){
        String emailRegex = "^(.+)@(.+).com$";
        Pattern pattern = Pattern.compile(emailRegex);

        if(pattern.matcher(email).matches()) {
            return true;
        }
        return false;
    }

    public void addCustomer(String email , String firstName , String lastName){
        Customer newCustomer = new Customer(firstName, lastName, email);
        CustomerDB.addNewCustomer(email , newCustomer);
    }

    public Customer getCustomer(String email){
        return CustomerDB.getCustomer(email);
    }

    public Collection<Customer> getAllCustomers(){
        return CustomerDB.getAllCustomers();
    }

}
