package model;

import service.CustomerService;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;

    public Customer(String firstName , String lastName , String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //* Accessor methods(getters) *//
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getEmail(){
        return this.email;
    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }

    public int hashcode() {
        return super.hashCode();
    }

    @Override
    public String toString(){
        return "First name : "+firstName+" Last name: "+lastName +" Email :"+email;
    }
}
