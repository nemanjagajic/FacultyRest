package com.nemanjagajic.controller;

import com.nemanjagajic.dao.FacultyDAO;
import com.nemanjagajic.model.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("faculty")
public class FacultyController implements BasicController<Faculty> {

    @Autowired
    private FacultyDAO facultyDAO;

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
    public Faculty post(@RequestBody Faculty entity) {
        return facultyDAO.create(entity);
    }

    @Override
    @ResponseBody
    @PutMapping("update/{id}")
    public Faculty put(@PathVariable("id") Integer id, @RequestBody Faculty entity) {
        return facultyDAO.update(id, entity);
    }

    @Override
    @ResponseBody
    @DeleteMapping("delete/{id}")
    public Faculty delete(@PathVariable("id") Integer id) {
        return facultyDAO.delete(id);
    }
}
