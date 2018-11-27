package com.tw.apistackbase.employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    @GetMapping(path = "/getAll", produces = {"application/json"})
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(EmployeeStub.listAll());
    }

}
