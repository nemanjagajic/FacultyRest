package com.nemanjagajic.controller;

import com.nemanjagajic.dao.FacultyDAO;
import com.nemanjagajic.dao.StudentDAO;
import com.nemanjagajic.model.persistence.Faculty;
import com.nemanjagajic.model.rest.StudentsArrayRequest;
import com.nemanjagajic.model.rest.FacultyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        Faculty facultyDeleted = facultyDAO.delete(id);

        Faculty facultyResponse = new Faculty();
        facultyResponse.setId(facultyDeleted.getId());
        facultyResponse.setName(facultyDeleted.getName());
        facultyResponse.setLocation(facultyDeleted.getLocation());

        return facultyResponse;
    }

    @ResponseBody
    @PostMapping("addStudents/{id}")
    public String addStudents(@PathVariable("id") Integer id, @RequestBody StudentsArrayRequest request) {
        Faculty faculty = facultyDAO.getById(id);

        for (int i = 0; i < request.getStudentsId().length; i++) {
            studentDAO.getById(request.getStudentsId()[i]).setFaculty(faculty);
            studentDAO.update(studentDAO.getById(request.getStudentsId()[i]).getId(), studentDAO.getById(request.getStudentsId()[i]));
        }

        return "Successfully added students";
    }

    @ResponseBody
    @PostMapping("removeStudents/{id}")
    public String removeStudents(@PathVariable("id") Integer id, @RequestBody StudentsArrayRequest request) {

        for (int i = 0; i < request.getStudentsId().length; i++) {
            if(studentDAO.getById(request.getStudentsId()[i]).getFaculty().getId() == id) {
                studentDAO.getById(request.getStudentsId()[i]).setFaculty(null);
            } else {
                return "Students aren't attending given faculty";
            }

            studentDAO.update(studentDAO.getById(request.getStudentsId()[i]).getId(), studentDAO.getById(request.getStudentsId()[i]));
        }

        return "Successfully removed students";
    }
}
