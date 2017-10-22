package com.nemanjagajic.controller;

import com.nemanjagajic.dao.FacultyDAO;
import com.nemanjagajic.dao.StudentDAO;
import com.nemanjagajic.model.persistence.Student;
import com.nemanjagajic.model.rest.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController implements BasicController<Student, StudentRequest> {
    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private FacultyDAO facultyDAO;

    @Override
    @ResponseBody
    @GetMapping("getAll")
    public List<Student> getAll() {
        return studentDAO.getAll();
    }

    @Override
    @ResponseBody
    @GetMapping("get/{id}")
    public Student getById(@PathVariable("id") Integer id) {
        return studentDAO.getById(id);
    }

    @Override
    @ResponseBody
    @PostMapping("add")
    public Student post(@RequestBody StudentRequest entity) {
        System.out.println(entity);

        Student student = new Student();
        student.setName(entity.getName());
        student.setLastName(entity.getLastName());
        student.setFaculty(facultyDAO.getById(entity.getFacultyId()));
        return studentDAO.create(student);
    }

    @Override
    @ResponseBody
    @PutMapping("update/{id}")
    public Student put(@PathVariable("id") Integer id, @RequestBody StudentRequest entity) {
        Student student = new Student();
        student.setName(entity.getName());
        student.setLastName(entity.getLastName());
        student.setFaculty(facultyDAO.getById(entity.getFacultyId()));
        return studentDAO.update(id, student);
    }

    @Override
    @ResponseBody
    @DeleteMapping("delete/{id}")
    public Student delete(@PathVariable("id") Integer id) {
        return studentDAO.delete(id);
    }
}
