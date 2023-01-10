package com.tpe.service;

import com.tpe.domain.Course;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ZoomService implements CourseService{

    // field injection
//    @Autowired
//    @Qualifier("cloudRepository")
//    private Repository repository;

    // setter injection

//    private Repository repository;
//
//    @Autowired
//    @Qualifier("cloudRepository")
//    public void setRepository(Repository repository) {
//        this.repository = repository;
//    }

    // constructor injection
    private  Repository repository;

    @Autowired
    public ZoomService(@Qualifier("cloudRepository") Repository repository) {
        this.repository = repository;
    }




    @Override
    public void teachCourse(Course course) {
        System.out.println(course.getName()+" dersi Zoom ile anlatiliyor...");
    }

    @Override
    public void saveCourse(Course course) {
        repository.save(course);
    }
}
