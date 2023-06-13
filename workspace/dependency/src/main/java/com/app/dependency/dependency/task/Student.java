package com.app.dependency.dependency.task;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data @ToString(exclude = {"school"})
@RequiredArgsConstructor
public class Student {
    private final School school;
    private List<Class> classes = new ArrayList<>();
}
