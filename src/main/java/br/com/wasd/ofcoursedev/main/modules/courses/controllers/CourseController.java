package br.com.wasd.ofcoursedev.main.modules.courses.controllers;

import br.com.wasd.ofcoursedev.main.modules.courses.entities.CourseEntity;
import br.com.wasd.ofcoursedev.main.modules.courses.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;
    @Autowired
    private GetCoursesUseCase getCoursesUseCase;
    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;
    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;
    @Autowired
    private UpdateActiveCourseUseCase updateActiveCourseUseCase;

    @PostMapping("")
    public ResponseEntity<Object> createCourse(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            this.createCourseUseCase.execute(courseEntity);

            return ResponseEntity.ok()
                                 .body(courseEntity);
        } catch (Exception exception) {
            exception.printStackTrace();

            return ResponseEntity.badRequest()
                                 .body(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Object> getCourses() {
        try {
            List<CourseEntity> courses = this.getCoursesUseCase.execute();

            return ResponseEntity.ok()
                                 .body(courses);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest()
                                 .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@Valid @RequestBody CourseEntity courseEntity, @PathVariable String id) {
        try {
            var course = this.updateCourseUseCase.execute(UUID.fromString(id), courseEntity);

            return ResponseEntity.ok()
                                 .body(course);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest()
                                 .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable String id) {
        try {
            this.deleteCourseUseCase.execute(UUID.fromString(id));

            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest()
                                 .body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> patchActiveCourse(@PathVariable String id, @RequestBody CourseEntity courseEntity) {
        try {
            var course = this.updateActiveCourseUseCase.execute(UUID.fromString(id), courseEntity);

            return ResponseEntity.ok().body(course);
        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.badRequest()
                                 .body(e.getMessage());
        }
    }
}
