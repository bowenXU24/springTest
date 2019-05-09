package com.box.springboot.thymeleaf.dao;

import java.util.List;

import com.box.springboot.thymeleaf.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;



/**
 * EmployeeRepository
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //sort method
    public List<Employee> findAllByOrderByLastNameAsc();
}