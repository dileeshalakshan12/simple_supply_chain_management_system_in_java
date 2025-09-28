package WarehouseManagement;

public class warehouse {
    private static int warehouseCount = 1;
    private int warehouseId;
    private String location;
    private int capacity;
    public warehouse(String location, int capacity){
        warehouseId = warehouseCount++;
        this.location = location;
        this.capacity = capacity;
    }


    public warehouse(){}

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "warehouse{" +
                ", warehouseId=" + warehouseId +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
