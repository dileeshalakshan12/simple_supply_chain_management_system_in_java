package User;

import SupplierManagementSystem.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Supplier extends User {
    File filename = new File("Supplier.txt");
    List<User> userList = new ArrayList<>();
    private String companyName;
    private String email;
    private String phoneNumber;
    private List<Order> orders;
    private String address;
    private String bankName;

    // constructor overloading
    public Supplier(String username, String password, String companyName, String email,String address, String phoneNumber,String bankName) {
        super(username, password);
        this.companyName = companyName;
        this.address =address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bankName = bankName;
        userList.add(this);
        createAccount();
    }

    public Supplier(String companyName, String email,String address, String phoneNumber,String bankName) {
        this.companyName = companyName;
        this.address =address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bankName = bankName;
        userList.add(this);
        createAccount();
    }

    public Supplier(){}

    // implement all abstract methods in user class
    @Override
    public void createAccount() {
        try (FileWriter fileWriter = new FileWriter(filename, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            bufferedWriter.write(this.username + "," + this.password + "," + this.companyName + "," + this.email + "," + this.phoneNumber);
            bufferedWriter.newLine();
            System.out.println("Account created successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
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
            System.err.println("Error: " + e.getMessage());
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

    public String getCompanyName() {
        return companyName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String toString() {
        return "Supplier{" +
                ", companyName='" + companyName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}