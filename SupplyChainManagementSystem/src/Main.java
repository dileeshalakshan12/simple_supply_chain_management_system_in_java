import EmployeeManagement.*;
import FinanaceManagement.FinanceManagement;
import SupplierManagementSystem.SupplierManagementSystem;
import User.Customer;
import User.Manufacturer;
import User.Supplier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import SupplierManagementSystem.Order;
import SupplierManagementSystem.Material;
import InventoryManagement.InventoryManagementSystem;
import Enum.OrderStatus;
import WarehouseManagement.WarehouseManagement;
import WarehouseManagement.*;
import orderManagement.OrderManagement;


public class Main {

    static SupplierManagementSystem sm1 = new SupplierManagementSystem();
    static InventoryManagementSystem iw1 = new InventoryManagementSystem();
    static product pr1 = new product();
    static WarehouseManagement wr1 = new WarehouseManagement();
    static Employee em1 = new Employee();
    static Customer cus1 = new Customer();
    static Supplier sup1 = new Supplier();
    static List<Manufacturer> manufacturers = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();
    static List<Supplier> suppliers = new ArrayList<>();
    static List<product> products = new ArrayList<>();
    static EmployeeManagement emm1 = new EmployeeManagement();
    static OrderManagement or1 = new OrderManagement();
    static FinanceManagement fm1 = new FinanceManagement();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SupplierManagementSystem system = new SupplierManagementSystem();

