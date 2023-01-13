package com.tpe.app;

import com.tpe.AppConfiguration;
import com.tpe.domain.Course;
import com.tpe.service.CourseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        Course course=new Course();
        course.setName("SQL");

        CourseService service=context.getBean("zoomService",CourseService.class);
        service.teachCourse(course);
        service.saveCourse(course);
        // zoomService i newlemedik rica ettik
        // zoomService de repoya ihtiyacimiz var ancak newlemedik esantiyon geldi

        System.out.println();

        String[] beanNames=context.getBeanDefinitionNames();
        List<String> beanNamesList=new ArrayList<>(Arrays.asList(beanNames));
        beanNamesList.forEach(t-> System.out.println("Bean Name: "+t));

        System.out.println();

        CourseService service2= context.getBean("zoomService", CourseService.class);

    }

}
