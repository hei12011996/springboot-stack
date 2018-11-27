package com.tw.apistackbase.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    @GetMapping(path = "/getAll", produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(EmployeeStub.listAll());
    }

    @GetMapping(path = "/find", produces = {"application/json"})
    public ResponseEntity<List<Employee>> findById(@RequestParam(value = "id", required = false) Long id, @RequestParam("name") String name) {
        if (id != null) {
            return ResponseEntity.ok(Arrays.asList(EmployeeStub.findById(id)));
        } else if (name != null) {
            return ResponseEntity.ok(EmployeeStub.findByName(name));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(path = "/create", produces = {"application/json"})
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        EmployeeStub.create(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping(path = "/update", produces = {"application/json"})
    public ResponseEntity<Employee> update(@RequestParam("id") Long id, @RequestBody Employee employee) {
        return ResponseEntity.ok(EmployeeStub.update(id, employee));
    }

    @DeleteMapping(path = "/delete/{id}", produces = {"application/json"})
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        return ResponseEntity.ok(EmployeeStub.delete(id));
    }

}
