package User;

import java.util.List;

abstract public class User {
    protected String username;
    protected String password;

    // constructor overloading
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(){}

    // create abstract method that will implement in subclasses

    // this method create to create new account for user
    public abstract void createAccount();


    // this method create to log in exiting account
    public abstract boolean login(String username,String password);

    // this method create to check user name availability.
    public abstract boolean checkUsername(String username);

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}