package com.tw.apistackbase.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public static List<Employee> findByName(String name){
        return employees.values().stream().filter(employee -> employee.getName().equals(name)).collect(Collectors.toList());
    }

    public static List<Employee> findByAge(Integer age){
        return employees.values().stream().filter(employee -> employee.getAge().equals(age)).collect(Collectors.toList());
    }

    public static Employee update(Long id, Employee employee){
        if (!employees.containsKey(id)) {
            return null;
        }
        employee.setId(id);
        employees.put(id, employee);
        return employee;
    }

    public static Employee delete(Long id){
        return employees.remove(id);
    }
}
