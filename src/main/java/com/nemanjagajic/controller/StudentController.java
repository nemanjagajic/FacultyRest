package com.nemanjagajic.controller;

import com.nemanjagajic.dao.StudentDAO;
import com.nemanjagajic.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("student")
public class StudentController implements BasicController<Student> {
    @Autowired
    private StudentDAO studentDAO;

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
    public Student post(@RequestBody Student entity) {
        System.out.println(entity);
//        return studentDAO.create(entity);
        return null;
    }

    @Override
    @ResponseBody
    @PutMapping("update/{id}")
    public Student put(@PathVariable("id") Integer id, @RequestBody Student entity) {
        return studentDAO.update(id, entity);
    }

    @Override
    @ResponseBody
    @DeleteMapping("delete/{id}")
    public Student delete(@PathVariable("id") Integer id) {
        return studentDAO.delete(id);
    }
}
