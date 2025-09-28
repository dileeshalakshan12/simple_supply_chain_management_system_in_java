package InventoryManagement;

import SupplierManagementSystem.Material;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InventoryManagementSystem {
    private List<Material> rawMaterialList = new ArrayList<>();
    private static double totalCosts = 0;
    private List<stockHistory> stockHistoryList = new ArrayList<>();

    private static double stockPrice;

    public InventoryManagementSystem(Material rawMaterial) {
        rawMaterialList.add(rawMaterial);
    }

    public InventoryManagementSystem() {}

    public void setRawMaterialList(Material rawMaterial) {
        rawMaterialList.add(rawMaterial);
    }

    public static double getTotalCosts() {
        return totalCosts;
    }

    // this method create to add raw materials from inventory
    public void stockIn(Material rawMaterial, int quantity) {
        if (rawMaterialList.contains(rawMaterial)) {
            int currentQuantity = rawMaterial.getQuantity();
            rawMaterial.setQuantity(quantity + currentQuantity);
            double stockPrice = calculateCost((int) rawMaterial.getProductPrice(), quantity);
            stockHistory st1 = new stockHistory(rawMaterial, quantity);
            stockHistoryList.add(st1);
            writeHistoryToFile(st1.toString());
            System.out.println("Added " + quantity + " units of " + rawMaterial + " to the inventory. Current quantity is " + rawMaterial.getQuantity());
            System.out.println("Price cost is " + stockPrice);
        } else {
            System.out.println("Raw Material not found!");
        }
    }

    // this method create to remove raw materials from inventory
    public void stockOut(Material rawMaterial, int quantity) {
        if (rawMaterialList.contains(rawMaterial)) {
            int currentQuantity = rawMaterial.getQuantity();
            if (currentQuantity >= quantity) {
                rawMaterial.setQuantity(currentQuantity - quantity);
                stockHistory st1 = new stockHistory(rawMaterial, -quantity);
                stockHistoryList.add(st1);
                writeHistoryToFile(st1.toString()); // Write history to file
                System.out.println("Removed " + quantity + " units of " + rawMaterial + " from the inventory.");
            } else {
                System.out.println("Insufficient quantity of " + rawMaterial + " in the inventory.");
            }
        } else {
            System.out.println("Product " + rawMaterial + " not found in the inventory.");
        }
    }

    // this method create to calculate total cost
    public double calculateCost(int price, int quantity) {
        this.totalCosts = totalCosts + (price * quantity);
        return price * quantity;
    }

    public List<stockHistory> getStockHistoryList() {
        return stockHistoryList;
    }

    // this method create to check inventory
    public int checkReorderLevel() {
        int count = 0;
        for (Material material : rawMaterialList) {
            int quantity = material.getQuantity();
            int reorderLevel = material.getReorderLevel();
            if (quantity <= reorderLevel) {
                count++;
            }
        }
        return count;
    }

    public List<Material> getRawMaterialList() {
        return rawMaterialList;
    }

    public static void writeHistoryToFile(String history) {
        try (FileWriter writer = new FileWriter("stock_history.txt", true)) {
            writer.write(history + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
