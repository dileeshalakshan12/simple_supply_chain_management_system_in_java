package EmployeeManagement;


// create new employee object
public class Employee {
    private static int employeeCount = 1;
    private int employeeId;
    private String employeeName;
    private String position;
    private String email;
    private double salaryRate;
    public Employee(String employeeName, String position, String email, double salaryRate){
        employeeId = employeeCount++;
        this.employeeName = employeeName;
        this.position = position;
        this.email = email;
        this.salaryRate = salaryRate;
    }
    public Employee(){}
    public double getSalaryRate(){
        return salaryRate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", position='" + position + '\'' +
                ", salaryRate=" + salaryRate +
                '}';
    }
}

