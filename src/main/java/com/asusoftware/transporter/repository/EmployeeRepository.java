package com.asusoftware.transporter.repository;

import com.asusoftware.transporter.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/** my-transporter Created by Catalin on 12/24/2020 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {}
