package br.com.wasd.ofcoursedev.main.modules.courses.useCases;

import br.com.wasd.ofcoursedev.main.modules.courses.entities.CourseEntity;
import br.com.wasd.ofcoursedev.main.modules.courses.erros.CourseNotFoundError;
import br.com.wasd.ofcoursedev.main.modules.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateActiveCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id, CourseEntity courseEntity) {
        var course = this.courseRepository.findById(id)
                                          .orElseThrow(() -> new CourseNotFoundError("Curso não encontrado"));

        course.setActive(courseEntity.getActive());

        return this.courseRepository.save(course);
    }
}
