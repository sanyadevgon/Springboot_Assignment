package com.Springboot.EAMS.service;

import com.Springboot.EAMS.dto.DepartmentDTO;
import com.Springboot.EAMS.exception.GlobalEamsException;
import com.Springboot.EAMS.model.entity.Department;
import com.Springboot.EAMS.model.entity.Employee;
import com.Springboot.EAMS.repo.DepartmentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Departmentservice {

    @Autowired
    DepartmentRepo repo ;

    private ModelMapper modelMapper= new ModelMapper();


    public void savedepartment(DepartmentDTO departmentDTO){

          repo.save(modelMapper.map(departmentDTO,Department.class));
    }


    public Department getdepartment(long id){

        Optional<Department> department = repo.findById(id);
        if (!department.isPresent())
            throw new GlobalEamsException("NOT FOUND department id-" + id);
        return department.get();
    }


    public void deletedepartment(long id){
        Optional<Department> department = repo.findById(id);
        if (!department.isPresent())
            throw new GlobalEamsException("NOT FOUND department id-" + id);
        repo.deleteById(id);
    }


    public void updatedepartment(DepartmentDTO departmentDTO, long id){
        Optional<Department> department = repo.findById(id);
        if (!department.isPresent())
            throw new GlobalEamsException("NOT FOUND department id-" + id);
        if(departmentDTO.getLocation()==null || departmentDTO.getDepartment_name()==null)
            throw new NullPointerException("Location and Department name cannot be emoty fields");
        Department department1 = new Department();
        department1.setId(id);
        department1.setDepartment_name(departmentDTO.getDepartment_name());
        department1.setLocation(departmentDTO.getLocation());
        department1.setEmployees(departmentDTO.getEmployees());
        department1.setManager_id(departmentDTO.getManager_id());
        department1.setReportsto_id(departmentDTO.getReportsto_department_id());
        repo.save(department1);

    }

    //etManagerDetailsofDepartment
    public List<Employee> managerDetails (long id){

        Optional<Department> department = repo.findById(id);
        if (!department.isPresent())
            throw new GlobalEamsException("NOT FOUND department id-" + id);
        return repo.findManagerBydepartment(id);
    }



}
