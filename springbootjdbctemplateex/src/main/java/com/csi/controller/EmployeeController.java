package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/savedata")
    public ResponseEntity<String> saveData(@RequestBody Employee employee){
        log.info("###Trying to save data from employee: "+ employee.getEmpName());
        employeeServiceImpl.saveData(employee);
        return ResponseEntity.ok("Save Data Successfully");
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<String> updateData(@PathVariable int empId, @RequestBody Employee employee){
        employeeServiceImpl.updateData(empId, employee);
        return ResponseEntity.ok("Update Data Successfully");

    }

    @DeleteMapping("/deletedata/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteData(empId);
        return ResponseEntity.ok("Data Deleted Successfully");
    }
}
