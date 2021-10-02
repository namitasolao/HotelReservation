package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

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

    public Customer(String firstName , String lastName , String email){
        this.firstName = firstName;
        this.lastName = lastName;

        try{
            String emailRegex = "^(.+)@(.+).com$";
            Pattern pattern = Pattern.compile(emailRegex);
            //Matcher m = pattern.matcher(emailRegex);

            if(pattern.matcher(email).matches()){
                this.email = email;
            }else {
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException ex){
            System.out.println("enter valid emailid");
            System.out.println(ex.getStackTrace()); //Correct handelling
        }
    }

    @Override
    public String toString(){
        return "Welcome "+firstName+" "+lastName +" "+email;
    }
}
