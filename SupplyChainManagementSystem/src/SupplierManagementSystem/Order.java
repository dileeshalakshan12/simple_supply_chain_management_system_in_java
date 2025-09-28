package SupplierManagementSystem;

import Enum.OrderStatus;
import User.Supplier;


// this create a new order object
public class Order {
    private static int orderIdCounter = 1;
    private final int orderId;
    private final  Material material;
    private final int quantity;
    private OrderStatus status;
    private final Supplier supplier;

    public Order( Supplier supplier, Material material, int quantity) {
        this.orderId = orderIdCounter++;
        this.material = material;
        this.quantity = quantity;
        this.status = OrderStatus.PENDING;
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public int getOrderId() {
        return orderId;
    }

    public Material getProduct() {
        return material;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Supplier: " + supplier + ", Quantity: " + quantity + ", Status: " + status;
    }
}