package com.demo.controller;

import com.demo.exception.RecordNotFoundException;
import com.demo.model.Employee;
import com.demo.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/savedata")
    public ResponseEntity<Employee> saveData(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.saveData(employee), HttpStatus.CREATED);
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData() {
        return ResponseEntity.ok(employeeService.getAllData());
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId) {
        return ResponseEntity.ok(employeeService.getDataById(empId));
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<Employee> updateData(@PathVariable int empId, @RequestBody Employee employee) {
        Employee employee1 = employeeService.getDataById(empId).orElseThrow(() -> new RecordNotFoundException("Id Does Not exist"));
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpSalary(employee.getEmpSalary());

        return new ResponseEntity<>(employeeService.updateData(employee1), HttpStatus.CREATED);

    }

    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        employeeService.deleteData(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData(){
        employeeService.deleteAllData();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }
}
