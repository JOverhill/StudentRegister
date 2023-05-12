public class Employee extends Person implements Payment{
    private String empId = "OY_";
    private int startYear;
    private double salary;


    public Employee(String lname, String fname) {
        super(lname, fname);
        this.startYear = 2023;
        this.empId = empId + getRandomId(2001, 3000);
        
    }


    public String getIdString() {
        return empId;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(final int startYear) {
        if(startYear > 2000 && startYear <= 2023) {
            this.startYear = startYear;
        }
       
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(final double salary) {
        if (salary > 0.0) {
            this.salary = salary;
        }
    }

    public double calculatePayment() {
        double payment = 0.0;
        payment = salary * 1.5;
        return payment;
    }

    public String getEmployeeIdString() {
        return "OY_";
    }
    

    public String toString() {
        return "Employee id: " + getIdString()
        + "\nFirst name: " + getFirstName() + ", Last name: " + getLastName()
        + "\nBirthdate: " + getBirthDate()
        + "\nStart year: " + getStartYear()
        + "\nSalary: " + String.format("%.2f", calculatePayment());
    }
}
