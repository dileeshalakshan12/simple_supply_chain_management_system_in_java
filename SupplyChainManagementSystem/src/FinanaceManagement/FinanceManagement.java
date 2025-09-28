package FinanaceManagement;

import EmployeeManagement.Employee;
import EmployeeManagement.EmployeeManagement;
import InventoryManagement.InventoryManagementSystem;
import SupplierManagementSystem.Material;
import WarehouseManagement.WarehouseManagement;
import WarehouseManagement.product;

import java.util.List;

public class FinanceManagement {
    double totalSales;
    double totalCost;
    double totalSalary;
    public FinanceManagement(){}

    // this method gives total cost
    public void calculateCost(){
        this.totalCost = InventoryManagementSystem.getTotalCosts();
        System.out.println("Total cost: " + totalCost);
    }

    // this method gives total sales
    public void calculateSales(){
        totalSales = WarehouseManagement.getSales();
        System.out.println("Total sales: " + totalSales);
    }

    // this method gives net profit
    public void calculateProfit(){
        double profit = totalSales - totalCost;
        System.out.println("Profit: " + profit);
    }

    // this gives sum of employees salary
    public void calculateSalary(){
        List<Employee> employeeList = EmployeeManagement.getEmployeeList();
        double allSalary= 0;
        for(Employee employee : employeeList){
            allSalary = allSalary + (employee.getSalaryRate()*40);
        }
        totalSalary = allSalary;
        System.out.println(totalSalary);
    }

    // sample income sheet
    public void generateIncomeSheet(){
        System.out.println("\t.....Income sheet.....");
        System.out.println("\nRevenue");
        System.out.println("\tTotal Sales\t\t " + totalSales);
        double TotalRevenue = totalSales;
        System.out.println("\tTotal Revenue\t " + TotalRevenue);
        System.out.println("\nExpenses");
        System.out.println("\tCost of Goods\t " + totalCost);
        System.out.println("\tWages\t\t " + totalSalary);
        double TotalExpenses = totalCost + totalSalary;
        System.out.println("\tTotal Expenses\t " + TotalExpenses);
        double netIncome = TotalRevenue - TotalExpenses;
        System.out.println("Net Income = \t\t" + netIncome);
    }
}

