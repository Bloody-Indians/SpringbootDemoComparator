package com.howtodoinjava.demo.controller;

import com.howtodoinjava.demo.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class EmployeeController {

    @RequestMapping("/")
    public List<Employee> getEmployees() {
        List<Employee> employeesList = new ArrayList<Employee>();
        employeesList.add(new Employee(1, "lokesh", "gupta", "howtodoinjava@gmail.com"));
        employeesList.add(new Employee(1, "bokesh", "gupta", "howtodoinjava@gmail.com"));
        employeesList.add(new Employee(1, "cokesh", "gupta", "howtodoinjava@gmail.com"));
        employeesList.add(new Employee(1, "dokesh", "gupta", "howtodoinjava@gmail.com"));

        // List<Employee> employees = getEmployeesFromDB();

//Sort all employees by first name
        employeesList.sort(Comparator.comparing(e -> e.getFirstName()));

//OR you can use below
        employeesList.sort(Comparator.comparing(Employee::getFirstName));

//Sort all employees by first name in reverse order
        Comparator<Employee> comparator = Comparator.comparing(e -> e.getFirstName());
        employeesList.sort(comparator.reversed());

//Sorting on multiple fields; Group by.
        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
        employeesList.sort(groupByComparator);
        return employeesList;
    }

}
