package User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer extends User {
    File filename = new File("Customer.txt");
    List<User> userList = new ArrayList<>();
    private String name;
    private String contactDetails;

    // constructor overloading
    public Customer(String username, String password, String name, String contactDetails) {
        super(username, password);
        this.name = name;
        this.contactDetails = contactDetails;
        userList.add(this);
        createAccount();
    }
    public Customer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    // implement all abstract methods in user class
    @Override
    public void createAccount() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getUsername() + "," + getPassword() + "," + getName() + "," + getContactDetails());
        } catch (IOException e) {
            System.err.println("Error creating account: " + e.getMessage());
        }
    }

    @Override
    public boolean login(String username,String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error during login: " + e.getMessage());
        }
        return false;
    }
    @Override
    public boolean checkUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }
        return true;
    }
}