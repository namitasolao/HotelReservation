package model;

import service.CustomerService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    public Customer(){}

    public Customer(String firstName , String lastName , String email){
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            if (CustomerService.validateEmail(email))
                this.email = email;
            else throw new IllegalArgumentException();
        } catch (IllegalArgumentException ex){
            System.out.println("enter valid emailid");
            System.out.println(ex.getStackTrace()); //Correct handelling
        }
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

    //* Mutator methods(setters) *//
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }



    @Override
    public String toString(){
        return "First name : "+firstName+" Last name: "+lastName +" Email :"+email;
    }
}
