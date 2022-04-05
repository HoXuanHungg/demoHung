package com.example.demohung.mapper;


import com.example.demohung.Entity.Employee;
import com.example.demohung.dto.UserDetail;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDetail> layUser(List<Employee> employees);
}
