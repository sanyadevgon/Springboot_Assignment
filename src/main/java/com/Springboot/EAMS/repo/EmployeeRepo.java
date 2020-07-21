package com.Springboot.EAMS.repo;

//import com.example.jpa.Employee;
import com.Springboot.EAMS.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Transactional
    @Modifying
    @Query("update Employee e set e.salary=e.salary+ :inc")
    public void updatesalary(@Param("inc") long increment);

}