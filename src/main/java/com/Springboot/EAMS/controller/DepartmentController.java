package com.Springboot.EAMS.controller;

import com.Springboot.EAMS.dto.DepartmentDTO;
import com.Springboot.EAMS.model.response.BaseMessageResponse;
import com.Springboot.EAMS.model.response.ServiceResponse;
import com.Springboot.EAMS.service.Departmentservice;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController()
@RequestMapping(value="/department", consumes = MediaType.APPLICATION_JSON_VALUE)
public class DepartmentController {

    @Autowired
    Departmentservice departmentservice;


    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @PostMapping(value = "/save")
    public ServiceResponse<?> postDepartmentDetails(@RequestBody DepartmentDTO departmentDTO) {
        log.info(
                "DepartmentController : saveDepartmentDetails : Received Request to save department"+ departmentDTO.toString());
        departmentservice.savedepartment(departmentDTO);
         return  new ServiceResponse<BaseMessageResponse>(
                 new BaseMessageResponse("Saved Successfully", HttpStatus.OK, true));
    }

    @GetMapping(value = "/{id}")
    public ServiceResponse<?>  retrieveDepartment(@PathVariable Long id) {

        return new ServiceResponse<>(
                departmentservice.getdepartment(id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ServiceResponse<?>  deletedepartment(@PathVariable long id) {

        departmentservice.deletedepartment(id);
        return  new ServiceResponse<BaseMessageResponse>(
                new BaseMessageResponse("Deleted Successfully", HttpStatus.OK, true));

    }

    @PutMapping("/{id}")
    public ServiceResponse<?> updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable long id) {

        departmentservice.updatedepartment(departmentDTO, id);
        return  new ServiceResponse<BaseMessageResponse>(
                new BaseMessageResponse("Saved Successfully", HttpStatus.OK, true));

    }

    @GetMapping("/managerdetails/{id}")
    public ServiceResponse<?> managerdetails(@PathVariable long id){

        return new ServiceResponse<>(
                departmentservice.managerDetails(id), HttpStatus.OK);
        //return departmentservice.managerDetails(id);
    }

}
