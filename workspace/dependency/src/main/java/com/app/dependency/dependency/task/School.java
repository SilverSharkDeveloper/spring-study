package com.app.dependency.dependency.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class School {
    List<Class> classes = new ArrayList<>();
    List<Teacher> teachers = new ArrayList<>();
    List<Student> students = new ArrayList<>();
}
