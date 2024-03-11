package br.com.wasd.ofcoursedev.main.modules.courses.controllers;

import br.com.wasd.ofcoursedev.main.modules.courses.entities.CourseEntity;
import br.com.wasd.ofcoursedev.main.modules.courses.useCases.CreateCourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;
    @PostMapping("")
    private ResponseEntity<Object> createCourse(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            this.createCourseUseCase.execute(courseEntity);

            return ResponseEntity.ok().body(courseEntity);
        } catch (Exception exception) {
            exception.printStackTrace();

            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
