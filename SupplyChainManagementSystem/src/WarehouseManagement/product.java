package WarehouseManagement;

public class product {
    private static int productCount = 1;
    private int productID;
    private String productName;
    private double productPrice;

    public product(String productName, double productPrice){
        productID = productCount++;
        this.productName= productName;
        this.productPrice = productPrice;
    }
    public product(){}

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return "product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}

