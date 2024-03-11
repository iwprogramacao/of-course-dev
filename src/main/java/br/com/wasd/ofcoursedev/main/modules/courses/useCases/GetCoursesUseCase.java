package br.com.wasd.ofcoursedev.main.modules.courses.useCases;

import br.com.wasd.ofcoursedev.main.modules.courses.entities.CourseEntity;
import br.com.wasd.ofcoursedev.main.modules.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCoursesUseCase {
    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute() {
        return this.courseRepository.findAll();

    }
}
