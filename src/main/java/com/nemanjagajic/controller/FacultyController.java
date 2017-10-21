package com.nemanjagajic.controller;

import com.nemanjagajic.dao.FacultyDAO;
import com.nemanjagajic.dao.StudentDAO;
import com.nemanjagajic.model.persistence.Faculty;
import com.nemanjagajic.model.persistence.Student;
import com.nemanjagajic.model.rest.FacultyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("faculty")
public class FacultyController implements BasicController<Faculty, FacultyRequest> {

    @Autowired
    private FacultyDAO facultyDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @ResponseBody
    @GetMapping("getAll")
    public List<Faculty> getAll() {
        return facultyDAO.getAll();
    }

    @Override
    @ResponseBody
    @GetMapping("get/{id}")
    public Faculty getById(@PathVariable("id") Integer id) {
        return facultyDAO.getById(id);
    }

    @Override
    @ResponseBody
    @PostMapping("add")
    public Faculty post(@RequestBody FacultyRequest entity) {
        Faculty faculty = new Faculty();
        faculty.setName(entity.getName());
        faculty.setLocation(entity.getLocation());

        return facultyDAO.create(faculty);
    }

    @Override
    @ResponseBody
    @PutMapping("update/{id}")
    public Faculty put(@PathVariable("id") Integer id, @RequestBody FacultyRequest entity) {
        Faculty faculty = new Faculty();
        faculty.setName(entity.getName());
        faculty.setLocation(entity.getLocation());

        return facultyDAO.update(id, faculty);
    }

    @Override
    @ResponseBody
    @DeleteMapping("delete/{id}")
    public Faculty delete(@PathVariable("id") Integer id) {
        return facultyDAO.delete(id);
    }
}
