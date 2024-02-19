package uz.uat.app.intercom.controller;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import uz.uat.app.intercom.model.entity.account.Department;
import uz.uat.app.intercom.model.entity.account.DepartmentRepository;

@Service
@AllArgsConstructor
public class DepartmentService {
    private DepartmentRepository departmentRepo;

    public Department save(Department department) {
        return departmentRepo.save(department);

    }

    public void delete(Department department) {
        departmentRepo.delete(department);
    }

    public List<Department> findAll() {
        return StreamSupport.stream(departmentRepo.findAll().spliterator(), false).toList();
    }

}
