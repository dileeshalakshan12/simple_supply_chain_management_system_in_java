package EmployeeManagement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagement {
    private static List<Employee> employeeList = new ArrayList<>();
    private static final String Employee_FILE = "employees.txt";
    public EmployeeManagement(){}

    // this method create to add new employees
    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Employee added successfully to the system");
        writeEmployeeToFile(employee); // Write employee to file
    }

    // this method create to remove employee
    public void removeEmployee(Employee employee){
        if(employeeList.contains(employee)){
            employeeList.remove(employee);
            System.out.println("Employee removed successfully.");
        }else{
            System.out.println("Employee not found!");
        }
    }

    // this method create to view all employee
    public void viewEmployee(){
        readEmployeeFromFile();
    }

    public static List<Employee> getEmployeeList() {
        return employeeList;
    }


    // this method create to calculate salary of employee
    public void calculateSalary(Employee employee, int workHours){
        double hourRate = employee.getSalaryRate();
        double salary;
        if(workHours <= 40){
            salary = workHours * hourRate;
            System.out.println("Employee salary is " + salary);
        } else if (workHours > 40) {
            salary = (workHours * hourRate) + ((workHours - 40) * hourRate);
            System.out.println("Employee salary is " + salary);
        }
    }

    // file handling parts
    private void writeEmployeeToFile(Employee employee) {
        try (FileWriter writer = new FileWriter("employees.txt", true)) {
            writer.write(employee.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readEmployeeFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Employee_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
