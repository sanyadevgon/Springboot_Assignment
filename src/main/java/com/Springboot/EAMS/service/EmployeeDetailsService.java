package com.Springboot.EAMS.service;


import com.Springboot.EAMS.exception.NullBodyException;
import com.Springboot.EAMS.repo.EmployeeDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EmployeeDetailsService {
    @Autowired
    EmployeeDetailsRepo employeeDetailsRepo;


    public void updatesalary(long inc,long dept){
        if(inc ==0 || Objects.isNull(inc))
            throw new NullBodyException("invalid data for increment ");

        employeeDetailsRepo.updatebyemployeedepatment(inc,dept);
    }

}
