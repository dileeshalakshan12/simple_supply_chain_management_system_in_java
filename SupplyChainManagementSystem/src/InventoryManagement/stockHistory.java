package InventoryManagement;

import SupplierManagementSystem.Material;

import java.text.SimpleDateFormat;
import java.util.Date;

public class stockHistory {
    private Material rawMaterial;
    private int quantity;
    private String today;

    public stockHistory(Material rawMaterial, int quantity) {
        this.rawMaterial = rawMaterial;
        this.quantity = quantity;
        this.today = formatDate(new Date());
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    @Override
    public String toString() {
        return "stockHistory{" +
                "rawMaterial=" + rawMaterial +
                ", quantity=" + quantity +
                ", Stock date='" + today + '\'' +
                '}';
    }
}