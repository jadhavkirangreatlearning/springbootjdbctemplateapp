package com.csi.dao;

import com.csi.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    String INSERT_SQL="insert into employee(empid, empname, empsalary, empcontactnumber, empdob)values(?, ?, ?, ?, ?)";

    String SELECT_SQL="select * from employee";

    String UPDATE_SQL="update employee set empname=?, empsalary=?, empcontactnumber=?, empdob=? where empid=?";

    String DELETE_SQL="delete from employee where empid=?";

    private Employee employee(ResultSet resultSet, int n) throws SQLException {
        return Employee.builder().empId(resultSet.getInt(1)).empName(resultSet.getString(2)).empSalary(resultSet.getDouble(3)).empContactNumber(resultSet.getLong(4)).empDOB(resultSet.getDate(5)).build();

    }

    @Override
    public void saveData(Employee employee) {

        jdbcTemplate.update(INSERT_SQL, employee.getEmpId(), employee.getEmpName(), employee.getEmpSalary(), employee.getEmpContactNumber(), employee.getEmpDOB());

    }

    @Override
    public List<Employee> getAllData() {
        return jdbcTemplate.query(SELECT_SQL, this::employee);
    }

    @Override
    public void updateData(int empId, Employee employee) {

        jdbcTemplate.update(UPDATE_SQL, employee.getEmpName(), employee.getEmpSalary(), employee.getEmpContactNumber(), employee.getEmpDOB(), empId);

    }

    @Override
    public void deleteData(int empId) {

        jdbcTemplate.update(DELETE_SQL, empId);
    }
}
