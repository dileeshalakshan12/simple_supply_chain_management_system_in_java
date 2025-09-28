package SupplierManagementSystem;

import Enum.OrderStatus;
import InventoryManagement.InventoryManagementSystem;
import InventoryManagement.stockHistory;
import User.Supplier;
import orderManagement.OrderManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupplierManagementSystem{
    public static final File SUPPLIER_FILE = new File("Supplier.txt");
    public static final File MATERIAL_FILE = new File("materials.txt");
    public static final File ORDER_FILE = new File("orders.txt");

    public static List<Supplier> suppliers = new ArrayList<>();
    public static List<Material> materials = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();

    public List<Material> getMaterials() {
        return materials;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // this method create to add new supplier
    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
        saveData(SUPPLIER_FILE, supplier);
    }

    // this method create to view supplier list
    public void viewSupplier() throws IOException {
        loadData(SUPPLIER_FILE);
    }

    // this method to create new raw materials
    public void addMaterial(Material material) {
        materials.add(material);
        saveData(MATERIAL_FILE, material);
    }

    // this method help to manufacturer to place order for specific supplier
    public void placeOrder(Order order) {
        orders.add(order);
        saveData(ORDER_FILE, order);
    }

    // change order status(accept, reject , delivered)
    public void changeOrderStatus(Order order, OrderStatus status) {
        order.setStatus(status);
        saveData(ORDER_FILE, orders);
        if(status == OrderStatus.DELIVERED) {
            stockHistory st1 = new stockHistory(order.getProduct(), order.getQuantity());
            InventoryManagementSystem.writeHistoryToFile(st1.toString());
        }
    }

    // file handling methods
    private static void saveData(File file,Supplier supplier) {
        try (FileWriter writer = new FileWriter(SUPPLIER_FILE, true)) {
            writer.write(supplier.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveData(File file,Order order) {
        try (FileWriter writer = new FileWriter(ORDER_FILE, true)) {
            writer.write(order.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveData(File file,Material material) {
        try (FileWriter writer = new FileWriter(MATERIAL_FILE, true)) {
            writer.write(material.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void saveData(File file, List<Order> orders){
        try (FileWriter writer = new FileWriter(MATERIAL_FILE, true)) {
            writer.write(orders.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void loadData(File file) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}