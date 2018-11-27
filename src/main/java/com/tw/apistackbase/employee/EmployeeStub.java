package com.tw.apistackbase.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeStub {
    private static Map<Long, Employee> employees = new HashMap<Long, Employee>();
    private static Long latestID = 0L;

    public static List<Employee> listAll(){
        return new ArrayList<Employee>(employees.values());
    }

    public static Employee create(Employee employee){
        latestID += 1;
        employee.setId(latestID);
        employees.put(latestID, employee);
        return employee;
    }

    public static Employee findById(Long id){
        return employees.get(id);
    }

    public static Employee update(Long id, Employee employee){
        return employees.put(id, employee);
    }

    public static Employee delete(Long id){
        return employees.remove(id);
    }
}