package com.nemanjagajic.dao.impl;

import com.nemanjagajic.dao.StudentDAO;
import com.nemanjagajic.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> getAll() {
        String hql = "FROM Student stud ORDER BY stud.id";
        return (List<Student>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Student getById(Integer id) {
        Student student = entityManager.find(Student.class, id);

        if (student != null) {
            return student;
        } else {
            throw new IllegalArgumentException("Student with the given id doesn't exist");
        }
    }

    @Override
    public Student create(Student entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Student update(Integer id, Student entity) {
        Student student = getById(id);
        student.setName(entity.getName());
        student.setLastName(entity.getLastName());
        student.setFaculty(entity.getFaculty());
        entityManager.flush();
        return student;
    }

    @Override
    public Student delete(Integer id) {
        Student student = getById(id);
        entityManager.remove(student);
        return student;
    }
}
