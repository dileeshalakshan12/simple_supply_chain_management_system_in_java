package WarehouseManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseManagement {
    private static List<product> productList;
    private final List<warehouse> warehousesList;
    private static double totalSales = 0;
    private static final String WAREHOUSE_FILE = "warehouse.txt";
    private static final String FINISHED_PRODUCT_FILE = "finishedProduct.txt";

    public WarehouseManagement() {
        this.productList = new ArrayList<>();
        this.warehousesList = new ArrayList<>();
    }

    public static double getSales() {
        return totalSales;
    }

    public static void setSales(double sales) {
        totalSales = sales;
    }

    // this method create to add new warehouse
    public void addStore(warehouse warehouse) {
        warehousesList.add(warehouse);
        System.out.println("Warehouse added successfully.");
        writeWarehouseToFile(warehouse); // Write warehouse to file
    }

    // this method create to view all warehouses
    public void viewWarehouse(){
        readWarehouseFromFile();
    }

    // this method create to view all products
    public void viewProducts(){
        readFinishedProductFromFile();
    }

    // this method create to add product
    public void addProduct(product product) {
        productList.add(product);
        System.out.println("Product added successfully.");
        writeFinishedProductToFile(product);
    }

    // this method create to add sales
    public void makeSales(int sales) {
        totalSales = totalSales + sales;
        setSales(totalSales);
        System.out.println(totalSales);
    }

    // this method create to calculate sales
    public double calculateSale(int price, int quantity) {
        this.totalSales = totalSales + (price * quantity);
        return price * quantity;
    }

    public static List<product> getProductList() {
        return productList;
    }


    // file handling
    private void writeFinishedProductToFile(product product) {
        try (FileWriter writer = new FileWriter(FINISHED_PRODUCT_FILE, true)) {
            writer.write(product.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readWarehouseFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(WAREHOUSE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void writeWarehouseToFile(warehouse warehouse) {
        try (FileWriter writer = new FileWriter(WAREHOUSE_FILE, true)) {
            writer.write(warehouse.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void readFinishedProductFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FINISHED_PRODUCT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
