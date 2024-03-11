package br.com.wasd.ofcoursedev.main.modules.courses.useCases;

import br.com.wasd.ofcoursedev.main.modules.courses.entities.CourseEntity;
import br.com.wasd.ofcoursedev.main.modules.courses.erros.CourseFoundError;
import br.com.wasd.ofcoursedev.main.modules.courses.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        this.courseRepository.findByName(courseEntity.getName())
                             .ifPresent((corse) -> {
                                 throw new CourseFoundError("Um curso com esse nome já existe.");
                             });
        return this.courseRepository.save(courseEntity);
    }
}
