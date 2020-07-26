package com.Springboot.EAMS.repo;

import com.Springboot.EAMS.model.entity.data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface testint  extends JpaRepository<data, Long>{
   @Query(value = "select name from test.data where id=:id",nativeQuery = true)
    public String findname(@Param("id") int id) ;
}
