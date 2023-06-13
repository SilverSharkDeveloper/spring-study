package com.app.dependency.dependency.task;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Slf4j
public class SchoolTests {
    @Autowired
    private School school;

    @Test
    public void schoolTest(){
        List<Student> students = new ArrayList<>(Arrays.asList(new Student(school), new Student(school)));
        List<Teacher> teachers = new ArrayList<>(Arrays.asList(new Teacher(school), new Teacher(school)));
        List<Class> classes = new ArrayList<>(Arrays.asList(new Class(teachers.get(0)), new Class(teachers.get(1))));
        students.forEach(school.getStudents()::add);
        teachers.forEach(school.getTeachers()::add);
        for(int i=0; i<teachers.size(); i++){
            teachers.get(i).getClasses().add(classes.get(i));
        }
        teachers.get(0).getClasses().get(0).getStudents().add(students.get(0));
        teachers.get(1).getClasses().get(0).getStudents().add(students.get(1));
        classes.forEach(school.getClasses()::add);
        log.info(school.toString());
    }
}
