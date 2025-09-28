package orderManagement;

import User.Customer;
import WarehouseManagement.product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderManagement {
    private List<Customer> customerList = new ArrayList<>();
    private static List<order> orderList = new ArrayList<>();
    private static List<product> productList = new ArrayList<>();
    private static final String ORDER_FILE = "customerorder.txt";
    private static final String CUSTOMER_FILE = "customer.txt";

    public OrderManagement(){}

    // this method create to add new customer to list
    public void addCustomer(Customer customer){
        customerList.add(customer);
        writeCustomerToFile(customer);
        System.out.println("Customer added successfully.");
    }

    // this method gives all customers in the list
    public void viewCustomer(){
        readCustomerFromFile();
    }

    // check orders
    public void viewOrder(){
        readOrderFromFile();
    }

    // customer can create new order to a manufacturer
    public void addOrdertoList(order order){
        orderList.add(order);
        writeOrderToFile(order); // Write order to file
    }

    public List<order> getOrderList() {
        return orderList;
    }

    public List<product> getProductList() {
        return productList;
    }


    // create new customer object
    public static class order {
        private product product;
        private int quantity;

        public order(product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
            orderList.add(this);
            productList.add(product);
        }


        public int getQuantity() {
            return quantity;
        }

        @Override
        public String toString() {
            return product + " quantity: " + quantity;
        }
    }
    private void writeOrderToFile(order order) {
        try (FileWriter writer = new FileWriter(ORDER_FILE, true)) {
            writer.write(order.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeCustomerToFile(Customer customer) {
        try (FileWriter writer = new FileWriter(ORDER_FILE, true)) {
            writer.write(customer.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readOrderFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ORDER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void readCustomerFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
