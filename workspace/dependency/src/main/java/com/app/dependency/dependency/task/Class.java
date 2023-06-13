package com.app.dependency.dependency.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data @ToString(exclude = {"teacher"})
@RequiredArgsConstructor
public class Class {
    private final Teacher teacher;
    private List<Student> students = new ArrayList<>();
}
