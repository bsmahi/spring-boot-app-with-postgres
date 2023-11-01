package com.springapp.springbootappwithpostgres.service;

import com.springapp.springbootappwithpostgres.model.Course;
import com.springapp.springbootappwithpostgres.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<List<Course>> findAll() {
        return Optional.of(repository.findAll());
    }

    @Override
    public Optional<List<Course>> findByTitleContaining(String title) {
        return Optional.of(repository.findByTitleContaining(title));
    }

    @Override
    public Optional<Course> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Course> createCourse(Course course) {
        return Optional.of(repository.save(course));
    }

    @Override
    public void deleteAllCourses() {
        repository.deleteAll();
    }

    @Override
    public void deleteCourseById(long id) {
        repository.deleteById(id);
    }
}
