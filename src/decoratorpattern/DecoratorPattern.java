
package decoratorpattern;

// Abstract class with method to override
abstract class Employee{
    String name;
    String jobDescription;                  // Job description
        
    public abstract String getJobDescription();    // Overriding this method will cause Decorator pattern when using Composition (as below)
}

// Job decorator 
abstract class JobDecorator extends Employee{
    public abstract String getJobDescription(); 
}

// Concrete class that inherits from Employee
class FullTimeEmployee extends Employee{

    public FullTimeEmployee(String name) {
        this.name = name;
        this.jobDescription = "Full-Time" ;       
        
    }
    
    @Override
    public String getJobDescription() {
        return this.name + " " + this.jobDescription;
    }
}



// Senior Decorator
class SeniorDecorator extends JobDecorator{
    Employee employee;

    public SeniorDecorator(Employee e) {
        this.employee = e;
    }
    
    @Override
    public String getJobDescription() {
        return employee.getJobDescription() + ": Senior Employee";
    }
}

// Hiring Manager Decorator
class HiringManagerDecorator extends JobDecorator{
    Employee employee;

    public HiringManagerDecorator(Employee e) {
        this.employee = e;
    }
    
    @Override
    public String getJobDescription() {
        return employee.getJobDescription() + ", Hiring Manager";
    }
}

// Training Manager
class TrainingManagerDecorator extends JobDecorator{
    Employee employee;

    public TrainingManagerDecorator(Employee e) {
        this.employee = e;
    }
    
    @Override
    public String getJobDescription() {
        return employee.getJobDescription() + ", Training Manager";
    }
}

// Production Decorator
class ProductionManagerDecorator extends JobDecorator{
    Employee employee;

    public ProductionManagerDecorator(Employee e) {
        this.employee = e;
    }
    
    @Override
    public String getJobDescription() {
        return employee.getJobDescription() + ", Production Manager";
    }
}

/**
 *
 * @author Alfredo
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        // Employees
        Employee employee1 = new FullTimeEmployee("John");
               
        // Employee 1 is a Senior, Hiring Manager, and Production Manager
        employee1 = new SeniorDecorator(employee1);
        employee1 = new HiringManagerDecorator(employee1);
        employee1 = new ProductionManagerDecorator(employee1);
        
        
        // Employee 2 is a Senior, Hiring Manager, and Training Manager
        Employee employee2 = new FullTimeEmployee("Olarc");
        employee2 = new SeniorDecorator(employee2);
        employee2 = new HiringManagerDecorator(employee2);
        employee2 = new TrainingManagerDecorator(employee2);
        
        
        // Employee 3 is a Senior, Hiring Manager, Training Manager, and Production Manager
        
        Employee employee3 = new FullTimeEmployee("Vicky");
        employee3 = new SeniorDecorator(employee3);
        employee3 = new HiringManagerDecorator(employee3);
        employee3 = new TrainingManagerDecorator(employee3);
        employee3 = new ProductionManagerDecorator(employee3);
        
        // Output
        String outputEmployee1 = employee1.getJobDescription();
        System.out.println(outputEmployee1);
        
        String outputEmployee2= employee2.getJobDescription();
        System.out.println(outputEmployee2);
        
        String outputEmployee3 = employee3.getJobDescription();
        System.out.println(outputEmployee3);
        
    }
    
}
