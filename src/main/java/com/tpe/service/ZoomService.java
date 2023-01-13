package com.tpe.service;

import com.tpe.domain.Course;
import com.tpe.repository.Repository;
import com.tpe.thirdparty.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // prototype da spring bean in life cycle inin tumunden sorumlu degildir.
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

    // thirdparty bir class in methoduna ihtiyacimiz varsa
    @Autowired
    private InstructorService instructorService;

    @Value("${app.code}")
    String code;

    @Override
    public void teachCourse(Course course) {
        System.out.println(code+" - "+course.getName()+" dersi Zoom ile anlatiliyor...");
        instructorService.teach(course.getName(),"Jack Sparrow");
    }

    @Override
    public void saveCourse(Course course) {
        repository.save(course);
    }
}
