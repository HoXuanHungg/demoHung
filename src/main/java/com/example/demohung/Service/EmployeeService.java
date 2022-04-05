package com.example.demohung.Service;

import com.example.demohung.Entity.Employee;
import com.example.demohung.dto.UserDetail;
import java.util.List;
import java.util.Optional;

//class này là cung cấp dịch vụ cho controller, các phương thức này chưa hề có chức năng bên trong, chỉ là vỏ.
// giờ ta sẽ tạo thêm EmployeeServiceImpl để thực hiện các chức này cho các phương thức trong class này
public interface EmployeeService {

    public List<Employee> getAllEmployee();

    public Employee getByid(Long id);

    public void saveOrUpdate(Employee employee);

    public Employee save (Employee employee);

    public  void deleteEmployee(long id);

    public Optional<Employee> findById(Long id);


    public List<Employee> getAlllastname(String lastname);
    //Chi xuat ra 2 cai ma minh da chon be dto
    List<UserDetail> timAllUser();

}
