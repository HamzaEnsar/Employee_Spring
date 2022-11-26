package com.example.projektzaliczeniehamzaensar.Repository;

import com.example.projektzaliczeniehamzaensar.Model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository


public interface EmployeeRepository  extends JpaRepository <Employee,Long> {



}

