package com.example.SpringSecurity_005.repository;

import com.example.SpringSecurity_005.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer> {
        public Employee findByEmail(String email);
}