        System.out.println("\t.......Supply Chain Management System.......\t\n");
        System.out.println("\t---------Welcome to the Login Page!---------\t");
        System.out.println("Select your user type:");
        System.out.println("1. Manufacturer");
        System.out.println("2. Customer");
        System.out.println("3. Supplier");
        System.out.println("Enter your choice: ");
        int userChoice = scanner.nextInt();
        System.out.println("\n1. Login");
        System.out.println("2. Create Account");
        System.out.println("Enter your choice: ");
        int userLogChoice = scanner.nextInt();
        if (userChoice == 1) {
            if (userLogChoice == 1) {
                System.out.println("---- LOG IN ----");
                System.out.println("Enter your user name: ");
                String userName = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next();
                Manufacturer man1 = new Manufacturer();
                man1.login(userName, password);
            } else if (userLogChoice == 2) {
                System.out.println("--- CREATE ACCOUNT ---");
                System.out.println("Enter your user name: ");
                String userName = scanner.next();
                System.out.println("Enter your password: ");
                String password = scanner.next();
                System.out.println("Enter your retypePassword: ");
                String retypePassword = scanner.next();
                if (password.equals(retypePassword)) {
                    Manufacturer man1 = new Manufacturer(userName, password);
                    man1.createAccount();
                    manufacturers.add(man1);
                } else {
                    System.out.println("Password doesn't Match!");
                    return;
                }
            } else {
                System.out.println("Invalid Choice!");
            }
        } else if (userChoice == 2) {
            if (userLogChoice == 1) {
                System.out.println("---- LOG IN ----");
                System.out.println("Enter your user name: ");
                String userName = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next();
                Customer cus1 = new Customer();
                cus1.login(userName, password);
            } else if (userLogChoice == 2) {
                System.out.println("--- CREATE ACCOUNT ---");
                System.out.println("Enter your user name: ");
                String userName = scanner.next();
                System.out.println("Enter your password: ");
                String password = scanner.next();
                System.out.println("Enter your retypePassword: ");
                String retypePassword = scanner.next();
                if (password.equals(retypePassword)) {
                    System.out.println("Enter your full name: ");
                    String fullName = scanner.nextLine();
                    System.out.println("Enter your address: ");
                    String address = scanner.nextLine();
                    cus1 = new Customer(userName, password, fullName, address);
                    cus1.createAccount();
                    customers.add(cus1);
                } else {
                    System.out.println("Password doesn't Match!");
                    return;
                }
            } else {
                System.out.println("Invalid Choice!");
            }
        } else if (userChoice == 3) {
            if (userLogChoice == 1) {
                System.out.println("---- LOG IN ----");
                System.out.println("Enter your user name: ");
                String userName = scanner.next();
                System.out.print("Enter your password: ");
                String password = scanner.next();
                Supplier sup1 = new Supplier();
                sup1.login(userName, password);
            } else if (userLogChoice == 2) {
                System.out.println("--- CREATE ACCOUNT ---");
                System.out.println("Enter your user name: ");
                String userName = scanner.next();
                System.out.println("Enter your password: ");
                String password = scanner.next();
                System.out.println("Enter your retypePassword: ");
                String retypePassword = scanner.next();
                if (password.equals(retypePassword)) {
                    System.out.println("Enter your company name: ");
                    String fullName = scanner.next();
                    System.out.println("Enter your email: ");
                    String email = scanner.next();
                    System.out.println("Enter your address: ");
                    String address = scanner.next();
                    System.out.println("Enter your phoneNumber: ");
                    String phoneNumber = scanner.next();
                    System.out.println("Enter your bank name: ");
                    String bankName = scanner.next();
                    sup1 = new Supplier(userName, password, fullName, email, address, phoneNumber, bankName);
                    sup1.createAccount();
                    suppliers.add(sup1);
                } else {
                    System.out.println("Password doesn't Match!");
                    return;
                }
            } else {
                System.out.println("Invalid Choice!");
            }
        } else {
            System.out.println("Invalid Choice!");
            return;
        }
        if (userChoice == 1) {
            while (true) {
                System.out.println("Manufacture Management System");
                System.out.println("\n1. Supplier Management System");
                System.out.println("2. Inventory Management System");
                System.out.println("3. Store Management System");
                System.out.println("4. Employee Management System");
                System.out.println("5. Order Management System");
                System.out.println("6. Finance Management System");
                System.out.println("7. Log Out");
                int manufactureChoice = scanner.nextInt();
                if (manufactureChoice == 1) {
                    while (true) {
                        System.out.println("Supplier Management System Menu:");
                        System.out.println("1. Add Supplier");
                        System.out.println("2. Add Material");
                        System.out.println("3. Place Order");
                        System.out.println("4. Change Order Status");
                        System.out.println("5. View supplier");
                        System.out.println("6. Back");
                        System.out.print("Enter your choice: ");
                        int choice = scanner.nextInt();
                        if (choice == 1) {
                            System.out.println("Enter company name:");
                            String companyName = scanner.next();

                            System.out.println("Enter email:");
                            String email = scanner.next();

                            System.out.println("Enter address:");
                            String address = scanner.next();

                            System.out.println("Enter phone number:");
                            String phoneNumber = scanner.next();

                            System.out.println("Enter bank name:");
                            String bankName = scanner.next();

                            Supplier supplier = new Supplier(companyName, email, address, phoneNumber, bankName);
                            sm1.addSupplier(supplier);
                            System.out.println("Supplier created successfully:");
                        } else if (choice == 2) {
                            System.out.println("Enter Material name:");
                            String materialname = scanner.next();

                            System.out.println("Enter Material price:");
                            String price = scanner.next();

                            System.out.println("Enter reorder level:");
                            String reorderLevel = scanner.next();

                            Material mat1 = new Material(materialname, Double.parseDouble(price), Integer.parseInt(reorderLevel));
                            sm1.addMaterial(mat1);
                            iw1.setRawMaterialList(mat1);
                            System.out.println("Material added successfully:");
                        } else if (choice == 3) {
                            int count = 1;
                            List<Supplier> supplierList = sm1.getSuppliers();
                            for (Supplier supplier : supplierList) {
                                System.out.println(count + " " + supplier);
                            }
                            System.out.println("Choose Supplier:");
                            int Supplierid = scanner.nextInt();
                            List<Material> productList = sm1.getMaterials();
                            count = 1;
                            for (Material material : productList) {
                                System.out.println(count + " " + material);
                            }
                            System.out.println("Choose product:");
                            int productName = scanner.nextInt();
                            System.out.println("Enter quantity you need to order:");
                            String quantity = scanner.next();
                            Order order = new Order(supplierList.get(Supplierid - 1), productList.get(productName - 1), Integer.parseInt(quantity));
                            sm1.placeOrder(order);
                        } else if (choice == 4) {
                            List<Order> orderList = sm1.getOrders();
                            int count = 1;
                            for (Order order : orderList) {
                                System.out.println(count + " " + orderList);
                            }
                            System.out.println("Choose Order:");
                            int Orderid = scanner.nextInt();
                            if (Orderid <= orderList.size()) {
                                System.out.println("1. Accept");
                                System.out.println("2. Reject");
                                System.out.println("3. Delivered");
                                System.out.println("Enter your order status: ");
                                int orderStatus = scanner.nextInt();
                                if (orderStatus == 1) {
                                    orderList.get(Orderid - 1).setStatus(OrderStatus.ACCEPTED);
                                } else if (orderStatus == 2) {
                                    orderList.get(Orderid - 1).setStatus(OrderStatus.REJECTED);
                                } else if (orderStatus == 3) {
                                    orderList.get(Orderid - 1).setStatus(OrderStatus.ON_DELIVERY);
                                } else {
                                    System.out.println("Invalid choice.");
                                    return;
                                }
                            } else {
                                System.out.println("Invalid input!");
                            }
                        } else if (choice == 5) {
                            try {
                                sm1.viewSupplier();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            break;
                        }

                    }

                } else if (manufactureChoice == 2) {
                    int notification = iw1.checkReorderLevel();
                    System.out.println("----Inventory Management System----");
                    System.out.println("1. Stock in");
                    System.out.println("2. Stock out");
                    System.out.println("3. View quantity");
                    System.out.println("4. Back");
                    int inventoryChoice = scanner.nextInt();
                    if (inventoryChoice == 1) {
                        List<Material> rawMaterialList = sm1.getMaterials();
                        int count1 = 1;
                        for (Material rawMaterial : rawMaterialList) {
                            System.out.println(count1 + " " + rawMaterial);
                            count1++;
                        }
                        System.out.println("Which raw material status do you need to change.");
                        int rawChoice = scanner.nextInt();
                        System.out.println("How many quantity stock in.");
                        int quantity = scanner.nextInt();
                        iw1.stockIn(rawMaterialList.get(rawChoice - 1), quantity);
                    } else if (inventoryChoice == 2) {
                        List<Material> rawMaterialList = iw1.getRawMaterialList();
                        int count1 = 1;
                        for (Material rawMaterial : rawMaterialList) {
                            System.out.println(count1 + " " + rawMaterial);
                            count1++;
                        }
                        System.out.println("Which raw material status do you need to change.");
                        int rawChoice = scanner.nextInt();
                        System.out.println("How many quantity stock out.");
                        int quantity = scanner.nextInt();
                        iw1.stockOut(rawMaterialList.get(rawChoice - 1), quantity);
                    } else if (inventoryChoice == 3) {
                        List<Material> rawMaterialList = iw1.getRawMaterialList();
                        for (Material rawMaterial : rawMaterialList) {
                            System.out.println(rawMaterial.getProductName() + " " + rawMaterial.getQuantity());
                        }
                    } else {
                        return;
                    }
                } else if (manufactureChoice == 3) {
                    System.out.println("----Warehouse Management System----");
                    System.out.println("\n1. Add new products");
                    System.out.println("2. Add new store/warehouse");
                    System.out.println("3. View stores");
                    System.out.println("4. View products");
                    System.out.println("5. Make sales");
                    System.out.println("6. Back");
                    int storeChoice = scanner.nextInt();
                    if (storeChoice == 1) {
                        System.out.println("Enter your finished product name: ");
                        String productName = scanner.next();
                        System.out.println("Enter your product price: ");
                        int price = scanner.nextInt();
                        pr1 = new product(productName, price);
                        wr1.addProduct(pr1);
                        products.add(pr1);
                    } else if (storeChoice == 2) {
                        System.out.println("Enter your warehouse location: ");
                        String location = scanner.next();
                        System.out.println("Enter your warehouse capacity: ");
                        int capacity = scanner.nextInt();
                        warehouse wh1 = new warehouse(location, capacity);
                        wr1.addStore(wh1);
                    } else if (storeChoice == 3) {
                        wr1.viewWarehouse();
                    } else if (storeChoice == 4) {
                        wr1.viewProducts();
                    } else if (storeChoice == 5) {
                        System.out.println("Enter your Sales: ");
                        int sales = scanner.nextInt();
                        wr1.makeSales(sales);
                        System.out.println("Sale: " + sales + " added successfully");
                    } else {
                        return;
                    }
                } else if (manufactureChoice == 4) {
                    System.out.println("----Employee Management System----");
                    System.out.println("\n1. Add new employee");
                    System.out.println("2. View employees");
                    System.out.println("3. Remove employee");
                    System.out.println("4. Calculate salary");
                    System.out.println("5. Back");
                    int employeeChoice = scanner.nextInt();
                    if (employeeChoice == 1) {
                        System.out.println("Enter your employee name: ");
                        String employeeName = scanner.next();
                        System.out.println("Enter your employee position: ");
                        String employeePosition = scanner.next();
                        System.out.println("Enter your employee email: ");
                        String employeeContact = scanner.next();
                        System.out.println("Enter your employee salary rate: ");
                        double salaryRate = scanner.nextDouble();
                        em1 = new Employee(employeeName, employeePosition, employeeContact, salaryRate);
                        emm1.addEmployee(em1);
                    } else if (employeeChoice == 2) {
                        emm1.viewEmployee();
                    } else if (employeeChoice == 3) {
                        List<Employee> employeeList = EmployeeManagement.getEmployeeList();
                        int count3 = 1;
                        for (Employee employee : employeeList) {
                            System.out.println(count3 + " " + employee);
                            count3++;
                        }
                        System.out.println("Which employee need to remove: ");
                        int emChoice = scanner.nextInt();
                        emm1.removeEmployee(employeeList.get(emChoice - 1));
                    } else if (employeeChoice == 4) {
                        List<Employee> employeeList = emm1.getEmployeeList();
                        int count3 = 1;
                        for (Employee employee : employeeList) {
                            System.out.println(count3 + " " + employee);
                            count3++;
                        }
                        System.out.println("Which employee need to calculate salary: ");
                        int emChoice = scanner.nextInt();
                        System.out.println("Employee work hours: ");
                        int workHour = scanner.nextInt();
                        emm1.calculateSalary(employeeList.get(emChoice - 1), workHour);
                    } else {
                        return;
                    }
                } else if (manufactureChoice == 5) {
                    System.out.println("----Order Management System----");
                    System.out.println("1. View customer");
                    System.out.println("2. View orders");
                    System.out.println("3. Back");
                    int orderChoice = scanner.nextInt();
                    if (orderChoice == 1) {
                        or1.viewCustomer();
                    } else if (orderChoice == 2) {
                        or1.viewOrder();
                    } else {
                        return;
                    }
                } else if (manufactureChoice == 6) {
                    System.out.println("----Finance Management System----");
                    System.out.println("\n1. Total Cost");
                    System.out.println("2. Total Sales");
                    System.out.println("3. Total Profit");
                    System.out.println("4. Total allSalary");
                    System.out.println("5. Generate income statement");
                    int financeChoice = scanner.nextInt();
                    if (financeChoice == 1) {
                        fm1.calculateCost();
                    } else if (financeChoice == 2) {
                        fm1.calculateSales();
                    } else if (financeChoice == 3) {
                        fm1.calculateProfit();
                    } else if (financeChoice == 4) {
                        fm1.calculateSalary();
                    } else if (financeChoice == 5) {
                        fm1.generateIncomeSheet();
                    } else {
                        System.out.println("Invalid Choice");
                        return;
                    }
                } else if (manufactureChoice == 7) {
                    Main.main(new String[]{});
                }
            }
        } else if (userChoice == 2) {
            while (true) {
                System.out.println("--- Customer ---");
                System.out.println("\n1. Add order");
                System.out.println("2. View order status");
                System.out.println("3. Back");
                int customerChoice = scanner.nextInt();
                if (customerChoice == 1) {
                    int count1 = 1;
                    for (product product : products) {
                        System.out.println(count1 + " " + product);
                        count1++;
                    }
                    System.out.println("Which product select for order.");
                    int proChoice = scanner.nextInt();
                    System.out.println("How many quantity to you want");
                    int quantity = scanner.nextInt();
                    OrderManagement.order ore1 = new OrderManagement.order(products.get(proChoice - 1), quantity);
                    or1.addOrdertoList(ore1);
                } else if (customerChoice == 2) {
                    List<OrderManagement.order> orders = or1.getOrderList();
                    for (OrderManagement.order order : orders) {
                        System.out.println(order);
                    }
                } else if (customerChoice == 3) {
                    Main.main(new String[]{});
                } else {
                    System.out.println("Invalid choice!");
                    return;
                }
            }
        } else if (userChoice == 3) {
            System.out.println("Account create successfully.");
        }
    }
}