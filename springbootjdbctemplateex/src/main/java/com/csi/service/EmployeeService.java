package com.csi.service;

import com.csi.model.Employee;

import java.util.List;

public interface EmployeeService {

    public void saveData(Employee employee);

    public List<Employee> getAllData();

    public void updateData(int empId, Employee employee);

    public void deleteData(int empId);
}
