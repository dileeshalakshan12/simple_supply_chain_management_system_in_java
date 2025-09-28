package User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Manufacturer extends User {
    File filename = new File("Manufacture.txt");
    List<User> userList = new ArrayList<>();

    // constructor overloading
    public Manufacturer(String username, String password) {
        super(username, password);
        userList.add(this);
    }
    public Manufacturer(){}


    // implement all abstract methods in user class
    @Override
    public void createAccount() {
        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(username + ":" + password);
            printWriter.flush();
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
    public boolean checkUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}