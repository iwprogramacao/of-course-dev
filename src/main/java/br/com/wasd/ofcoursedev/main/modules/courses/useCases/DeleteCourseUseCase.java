package br.com.wasd.ofcoursedev.main.modules.courses.useCases;

import br.com.wasd.ofcoursedev.main.modules.courses.erros.CourseNotFoundError;
import br.com.wasd.ofcoursedev.main.modules.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID id) {
        var course = this.courseRepository.findById(id)
                                          .orElseThrow(() -> new CourseNotFoundError("Curso não encontrado"));

        this.courseRepository.delete(course);
    }
}
