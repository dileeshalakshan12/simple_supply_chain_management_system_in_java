package SupplierManagementSystem;


// this class create new material object
public class Material {
    private static int productCount = 1;
    private int productID;
    private String productName;
    private double productPrice;
    private int reorderLevel;
    private int quantity;

    public Material(String productName, double productPrice,int reorderLevel){
        productID = productCount++;
        this.productName= productName;
        this.productPrice = productPrice;
        this.reorderLevel = reorderLevel;
    }
    public Material(){}

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int i) {
        this.quantity = quantity + i;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
}
