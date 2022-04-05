package com.example.demohung.Repository;


import com.example.demohung.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//annotation này để đánh dấu giúp cho code chạy theo luồng đúng.
public interface EmployeeRepostory extends JpaRepository<Employee, Long> {
    //Employee là class Employee bên gói Entity,Long kiểu dữ liệu.


    //tìm kiếm theo cái mình muốn của Hóa.
    //@Query("SELECT u FROM  u WHERE u.lastname = :lastname")
    // @Query("SELECT u from Employee u where u.lastname = :lastname")
    @Query(value = "select * from hung u where u.lastname = :lastname", nativeQuery = true)
    List<Employee> timtheocackhaccuaHoachi(@Param("lastname") String lastname);


}



