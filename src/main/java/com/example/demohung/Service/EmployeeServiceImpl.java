package com.example.demohung.Service;
//class này sẽ làm rõ các chức năng bên trong method của class EmployeeService


import com.example.demohung.Entity.Employee;
import com.example.demohung.Repository.EmployeeRepostory;
import com.example.demohung.dto.UserDetail;
import com.example.demohung.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
//annotation là khi thực hiện khởi tạo thì autowired giúp lưu nhớ nó.cứ khởi tạo là autowrired vậy r.

    EmployeeRepostory repostory;

    private final UserMapper mapper;

    public EmployeeServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }
    //EmloyeeRepostory này chính là class EmloyeeRepostory nằm bên gói Repository.

//4 hàm dưới là mình import từ lớp EmployeeService hiện ra.và giờ mình mô tả cho từng method.
   /* @Override
    public List<Employee> getAllEmployee() { return null;}
    @Override
    public Employee getByid(Long id) { return null;}
    @Override
    public void saveOrUpdate(Employee employee) { }
    @Override
    public void deleteEmployee(long id) { }*/

    @Override
    public List<Employee> getAllEmployee() {return (List<Employee>) repostory.findAll();}

    @Override
    public Employee getByid(Long id) {return null;}

    @Override
    public void saveOrUpdate(Employee employee) {repostory.save(employee);}

    //HÀM INSERT MỚI TẠO OF HƯNG
    @Override
    public Employee save(Employee employee) {return repostory.save(employee);}

    @Override
    public void deleteEmployee(long id) {
        repostory.deleteById(id);
    }

    //tìm theo id tự mò
    @Override
    public Optional<Employee> findById(Long id) {
        return repostory.findById(id);
    }


    //tìm theo lastname bằng cách @quest
    @Override
    public List<Employee> getAlllastname(String lastname) {return repostory.timtheocackhaccuaHoachi(lastname);
    }


    //xử lý của mapper
    @Override
    public List<UserDetail> timAllUser() {
        return mapper.layUser(repostory.findAll());
    }


}
