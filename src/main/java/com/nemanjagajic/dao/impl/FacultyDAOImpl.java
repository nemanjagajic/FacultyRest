package com.nemanjagajic.dao.impl;

import com.nemanjagajic.dao.FacultyDAO;
import com.nemanjagajic.model.Faculty;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class FacultyDAOImpl implements FacultyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Faculty> getAll() {
        String hql = "FROM Faculty fac ORDER BY fac.id";
        return (List<Faculty>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Faculty getById(Integer id) {
        Faculty faculty = entityManager.find(Faculty.class, id);

        if (faculty != null) {
            return faculty;
        } else {
            throw new IllegalArgumentException("Faculty with the given id doesn't exist");
        }
    }

    @Override
    public Faculty create(Faculty entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public Faculty update(Integer id, Faculty entity) {
        Faculty faculty = getById(id);
        faculty.setName(entity.getName());
        faculty.setLocation(entity.getLocation());
        faculty.setStudents(entity.getStudents());
        entityManager.flush();
        return faculty;
    }

    @Override
    public Faculty delete(Integer id) {
        Faculty faculty = getById(id);
        entityManager.remove(faculty);
        return faculty;
    }
}
