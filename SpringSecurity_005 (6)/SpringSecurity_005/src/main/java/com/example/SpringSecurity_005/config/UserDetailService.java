package com.example.SpringSecurity_005.config;

import com.example.SpringSecurity_005.entity.Employee;
import com.example.SpringSecurity_005.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailService implements UserDetailsService {
    @Autowired
    EmpRepo empRepo;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Employee employee = empRepo.findByEmail(username);
         if (employee==null){
             throw new UsernameNotFoundException("user not found");
         }
         else {
             return new CustomUser(employee);
         }
    }
}
