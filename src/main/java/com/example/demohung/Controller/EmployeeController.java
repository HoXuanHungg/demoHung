package com.example.demohung.Controller;


import com.example.demohung.Entity.Employee;
import com.example.demohung.ErrorMessage.ErrorMessage;
import com.example.demohung.Service.EmployeeService;
import com.example.demohung.dto.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee) {
        service.saveOrUpdate(employee);
        return employee;
    }

    @GetMapping("/list")
    public List<Employee> list() {
        return service.getAllEmployee();
    }

//TÌM THEO ID:
//CÁCH 1:
    // cái này khi tìm id đó không tồn tạo sẽ trả-hiển thị null

    // @GetMapping("/timid/{id}")
    // public Optional<Employee> timid(@PathVariable(name = "id")long id){
    //  return service.findById(id);
    // }
//CÁCH 2:
    //cách này chúng ta sẽ không hiển thị null nữa, vì trong thực tế ta sẽ cần ghi chú như code dưới này.
    // nhưng cách này là cách cùi bắp k nên dùng trong thực tế.

    // @GetMapping("/timid/{id}")
    // Employee findById(@PathVariable long id){
    //   return service.findById(id).orElseThrow(()->new RuntimeException("không tìm thấy ="+id));
    //}
    //CÁCH 3: CÁCH VÍP, HIỂN THỊ THÊM STATUS, MESSAGE
    @GetMapping("/timid/{id}")
    public ResponseEntity<ErrorMessage> findById(@PathVariable Long id) {
        Optional<Employee> foundProduct = service.findById(id);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ErrorMessage("Ok", "Ra luôn anh ơi!", foundProduct)
                ) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ErrorMessage("Fail", "Tìm méo có id " + id + " này anh Hưng ơi! ", "")
                );
    }


    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") long id) {
        service.deleteEmployee(id);
        return "Xoa thanh cong" + id;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Employee employee, @PathVariable long id) {
        try {
            service.saveOrUpdate(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //tìm theo lastname
    @GetMapping("/list/{lastname}")
    public List<Employee> list2(@PathVariable String lastname) {
        return service.getAlllastname(lastname);
    }

    //hiển thị lastname và firstname
    @GetMapping("/userall")
    public List<UserDetail> ALlUser() {
        return service.timAllUser();
    }

}
